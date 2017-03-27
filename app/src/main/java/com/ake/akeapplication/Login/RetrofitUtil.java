package com.ake.akeapplication.Login;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 유현석 on 2017-03-14.
 */

public class RetrofitUtil {

    private Retrofit mRetrofit;
    private User_Api mUserApi;

    public RetrofitUtil() {
        this.mRetrofit = new Retrofit.Builder()
                .baseUrl(User_Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();;
        this.mUserApi = mRetrofit.create(User_Api.class);
    }

    public User_Api getmUserApi() {
        return mUserApi;
    }
}
