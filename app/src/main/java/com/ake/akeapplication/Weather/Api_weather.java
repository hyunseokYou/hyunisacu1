package com.ake.akeapplication.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 유현석 on 2017-03-17.
 */

public interface Api_weather {

    String BASE_URL = "https://gist.githubusercontent.com/junsuk5/6b293ac781b038366419ac6e4027abb7/raw/b30deab47a9d2fd04247d9d912df3a9a4f7be8a9/weather.json";

    @GET("weather.json")
    Call<List<Weather_Model>> getWeatherLsit();
}
