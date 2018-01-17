package com.example.ilijaangeleski.lastfm.di.modules;

import com.example.ilijaangeleski.lastfm.api.NetworkApi;
import com.example.ilijaangeleski.lastfm.manager.ArtistManager;
import com.example.ilijaangeleski.lastfm.presenter.ArtistPresenter;
import com.example.ilijaangeleski.lastfm.view.ArtistView;

import java.lang.ref.WeakReference;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ilija Angeleski on 1/17/2018.
 */
@Module
public class ArtistActivityModule {
    WeakReference<ArtistView> view;

    public ArtistActivityModule(ArtistView view){
        this.view=new WeakReference<>(view);
    }

    @Provides
    ArtistPresenter provideArtistPresenter(ArtistManager artistManager){
        return new ArtistPresenter(view,artistManager);
    }

    @Provides
    ArtistManager provideArtistManager(NetworkApi networkApi){
        return new ArtistManager(networkApi);
    }
}
