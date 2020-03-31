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
    @GET("?method=flickr.groups.pools.getPhotos&api_key=708e061b07ea822dc935622973482b72&group_id=96844556%40N00&format=json&nojsoncallback=1&auth_token=72157713696496103-f6a6546b9dd86e56&api_sig=4fce63ec6670f14d682c4cb7c6884034")
    Call<FlickrImageResult> getFlickrImagesBasedOnGroupID();
}
