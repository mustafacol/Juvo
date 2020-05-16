package com.mustafa.juvo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.mustafa.juvo.Model.LoginUser;
import com.mustafa.juvo.R;
import com.mustafa.juvo.databinding.ActivityLoginBinding;
import com.mustafa.juvo.viewmodels.LoginViewModel;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    Intent intent;
    private ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        w.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        binding= DataBindingUtil.setContentView(LoginActivity.this,R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        binding.setLifecycleOwner(this);
        binding.setLoginViewModel(loginViewModel);


        loginViewModel.getUser().observe(this, new Observer<LoginUser>() {
            @Override
            public void onChanged(LoginUser loginUser) {
                if(TextUtils.isEmpty(Objects.requireNonNull(loginUser).getUsername())){
                    binding.username.setError("Lütfen kullanıcı adınızı giriniz");
                    binding.username.requestFocus();


                }
                else if(TextUtils.isEmpty(Objects.requireNonNull(loginUser).getPassword())){
                    binding.password.setError("Lütfen şifresinizi giriniz");
                    binding.password.requestFocus();
                }
                else if(!loginUser.isPasswordLengthGreaterThan5()){
                    binding.password.setError("Şifreniz en az 5 karakter içermelidir");
                    binding.password.requestFocus();
                }
                else{
                    intent= new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);

                }

            }
        });
    }

    public void setKeyboardEvent(View view) {
        InputMethodManager inputMethodManager=(InputMethodManager) getSystemService((Activity.INPUT_METHOD_SERVICE));
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}
