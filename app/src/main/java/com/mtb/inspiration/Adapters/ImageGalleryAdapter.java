package com.mtb.inspiration.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mtb.inspiration.Models.Photo;
import com.mtb.inspiration.R;
import com.mtb.inspiration.ViewHolders.ImageGalleryViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryViewHolder> {
    private List<Photo> photos;

    public ImageGalleryAdapter(ArrayList<Photo> galleryImages){
        photos = galleryImages;
    }

    @NonNull
    @Override
    public ImageGalleryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_image, viewGroup, false);
        ImageGalleryViewHolder igvh = new ImageGalleryViewHolder(itemView);

        return igvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageGalleryViewHolder imageGalleryViewHolder, int i) {
        imageGalleryViewHolder.Update(photos.get(i));
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

}
