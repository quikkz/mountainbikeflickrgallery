package com.mtb.inspiration.ViewHolders;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.mtb.inspiration.Models.Photo;
import com.mtb.inspiration.Models.Photos;
import com.mtb.inspiration.R;


public class ImageGalleryViewHolder extends RecyclerView.ViewHolder {
    private View _itemView;
    private ImageView imageView;

    public ImageGalleryViewHolder(@NonNull View itemView) {
        super(itemView);
        _itemView = itemView;
        imageView = _itemView.findViewById(R.id.row_gallery_IV);
    }

    public void Update(Photo photo){
        String url = "https://farm" + photo.farm + ".staticflickr.com/" + photo.server + "/" + photo.id + "_" + photo.secret + ".jpg";
        Glide.with(itemView.getContext())
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView);
    }
}
