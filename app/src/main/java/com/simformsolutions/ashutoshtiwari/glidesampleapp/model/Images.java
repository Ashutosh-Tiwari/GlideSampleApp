package com.simformsolutions.ashutoshtiwari.glidesampleapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ashutosh.tiwari on 21/07/17.
 * Standard POJO model
 */

public class Images  {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("url")
    @Expose
    private Image image;

    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
