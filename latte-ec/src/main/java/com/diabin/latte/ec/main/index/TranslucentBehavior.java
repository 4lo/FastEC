package com.diabin.latte.ec.main.index;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.diabin.latte.ec.R;
import com.diabin.latte_core.ui.loader.LatteLoader;
import com.diabin.latte_core.ui.recycler.RgbValue;
import com.diabin.latte_core.util.log.LatteLogger;

import java.util.logging.Logger;

@SuppressWarnings("unused")
public class TranslucentBehavior extends CoordinatorLayout.Behavior<Toolbar> {


    private static final String TAG = "ToolbarAlphaBehavior";
    private int offset = 0;
    private int startOffset = 0;
    private int endOffset = 0;
    private Context context;

    //顶部距离
    private int mDistanceY = 0;
    //颜色变化速度
    private static final int SHOW_SPEED = 3;
    //定义变化的颜色
    private final RgbValue RGB_VALUE = RgbValue.create(99, 184, 255);


    public TranslucentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar child, View dependency) {
        return dependency.getId() == R.id.rv_index;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }




//    @Override
//    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
//        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
//
//        mDistanceY += dyConsumed;
//
//
//        //LatteLogger.d("dy",mDistanceY);
//        if(dyUnconsumed != 0){
//            LatteLogger.d("dy",dyUnconsumed);
//        }
//
//        if (type == 1 && dyUnconsumed < 10 && dyUnconsumed > -10) { //&& mDistanceY <= targetHeight) {
//            //final float scale = (float) mDistanceY / 150;
//            child.setBackgroundColor(Color.argb(0, RGB_VALUE.red(), RGB_VALUE.green(), RGB_VALUE.blue()));
//
//        }else if (type == 0 && dyUnconsumed < -10){
//            final float alpha = 255;// - scale * 255;
//            child.setBackgroundColor(Color.argb((int) alpha, RGB_VALUE.red(), RGB_VALUE.green(), RGB_VALUE.blue()));
//        //} else if (mDistanceY > targetHeight) {
//            //child.setBackgroundColor(Color.argb(0,RGB_VALUE.red(), RGB_VALUE.green(), RGB_VALUE.blue()));
//       // }else if (mDistanceY < 20){
//            //final float scale = (float) mDistanceY / targetHeight;
//            //final float alpha = 255 - scale * 255;
//            //child.setBackgroundColor(Color.argb((int) alpha, RGB_VALUE.red(), RGB_VALUE.green(), RGB_VALUE.blue()));
//        }
//    }


    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        startOffset = 0;
        endOffset = 250 - child.getHeight();
        offset += dyConsumed;
        if (offset <= startOffset) {  //alpha为0
            //child.getBackground().setAlpha(0);
            child.getBackground().setAlpha(255);
        } else if (offset > startOffset && offset < endOffset) { //alpha为0到255
            float precent = (float) (offset - startOffset) / endOffset;
            int alpha = Math.round(precent * 255);
            child.getBackground().setAlpha(255 - alpha);
        } else if (offset >= endOffset) {  //alpha为255
            //child.getBackground().setAlpha(255);
            child.getBackground().setAlpha(0);
        }

    }
}