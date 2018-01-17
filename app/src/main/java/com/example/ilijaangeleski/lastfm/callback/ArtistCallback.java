package com.example.ilijaangeleski.lastfm.callback;

import com.example.ilijaangeleski.lastfm.model.Result;
import com.example.ilijaangeleski.lastfm.model.Results;

/**
 * Created by Ilija Angeleski on 1/17/2018.
 */

public interface ArtistCallback {
    void onSuccess(Result response);

    void onFailure(Throwable t);
}
