package com.example.ilijaangeleski.lastfm;

import android.app.Application;

import com.example.ilijaangeleski.lastfm.di.components.DaggerBaseComponent;
import com.example.ilijaangeleski.lastfm.di.modules.AppModule;
import com.example.ilijaangeleski.lastfm.di.components.BaseComponent;
import com.example.ilijaangeleski.lastfm.di.modules.NetworkModule;

/**
 * Created by Ilija Angeleski on 1/17/2018.
 */

public class MyApp extends Application {
    private BaseComponent baseComponent;
    private static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        baseComponent = DaggerBaseComponent
                .builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public BaseComponent getBaseComponent() {
        return baseComponent;
    }

    public static MyApp getApp() {
        return app;
    }
}

