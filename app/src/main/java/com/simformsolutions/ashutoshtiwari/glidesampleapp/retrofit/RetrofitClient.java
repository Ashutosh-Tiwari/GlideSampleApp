package com.simformsolutions.ashutoshtiwari.glidesampleapp.retrofit;

import com.simformsolutions.ashutoshtiwari.glidesampleapp.model.Images;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ashutosh.tiwari on 21/07/17.
 * Retrofit Client Interface
 */

public interface RetrofitClient {
    @GET("/json/glide.json")
    Call<List<Images>> getImages();
}
