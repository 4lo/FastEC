package com.diabin.fastec.example;


import com.diabin.latte_core.activities.ProxyActivity;
import com.diabin.latte_core.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {


    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
