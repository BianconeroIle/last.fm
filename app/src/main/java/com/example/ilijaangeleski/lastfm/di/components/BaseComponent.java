package com.example.ilijaangeleski.lastfm.di.components;

import android.content.Context;

import com.example.ilijaangeleski.lastfm.api.NetworkApi;
import com.example.ilijaangeleski.lastfm.di.modules.AppModule;
import com.example.ilijaangeleski.lastfm.di.modules.NetworkModule;

import dagger.Component;

@Component(modules = {NetworkModule.class, AppModule.class})
public interface BaseComponent {
    Context getContext();

    NetworkApi getNetworkApi();
}