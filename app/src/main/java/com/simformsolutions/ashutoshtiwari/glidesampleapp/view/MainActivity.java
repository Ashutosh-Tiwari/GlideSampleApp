package com.simformsolutions.ashutoshtiwari.glidesampleapp.view;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.simformsolutions.ashutoshtiwari.glidesampleapp.R;
import com.simformsolutions.ashutoshtiwari.glidesampleapp.adapter.GalleryAdapter;
import com.simformsolutions.ashutoshtiwari.glidesampleapp.databinding.ActivityMainBinding;
import com.simformsolutions.ashutoshtiwari.glidesampleapp.retrofit.ImageLoader;
import com.simformsolutions.ashutoshtiwari.glidesampleapp.viewmodel.MyViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.includedLayout.recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        mainBinding.includedLayout.recyclerView.setItemAnimator(new DefaultItemAnimator());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final MyViewModel myViewModel = new MyViewModel();
        myViewModel.fetchImages(new ImageLoader() {
            @Override
            public void onCompleted() {
                mainBinding.includedLayout.recyclerView.setAdapter(new GalleryAdapter(myViewModel.getImages()));
            }
        });
    }

    @BindingAdapter({"image"})
    public static void loadImage(ImageView thumbnail, String imageUrl) {
        Glide.with(thumbnail.getContext())
                .load(imageUrl)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(thumbnail);
    }
}
