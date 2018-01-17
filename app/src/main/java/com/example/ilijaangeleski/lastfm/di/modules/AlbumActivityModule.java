package com.example.ilijaangeleski.lastfm.di.modules;

import com.example.ilijaangeleski.lastfm.api.NetworkApi;
import com.example.ilijaangeleski.lastfm.manager.AlbumManager;
import com.example.ilijaangeleski.lastfm.presenter.AlbumPresenter;
import com.example.ilijaangeleski.lastfm.view.AlbumView;

import java.lang.ref.WeakReference;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ilija Angeleski on 1/17/2018.
 */
@Module
public class AlbumActivityModule {
    WeakReference<AlbumView> view;

    public AlbumActivityModule(AlbumView view){
        this.view = new WeakReference<>(view);
    }

    @Provides
    AlbumPresenter provideAlbumPresenter(AlbumManager albumManager){
        return new AlbumPresenter(view,albumManager);
    }
    @Provides
    AlbumManager provideAlbumManager(NetworkApi networkApi){
        return new AlbumManager(networkApi);
    }
}
