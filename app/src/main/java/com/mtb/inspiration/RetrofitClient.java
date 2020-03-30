package com.mtb.inspiration;
import com.mtb.inspiration.Constants.RequestConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit _retrofitClient = null;
    public static Retrofit Client(){

        if(_retrofitClient == null){
            Retrofit.Builder builder = new Retrofit.Builder();
            _retrofitClient = builder
                    .baseUrl(RequestConstants.URLConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return _retrofitClient;
    }
}
