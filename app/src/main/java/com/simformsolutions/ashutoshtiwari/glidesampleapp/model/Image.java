package com.simformsolutions.ashutoshtiwari.glidesampleapp.model;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.simformsolutions.ashutoshtiwari.glidesampleapp.retrofit.ImageLoader;
import com.simformsolutions.ashutoshtiwari.glidesampleapp.retrofit.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ashutosh.tiwari on 21/07/17.
 * Pojo Model
 */

public class Image {

    ArrayList<Image> images = new ArrayList<>();

    @SerializedName("small")
    @Expose
    private String small;

    @SerializedName("medium")
    @Expose
    private String medium;

    @SerializedName("large")
    @Expose
    private String large;


    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public void fetchImages(final ImageLoader imageLoader) {

        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Call<List<Images>> call = retrofitBuilder.retrofitClient.getImages();

        call.enqueue(new Callback<List<Images>>() {
            @Override
            public void onResponse(Call<List<Images>> call, Response<List<Images>> response) {
                if (response.isSuccessful()) {
                    List<Images> list = response.body();
                    for (Images image : list) {
                        images.add(image.getImage());
                    }
                    imageLoader.onCompleted();
                } else {
                    Log.d("LOG: ", "Error");
                }
            }

            @Override
            public void onFailure(Call<List<Images>> call, Throwable t) {
                Log.d("MainActivity", "Failure");
            }
        });
    }

    public ArrayList<Image> getImageList() {
        return images;
    }
}