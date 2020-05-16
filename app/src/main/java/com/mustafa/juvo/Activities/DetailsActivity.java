package com.mustafa.juvo.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.mustafa.juvo.Commons.Commons;
import com.mustafa.juvo.R;
import com.mustafa.juvo.detailsFragments.ActivityFragment;
import com.mustafa.juvo.detailsFragments.FolderFragment;
import com.mustafa.juvo.detailsFragments.OtherFragment;
import com.mustafa.juvo.detailsFragments.SummaryFragment;

public class DetailsActivity extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    TextView toolbar_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
        setNavigationView();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new SummaryFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.ozet:
                    selectedFragment = new SummaryFragment();
                    break;
                case R.id.dosyalar:
                    selectedFragment = new FolderFragment();
                    break;

                case R.id.aktivite:
                    selectedFragment = new ActivityFragment();
                    break;

                case R.id.diger:
                    selectedFragment = new OtherFragment();

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };


    public void init(){
        navigationView = findViewById(R.id.navigationView);
        drawerLayout=findViewById(R.id.navigation_drawer_details);
        toolbar_title=findViewById(R.id.header_title);
        final NavigationView navigationView = findViewById(R.id.navigationView);

        Window w = getWindow();
        w.setStatusBarColor(Color.rgb(100,155,190));

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        actionBarDrawerToggle= new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        String selectedService=getIntent().getStringExtra("header");
        toolbar_title.setText(selectedService);

    }

    public void setNavigationView(){
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
                        Intent i= new Intent(DetailsActivity.this,LoginActivity.class);
                        startActivity(i);
                        break;
                }

                if(item.getItemId()!=R.id.nav_anasayfa &&item.getItemId()!=R.id.nav_logout){
                    Intent intent= new Intent(DetailsActivity.this,BodyActivity.class);
                    intent.putExtra("selectedFragment",selectedFragment);
                    startActivityForResult(intent, Commons.SINGLEWORKDETAILSTOBODY);
                }

                return true;
            }
        });

    }

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
}
