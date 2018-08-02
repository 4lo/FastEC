package com.diabin.latte_core.net;

import android.content.Context;

import com.diabin.latte_core.net.callback.IError;
import com.diabin.latte_core.net.callback.IFailure;
import com.diabin.latte_core.net.callback.IRequest;
import com.diabin.latte_core.net.callback.ISuccess;
import com.diabin.latte_core.ui.LoaderStyle;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RestClientBuilder {
    private  String mURL;
    private static final Map<String,Object> PARAMS = RestCreator.getParams();
    private  IRequest mIRequest;
    private  ISuccess mISuccess;
    private  IFailure mIFailure;
    private  IError mIError;
    private  RequestBody mBody;
    private Context mContext;
    private LoaderStyle mLoaderStyle;
    private File mFile = null;

    RestClientBuilder() {

    }

    public final RestClientBuilder url(String url){
        this.mURL = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String,Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key,value);
        return this;
    }

    public final RestClientBuilder file (File file) {
        this.mFile = file;
        return this;
    }

    public final RestClientBuilder file (String file) {
        this.mFile = new File(file);
        return this;
    }

    public final RestClientBuilder raw(String raw){
        this.mBody = RequestBody.create(MediaType.parse(("application/json;charset=UTF-8")), raw);
        return this;
    }

    public final RestClientBuilder Onrequest(IRequest iRequest){
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess){
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure){
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError){
        this.mIError = iError;
        return this;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle style){
        this.mContext = context;
        this.mLoaderStyle = style;
        return this;
    }

    public final RestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }
    public final RestClient build() {
        return new RestClient(mURL, PARAMS, mIRequest, mISuccess, mIFailure, mIError, mBody,mFile,mContext,mLoaderStyle);
    }
}
