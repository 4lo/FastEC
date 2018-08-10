package com.diabin.fastec.example;

import android.app.Application;
import com.diabin.latte.ec.icon.FontEcModule;
import com.diabin.latte.ec.database.DatabaseManager;
import com.diabin.latte_core.net.interceptors.DebugInterceptor;
import com.diabin.latte_core.app.Latte;
import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;


public class ExampleApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withLoaderDelayed(1000)
                .withApiHost("http://192.168.123.120/api/")
                .withInterceptor(new DebugInterceptor("index111",R.raw.test))
                .configure();
        //initStetho();
        DatabaseManager.getInstance().init(this);
    }

    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build()
        );
    }
}

