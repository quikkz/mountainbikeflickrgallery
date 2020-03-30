package com.mtb.inspiration.ViewModels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;

import com.mtb.inspiration.Constants.RequestConstants;
import com.mtb.inspiration.Interfaces.IFlickrImageService;
import com.mtb.inspiration.Models.FlickrImageResult;
import com.mtb.inspiration.RetrofitClient;
import com.mtb.inspiration.Utils.RequestUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FlickrImagesViewModel extends BaseViewModel {

    public FlickrImagesViewModel(@NonNull Application application) {
        super(application);
    }

    public FlickrImageResult flickrImageResult;

    public void getFlickrImages(final Context context) {

        Call<FlickrImageResult> getFlickrImages = RetrofitClient.Client().create(IFlickrImageService.class).getFlickrImagesBasedOnGroupID();
        getFlickrImages.enqueue(new Callback<FlickrImageResult>() {

            @Override
            public void onResponse(Call<FlickrImageResult> call, Response<FlickrImageResult> response) {
                int responsecode = response.code();

                if (responsecode == 200 && response.body().code == 0) {
                    flickrImageResult = response.body();
                    SuccessMLD.setValue("");
                } else {
                    String errorMessage = RequestUtils.getErrorMessageBasedOnErrorCode(response.body().code);
                    if(errorMessage == ""){
                        errorMessage = "Unknown error, please try again later";
                    }
                    ErrorMLD.setValue(errorMessage);
                }
            }

            @Override
            public void onFailure(Call<FlickrImageResult> call, Throwable t) {
                if (!RequestUtils.isNetworkAvailable(context)) {
                    ErrorMLD.setValue("It looks like your device has no connection right now, check the connection and try again.");
                }
                else
                {
                    ErrorMLD.setValue("Unknown error, please try again later");
                }
            }
        });
    }
}
