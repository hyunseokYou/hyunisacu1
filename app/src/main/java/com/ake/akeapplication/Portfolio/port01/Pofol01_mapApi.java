package com.ake.akeapplication.Portfolio.port01;

import com.ake.akeapplication.Portfolio.port01.Forecast.Pofol01_Model2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 유현석 on 2017-03-17.
 */

public interface Pofol01_mapApi {
    String API_KEY = "f483fcc0ddd60cbcc4fb17c53e81cd1c";
    String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    @GET("weather")
    Call<Pofol01_Model1> getWeaherData(@Query("APPID") String appId,
                                       @Query("lon") double lon,
                                       @Query("lat") double lat);

    @GET("forecast")
    Call<Pofol01_Model2> getForecastData(@Query("APPID") String appId,
                                         @Query("lon") double lon,
                                         @Query("lat") double lat);




}
