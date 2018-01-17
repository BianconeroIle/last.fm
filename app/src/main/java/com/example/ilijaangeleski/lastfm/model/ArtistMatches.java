
package com.example.ilijaangeleski.lastfm.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtistMatches {

    @SerializedName("artist")
    private List<Artist> artist = null;

    public List<Artist> getArtists() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }

}
