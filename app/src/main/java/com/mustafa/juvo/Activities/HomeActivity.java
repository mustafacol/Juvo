package com.mustafa.juvo.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.google.android.material.navigation.NavigationView;
import com.mustafa.juvo.Commons.Commons;
import com.mustafa.juvo.R;

public class HomeActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    ImageButton button;
    RelativeLayout isListeleriButton;
    Fragment selectedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        navigationView = findViewById(R.id.navigationView);
        drawerLayout=findViewById(R.id.navigation_drawer_home);
        button=findViewById(R.id.button);
        isListeleriButton=findViewById(R.id.anasayfa_button);

        isListeleriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this,BodyActivity.class);
                intent.putExtra("selectedFragment","İş Listelerim");
                startActivityForResult(intent, Commons.HOMETOBODY);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        actionBarDrawerToggle= new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            String selectedFragment;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_anasayfa:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.nav_duyuru:
                        selectedFragment= "Duyurular";
                        break;
                    case R.id.nav_isListesi:
                        selectedFragment= "İş Listelerim";
                        break;
                    case R.id.nav_vakaArama:
                        selectedFragment= "Vaka Arama";
                        break;
                    case R.id.nav_yeniCagri:
                        selectedFragment= "Yeni Çağrı";
                        break;
                    case R.id.nav_logout:
                        Intent i= new Intent(HomeActivity.this,LoginActivity.class);
                        startActivity(i);
                        break;
                }



                if(item.getItemId()!=R.id.nav_anasayfa &&item.getItemId()!=R.id.nav_logout){
                    Intent intent= new Intent(HomeActivity.this,BodyActivity.class);
                    intent.putExtra("selectedFragment",selectedFragment);
                    startActivityForResult(intent, Commons.HOMETOBODY);
                }

                return true;
            }
        });
    }


}
