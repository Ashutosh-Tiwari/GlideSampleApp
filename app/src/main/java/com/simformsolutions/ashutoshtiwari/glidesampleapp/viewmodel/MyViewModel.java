package com.simformsolutions.ashutoshtiwari.glidesampleapp.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.simformsolutions.ashutoshtiwari.glidesampleapp.model.Image;
import com.simformsolutions.ashutoshtiwari.glidesampleapp.retrofit.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Ashutosh.tiwari on 24/07/17.
 * Custom View Model class
 */

public class MyViewModel extends BaseObservable {

    private Image image;

    public MyViewModel() {
        image = new Image();
    }

    public MyViewModel(Image image) {
        this.image = image;
    }

    @Bindable
    public String getImageUrl() {
        return image.getMedium();
    }

    public void fetchImages(ImageLoader imageLoader) {
        image.fetchImages(imageLoader);
    }

    public ArrayList<Image> getImages() {
        return image.getImageList();
    }
}
