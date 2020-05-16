package com.mustafa.juvo;

import com.mustafa.juvo.Model.LoginUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("login.php")
    Call<String> performLogin(@Query("username") String username,@Query("password") String password);

}
