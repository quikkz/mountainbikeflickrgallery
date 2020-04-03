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
    @GET("?method=flickr.groups.pools.getPhotos&api_key=9d917c77afdd07ec80e68a6f8758abbc&group_id=96844556%40N00&format=json&nojsoncallback=1&auth_token=72157713735425537-e6697186e1ebe1e6&api_sig=ff0365b1c83f6e61f695e0c6c46d64e1")
    Call<FlickrImageResult> getFlickrImagesBasedOnGroupID();
}
