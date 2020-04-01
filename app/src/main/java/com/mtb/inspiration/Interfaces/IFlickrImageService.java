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
    @GET("?method=flickr.groups.pools.getPhotos&api_key=c6dfba0732a584316e0a995683df68be&group_id=96844556%40N00&format=json&nojsoncallback=1&auth_token=72157713708752056-d65c8e579c17f66f&api_sig=4302a3b1bd1a152f8ffc926bd0cb5ef8")
    Call<FlickrImageResult> getFlickrImagesBasedOnGroupID();
}
