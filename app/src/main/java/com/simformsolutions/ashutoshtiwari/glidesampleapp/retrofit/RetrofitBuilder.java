package com.simformsolutions.ashutoshtiwari.glidesampleapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ashutosh.tiwari on 21/07/17.
 * Standard retrofit builder class
 */

public class RetrofitBuilder {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.androidhive.info")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RetrofitClient retrofitClient = retrofit.create(RetrofitClient.class);
}
