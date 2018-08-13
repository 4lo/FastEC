package com.diabin.fastec.example;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.diabin.latte.ec.launcher.LauncherDelegate;

import com.diabin.latte.ec.main.EcBottomDelegate;
import com.diabin.latte.ec.sign.ISignListener;
import com.diabin.latte_core.activities.ProxyActivity;
import com.diabin.latte_core.delegates.LatteDelegate;
import com.diabin.latte_core.ui.launcher.ILauncherListener;
import com.diabin.latte_core.ui.launcher.OnLauncherFinishTag;
import com.diabin.latte_core.ui.recycler.RgbValue;

import qiu.niorgai.StatusBarCompat;

import static android.graphics.Color.*;

public class ExampleActivity extends ProxyActivity implements ISignListener, ILauncherListener{

    private final RgbValue RGB_VALUE = RgbValue.create(99, 184, 255);
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        StatusBarCompat.setStatusBarColor(this, Color.rgb(RGB_VALUE.red(),RGB_VALUE.green(),RGB_VALUE.blue()), 0);
        //StatusBarCompat.translucentStatusBar(this,true);
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new EcBottomDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "sign in successfully",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "sign up successfully",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                Toast.makeText(this,"启动结束，signed in",Toast.LENGTH_LONG).show();
                startWithPop(new EcBottomDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this,"启动结束，not signed in",Toast.LENGTH_LONG).show();
                startWithPop(new EcBottomDelegate());
                break;
            default:
                break;
        }
    }
}
