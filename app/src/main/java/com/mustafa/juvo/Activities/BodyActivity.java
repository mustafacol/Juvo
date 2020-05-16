package com.mustafa.juvo.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.mustafa.juvo.R;
import com.mustafa.juvo.bodyFragments.DuyurularFragment;
import com.mustafa.juvo.bodyFragments.IsListelerimFragment;
import com.mustafa.juvo.bodyFragments.VakaAramaFragment;
import com.mustafa.juvo.bodyFragments.YeniCagriFragment;

public class BodyActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    FrameLayout fragmentContainer;
    Fragment selectedFragment;
    Intent intent;
    TextView toolbar_title;
    String selectedPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);


        navigationView = findViewById(R.id.navigationView);
        drawerLayout=findViewById(R.id.navigation_drawer_body);
        fragmentContainer = findViewById(R.id.fragment_container);
        toolbar_title=findViewById(R.id.header_title);

        Window w = getWindow();
        w.setStatusBarColor(Color.rgb(100,155,190));


        selectedPage=getIntent().getStringExtra("selectedFragment");
        Fragment page= getselectedPage(selectedPage);
        toolbar_title.setText(selectedPage);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,page).commitNow();


        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        actionBarDrawerToggle= new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        final NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectedFragment=null;

                switch (item.getItemId()){
                    case R.id.nav_anasayfa:
                        Intent intent= new Intent(BodyActivity.this,HomeActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_duyuru:
                        selectedFragment= DuyurularFragment.newInstance();
                        toolbar_title.setText("Duyurular");
                        break;
                    case R.id.nav_isListesi:
                        selectedFragment= IsListelerimFragment.newInstance();
                        toolbar_title.setText("İş Listelerim");
                        break;
                    case R.id.nav_vakaArama:
                        selectedFragment= VakaAramaFragment.newInstance();
                        toolbar_title.setText("Vaka Arama");
                        break;
                    case R.id.nav_yeniCagri:
                        selectedFragment= YeniCagriFragment.newInstance();
                        toolbar_title.setText("Yeni Çağrı");
                        break;

                    case R.id.nav_logout:
                        finish();
                        Intent i= new Intent(BodyActivity.this,LoginActivity.class);
                        startActivity(i);
                        break;
                }

                if(item.getItemId()!=R.id.nav_anasayfa){
                                      Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            drawerLayout.closeDrawer(Gravity.LEFT,true);
                        }
                    }, 200);
                    getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,selectedFragment).commit();


                }

                return true;
            }
        });


    }

   /* protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);




    }*/

    public void onClick(View view){

        switch (view.getId()){
            case R.id.optionsButton:

                drawerLayout.openDrawer(Gravity.LEFT,true);
                break;

            case R.id.homeButton:
                Intent intent= new Intent(this,HomeActivity.class);
                startActivity(intent);


        }
    }

    public Fragment getselectedPage(String fragmentName){
        Fragment selectedPage= null;

        switch (fragmentName){
            case "Duyurular":
                selectedPage=DuyurularFragment.newInstance();
                break;
            case "İş Listelerim":
                selectedPage=IsListelerimFragment.newInstance();
                break;
            case "Vaka Arama":
                selectedPage=VakaAramaFragment.newInstance();
                break;
            case "Yeni Çağrı":
                selectedPage=YeniCagriFragment.newInstance();
                break;
        }


        return selectedPage;


    }
}
