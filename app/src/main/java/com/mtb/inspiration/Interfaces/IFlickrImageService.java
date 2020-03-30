package com.mtb.inspiration.Interfaces;

import com.mtb.inspiration.Constants.RequestConstants;
import com.mtb.inspiration.Models.FlickrImageResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IFlickrImageService {
    @GET("?method=flickr.groups.pools.getPhotos&api_key=902e6435893b56351c894be1a213ecbd&group_id=96844556%40N00&format=json&nojsoncallback=1&auth_token=72157713683420368-ea7737875a308a72&api_sig=a40f5eb1a359b779d2c9f6e290ec25f7")
    Call<FlickrImageResult> getFlickrImagesBasedOnGroupID();
}
