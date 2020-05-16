package com.mustafa.juvo.Model;

import com.google.gson.annotations.SerializedName;

public class LoginUser {
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;


    public LoginUser(String strUsername, String strPassword) {
        this.username = strUsername;
        this.password = strPassword;
    }



    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isPasswordLengthGreaterThan5() {
        return getPassword().length() > 5;
    }
}