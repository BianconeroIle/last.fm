package com.example.ilijaangeleski.lastfm.manager;

import android.util.Log;

import com.example.ilijaangeleski.lastfm.api.NetworkApi;
import com.example.ilijaangeleski.lastfm.callback.ArtistCallback;
import com.example.ilijaangeleski.lastfm.model.Result;
import com.example.ilijaangeleski.lastfm.model.Results;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ilija Angeleski on 1/17/2018.
 */

public class ArtistManager {
    private NetworkApi networkApi;
    private String format = "json";

    public ArtistManager(NetworkApi networkApi) {
        this.networkApi = networkApi;
    }

    public void fetchArtists(String query,final ArtistCallback callback){
        networkApi.fetchArtist(query,NetworkApi.API_KEY,format).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.d("fetchArtists","onResponse");
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                callback.onFailure(t);
                Log.d("fetchArtists","onFailure");
            }
        });
    }
}
