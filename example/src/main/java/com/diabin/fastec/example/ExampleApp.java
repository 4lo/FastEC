package com.diabin.fastec.example;

import android.app.Application;



import com.diabin.latte_core.net.interceptors.DebugInterceptor;
import com.diabin.latte_core.app.Latte;
import com.joanzapata.iconify.fonts.FontAwesomeModule;


public class ExampleApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                //.withIcon(new FontEcmodule())
                .withLoaderDelayed(1000)
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
                .withApiHost("http://127.0.0.1")

                .configure()
        ;
    }
}
