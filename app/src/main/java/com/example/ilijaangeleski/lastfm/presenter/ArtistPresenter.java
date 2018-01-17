package com.example.ilijaangeleski.lastfm.presenter;

import com.example.ilijaangeleski.lastfm.callback.ArtistCallback;
import com.example.ilijaangeleski.lastfm.manager.ArtistManager;
import com.example.ilijaangeleski.lastfm.model.Artist;
import com.example.ilijaangeleski.lastfm.model.Result;
import com.example.ilijaangeleski.lastfm.model.Results;
import com.example.ilijaangeleski.lastfm.view.ArtistView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilija Angeleski on 1/17/2018.
 */

public class ArtistPresenter {
    private ArtistManager artistManager;
    private WeakReference<ArtistView> artistViewWeakReference;
    private List<Artist> artists = new ArrayList<>();

    public ArtistPresenter(WeakReference<ArtistView> view, ArtistManager artistManager) {
        this.artistManager = artistManager;
        this.artistViewWeakReference = view;
    }

    public void onTextChange(final String query) {
        artistManager.fetchArtists(query, new ArtistCallback() {
            @Override
            public void onSuccess(Result response) {
                ArtistView view = artistViewWeakReference.get();
                if (view != null) {
                    if (response != null && response.getResults() != null && response.getResults().getArtistMatches() != null) {
                        artists.clear();
                        artists.addAll(response.getResults().getArtistMatches().getArtists());
                        view.updateView();
                    } else {
                        artists.clear();
                        view.updateView();
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                ArtistView view = artistViewWeakReference.get();
                if (view != null) {
                    view.showErrorGettingRepositories();
                }
            }
        });
    }


    public List<Artist> getArtists() {
        return artists;
    }
}
