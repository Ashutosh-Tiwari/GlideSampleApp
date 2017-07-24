package com.simformsolutions.ashutoshtiwari.glidesampleapp.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.simformsolutions.ashutoshtiwari.glidesampleapp.R;
import com.simformsolutions.ashutoshtiwari.glidesampleapp.databinding.GalleryThumbnailBinding;
import com.simformsolutions.ashutoshtiwari.glidesampleapp.model.Image;
import com.simformsolutions.ashutoshtiwari.glidesampleapp.viewmodel.MyViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashutosh.tiwari on 21/07/17.
 * Adapter for inflating image items into the recycler view
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {

    private List<Image> images;

    public GalleryAdapter(ArrayList<Image> images) {
        this.images = images;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GalleryThumbnailBinding thumbnailBinding;

        thumbnailBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.gallery_thumbnail,
                parent,
                false
        );
        return new MyViewHolder(thumbnailBinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        GalleryThumbnailBinding thumbnailBinding;
        thumbnailBinding = holder.thumbnailBinding;
        thumbnailBinding.setMyViewModel(new MyViewModel(images.get(position)));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private GalleryThumbnailBinding thumbnailBinding;

        private MyViewHolder(GalleryThumbnailBinding thumbnailBinding) {
            super(thumbnailBinding.getRoot());
            this.thumbnailBinding = thumbnailBinding;
        }
    }
}
