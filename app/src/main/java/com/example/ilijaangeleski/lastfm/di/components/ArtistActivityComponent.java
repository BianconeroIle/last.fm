package com.example.ilijaangeleski.lastfm.di.components;

import com.example.ilijaangeleski.lastfm.di.modules.ArtistActivityModule;
import com.example.ilijaangeleski.lastfm.ui.ArtistActivity;

import dagger.Component;

/**
 * Created by Ilija Angeleski on 1/17/2018.
 */
@Component(modules = ArtistActivityModule.class,dependencies =  BaseComponent.class )
public interface ArtistActivityComponent {
    void inject(ArtistActivity activity);
}
