package com.example.ilijaangeleski.lastfm.di.components;

import com.example.ilijaangeleski.lastfm.di.modules.AlbumActivityModule;
import com.example.ilijaangeleski.lastfm.ui.AlbumsActivity;

import dagger.Component;

/**
 * Created by Ilija Angeleski on 1/17/2018.
 */
@Component(modules = AlbumActivityModule.class,dependencies = BaseComponent.class)
public interface AlbumActivityComponent {
    void inject(AlbumsActivity activity);
}
