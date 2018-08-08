package com.diabin.latte.ec.main;

import android.graphics.Color;

import com.diabin.latte.ec.main.index.IndexDelegate;
import com.diabin.latte_core.delegates.button.BaseButtonDelegate;
import com.diabin.latte_core.delegates.button.BottomItemDelegate;
import com.diabin.latte_core.delegates.button.BottomTabBean;
import com.diabin.latte_core.delegates.button.ItemBuilder;

import java.util.LinkedHashMap;

public class EcBottomDelegate extends BaseButtonDelegate {


    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean,BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}","首页"),new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}","分类"),new IndexDelegate());
        items.put(new BottomTabBean("{fa-compass}","发现"),new IndexDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}","购物车"),new IndexDelegate());
        items.put(new BottomTabBean("{fa-user}","我的"),new IndexDelegate());

        return builder.addItem(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
