
package com.example.ilijaangeleski.lastfm.model;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("results")
    private Results results;

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

}
