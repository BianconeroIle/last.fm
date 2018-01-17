package com.example.ilijaangeleski.lastfm.api;

import com.example.ilijaangeleski.lastfm.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ilija Angeleski on 1/17/2018.
 */

public interface NetworkApi {

    String BASE_URL = "http://ws.audioscrobbler.com/2.0/";
    String API_KEY = "fd16f687aad33b07a3c80f8c1e4eb970";

    //http://ws.audioscrobbler.com/2.0/?method=artist.search&artist=cher&api_key=fd16f687aad33b07a3c80f8c1e4eb970&format=json

    @GET("?method=artist.search")
    Call<Results> fetchArtist(@Query("artist") String query, @Query("api_key") String apiKey,@Query("format") String json);

    //http://ws.audioscrobbler.com/2.0/?method=artist.gettopalbums&artist=cher&api_key=fd16f687aad33b07a3c80f8c1e4eb970&format=json



}
