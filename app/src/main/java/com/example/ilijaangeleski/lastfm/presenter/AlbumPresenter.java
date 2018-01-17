package com.example.ilijaangeleski.lastfm.presenter;

import com.example.ilijaangeleski.lastfm.manager.AlbumManager;
import com.example.ilijaangeleski.lastfm.view.AlbumView;

import java.lang.ref.WeakReference;

/**
 * Created by Ilija Angeleski on 1/17/2018.
 */

public class AlbumPresenter {
    private AlbumManager albumManager;
    private WeakReference<AlbumView> albumViewWeakReference;

    public AlbumPresenter(WeakReference<AlbumView> view, AlbumManager albumManager){
        this.albumManager=albumManager;
        this.albumViewWeakReference=view;
    }

}
