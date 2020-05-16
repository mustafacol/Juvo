package com.mustafa.juvo.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.mustafa.juvo.Adapters.IsListelerimAdapter;
import com.mustafa.juvo.Adapters.SingleWorkDetailAdapter;
import com.mustafa.juvo.Commons.Commons;
import com.mustafa.juvo.Model.SingleWork;
import com.mustafa.juvo.Model.WorkList;
import com.mustafa.juvo.R;
import com.mustafa.juvo.bodyFragments.DuyurularFragment;
import com.mustafa.juvo.bodyFragments.IsListelerimFragment;
import com.mustafa.juvo.bodyFragments.VakaAramaFragment;
import com.mustafa.juvo.bodyFragments.YeniCagriFragment;
import com.mustafa.juvo.viewmodels.SingleWorkDetailsViewModel;

import java.util.ArrayList;
import java.util.List;

public class SingleWorkDetailActivity extends AppCompatActivity {

    SingleWorkDetailsViewModel mViewmodel;
    RecyclerView recyclerView;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    SingleWorkDetailAdapter adapter;
    TextView toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_work_detail);
        init();
        setNavigationView();

        toolbar_title.setText(getIntent().getStringExtra("header"));

        mViewmodel= ViewModelProviders.of(this).get(SingleWorkDetailsViewModel.class);

        mViewmodel.getMutableLiveData().observe(this, new Observer<List<SingleWork>>() {
            @Override
            public void onChanged(List<SingleWork> singleWorks) {
                adapter= new SingleWorkDetailAdapter(SingleWorkDetailActivity.this, (ArrayList<SingleWork>) singleWorks);
                recyclerView.setLayoutManager(new LinearLayoutManager(SingleWorkDetailActivity.this));
                recyclerView.setAdapter(adapter);
            }
        });






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
                        Intent i= new Intent(SingleWorkDetailActivity.this,LoginActivity.class);
                        startActivity(i);
                        break;
                }

                if(item.getItemId()!=R.id.nav_anasayfa &&item.getItemId()!=R.id.nav_logout){
                    Intent intent= new Intent(SingleWorkDetailActivity.this,BodyActivity.class);
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

    public void init(){
        recyclerView=findViewById(R.id.singleworkdetail_recyclerview);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout=findViewById(R.id.navigation_drawer_singleWorkDetail);
        toolbar_title=findViewById(R.id.header_title);

        Window w = getWindow();
        w.setStatusBarColor(Color.rgb(100,155,190));

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        actionBarDrawerToggle= new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        final NavigationView navigationView = findViewById(R.id.navigationView);
    }
}
