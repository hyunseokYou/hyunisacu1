package com.ake.akeapplication.Login;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 유현석 on 2017-03-14.
 */

public interface User_Api {

    String BASE_URL = "http://suwonsmartapp.iptime.org/test/hyunseok";

    @GET("login.php")
    Call<Result_Model> login(@Query("email") String email,
                             @Query("password") String password);

}
