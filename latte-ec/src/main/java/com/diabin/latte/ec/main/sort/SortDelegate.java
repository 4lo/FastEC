package com.diabin.latte.ec.main.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.diabin.latte.ec.R;
import com.diabin.latte.ec.main.sort.content.ContentDelegate;
import com.diabin.latte.ec.main.sort.list.VerticalListDelegate;
import com.diabin.latte_core.delegates.LatteDelegate;
import com.diabin.latte_core.delegates.button.BottomItemDelegate;

public class SortDelegate extends BottomItemDelegate{

    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {


    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        final VerticalListDelegate listDelegate = new VerticalListDelegate();
        getSupportDelegate().loadRootFragment(R.id.vertical_list_container, listDelegate);
        //loadRootFragment(R.id.vertical_list_container, listDelegate);
        getSupportDelegate().loadRootFragment(R.id.sort_content_container, ContentDelegate.newInstance(1));
    }
}
