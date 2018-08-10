package com.diabin.latte.ec.main.index;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.diabin.latte.ec.R;
import com.diabin.latte.ec.R2;
import com.diabin.latte_core.delegates.button.BottomItemDelegate;
import com.diabin.latte_core.net.RestClient;
import com.diabin.latte_core.net.callback.ISuccess;
import com.diabin.latte_core.ui.recycler.MultipleFields;
import com.diabin.latte_core.ui.recycler.MultipleItemEntity;
import com.diabin.latte_core.ui.refresh.RefreshHandler;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.ArrayList;

import butterknife.BindView;

public class IndexDelegate extends BottomItemDelegate{

    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerView = null;

    @BindView(R2.id.srl_index)
    SwipeRefreshLayout mRefreshLayout = null;

    @BindView(R2.id.tb_index)
    Toolbar mToolbar = null;

    @BindView(R2.id.icon_index_scan)
    IconTextView mIconScan = null;

    @BindView(R2.id.et_search_view)
    AppCompatEditText mSearchView = null;


    private RefreshHandler mRefreshHandler = null;


    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mRefreshHandler = new RefreshHandler(mRefreshLayout);
        RestClient.builder()
                .url("index.php")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final IndexDataConverter converter = new IndexDataConverter();
                        converter.setJsonData(response);
                        final ArrayList<MultipleItemEntity> list = converter.convert();
                        final String image = list.get(1).getField(MultipleFields.IMAGE_URL);
                        Toast.makeText(getContext(),image,Toast.LENGTH_LONG).show();
                    }
                })
                .build()
                .get();
    }


    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        mRefreshLayout.setProgressViewOffset(true,120,300);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
        //mRefreshHandler.firstPage("index.php");
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_index ;
    }


}
