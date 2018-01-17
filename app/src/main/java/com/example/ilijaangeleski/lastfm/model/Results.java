
package com.example.ilijaangeleski.lastfm.model;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("opensearch:Query")
    private OpensearchQuery opensearchQuery;
    @SerializedName("opensearch:totalResults")
    private String opensearchTotalResults;
    @SerializedName("opensearch:startIndex")
    private String opensearchStartIndex;
    @SerializedName("opensearch:itemsPerPage")
    private String opensearchItemsPerPage;
    @SerializedName("artistmatches")
    private ArtistMatches artistMatches;

    public OpensearchQuery getOpensearchQuery() {
        return opensearchQuery;
    }

    public void setOpensearchQuery(OpensearchQuery opensearchQuery) {
        this.opensearchQuery = opensearchQuery;
    }

    public String getOpensearchTotalResults() {
        return opensearchTotalResults;
    }

    public void setOpensearchTotalResults(String opensearchTotalResults) {
        this.opensearchTotalResults = opensearchTotalResults;
    }

    public String getOpensearchStartIndex() {
        return opensearchStartIndex;
    }

    public void setOpensearchStartIndex(String opensearchStartIndex) {
        this.opensearchStartIndex = opensearchStartIndex;
    }

    public String getOpensearchItemsPerPage() {
        return opensearchItemsPerPage;
    }

    public void setOpensearchItemsPerPage(String opensearchItemsPerPage) {
        this.opensearchItemsPerPage = opensearchItemsPerPage;
    }

    public ArtistMatches getArtistMatches() {
        return artistMatches;
    }

    public void setArtistMatches(ArtistMatches artistMatches) {
        this.artistMatches = artistMatches;
    }
}
