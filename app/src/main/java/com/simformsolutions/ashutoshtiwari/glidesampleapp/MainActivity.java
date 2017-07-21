package com.simformsolutions.ashutoshtiwari.glidesampleapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.simformsolutions.ashutoshtiwari.glidesampleapp.adapter.GalleryAdapter;
import com.simformsolutions.ashutoshtiwari.glidesampleapp.model.Image;
import com.simformsolutions.ashutoshtiwari.glidesampleapp.model.Images;
import com.simformsolutions.ashutoshtiwari.glidesampleapp.retrofit.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private String TAG = MainActivity.class.getSimpleName();
    private ArrayList<Image> images;
    private ProgressDialog pDialog;
    private GalleryAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        pDialog = new ProgressDialog(this);
        images = new ArrayList<>();
        mAdapter = new GalleryAdapter(getApplicationContext(), images);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        fetchImages();
    }

    private void fetchImages() {

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
                } else {
                    Log.d("LOG: ", "Error");
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Images>> call, Throwable t) {
                Log.d("MainActivity", "Failure");
            }
        });
    }
}
