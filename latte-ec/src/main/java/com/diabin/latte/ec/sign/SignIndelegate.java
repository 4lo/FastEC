package com.diabin.latte.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.diabin.latte.ec.R;
import com.diabin.latte.ec.R2;
import com.diabin.latte_core.delegates.LatteDelegate;

import butterknife.BindView;
import butterknife.OnClick;

public class SignIndelegate extends LatteDelegate{

    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn() {
        if (checkForm()) {
            Toast.makeText(getContext(),"验证通过",Toast.LENGTH_SHORT);
        }
    }

    @OnClick(R2.id.icon_sign_in_wechat)
    void onClickWechat(){

    }

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLink(){
        start(new SignUpDelegate());
    }

    private boolean checkForm() {
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();

        boolean isPass = true;

        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("请输入合法邮箱");
            isPass = false;
        } else {
            mEmail.setError(null);
        }


        if (password.isEmpty() || password.length() < 6){
            mPassword.setError("至少六位数密码");
            isPass = false;
        }else {
            mPassword.setError(null);
        }



        return isPass;
    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
