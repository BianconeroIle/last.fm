
package com.example.ilijaangeleski.lastfm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Image implements Serializable{

    @SerializedName("#image")
    private String image;
    @SerializedName("size")
    private String size;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
