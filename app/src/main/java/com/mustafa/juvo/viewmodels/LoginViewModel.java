package com.mustafa.juvo.viewmodels;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mustafa.juvo.Activities.LoginActivity;
import com.mustafa.juvo.ApiClient;
import com.mustafa.juvo.ApiInterface;
import com.mustafa.juvo.Model.LoginUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginViewModel extends ViewModel {
    public MutableLiveData<String> username= new MutableLiveData<>();
    public MutableLiveData<String> password= new MutableLiveData<>();
    private ApiInterface apiInterface;
    public MutableLiveData<Boolean> response= new MutableLiveData<>();

    private MutableLiveData<LoginUser> userMutableLiveData;

    public MutableLiveData<LoginUser> getUser(){
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }

    public void myOnClick(View view) {

        LoginUser loginUser = new LoginUser(username.getValue(), password.getValue());
/*
        *//*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();*//*
        Retrofit retrofit =ApiClient.getApiClient();
        apiInterface=retrofit.create(ApiInterface.class);

        Call<String> login=apiInterface.performLogin(loginUser.getUsername(),loginUser.getPassword());

        login.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.body().equals("ok")){

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

        //loginUser(username.getValue(),password.getValue());*/

        userMutableLiveData.setValue(loginUser);

    }

   /* public void loginUser(String username,String password){
        ApiInterface apiInterface= ApiClient.getApiClient().create(ApiInterface.class);

        Call<LoginUser> login=apiInterface.performLogin(username,password);

        login.enqueue(new Callback<LoginUser>() {
            @Override
            public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {

                if(response.body().getStrUsername()!=null){
                    ///Toast.makeText(, "Login Succesful", Toast.LENGTH_SHORT).show();
                    isSuccesfull=true;
                }
            }

            @Override
            public void onFailure(Call<LoginUser> call, Throwable t) {

            }
        });
    }*/


}
