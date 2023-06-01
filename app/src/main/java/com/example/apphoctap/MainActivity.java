package com.example.apphoctap;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.apphoctap.fragment.ChuCaiFragment;
import com.example.apphoctap.fragment.ChuSoFragment;
import com.example.apphoctap.fragment.HoSoFragment;
import com.example.apphoctap.fragment.MauSacFragment;
import com.example.apphoctap.fragment.MeoFragment;
import com.example.apphoctap.fragment.SupportFragment;
import com.example.apphoctap.fragment.trangchu;
import com.example.apphoctap.model.User;
import com.google.android.material.navigation.NavigationView;
import com.example.apphoctap.fragment.HinhHocFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, trangchu.CommunicationInterface {

    private DrawerLayout drawerLayout;
    private TextView textViewname,tvemail;

    public static User user;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        user = (User) intent.getExtras().get("User");



        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        View header = navigationView.getHeaderView(0);
        textViewname = header.findViewById(R.id.nametv);
        textViewname.setText(user.getUserName());

        tvemail = header.findViewById(R.id.emailtv);
        tvemail.setText(user.getEmail());


        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new trangchu()).commit();
            navigationView.setCheckedItem(R.id.nav_chucai);
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_chucai:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChuCaiFragment(),null).addToBackStack(null).commit();
                break;
            case R.id.nav_trangchu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new trangchu(),null).addToBackStack(null).commit();
                break;

            case R.id.nav_chuso:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChuSoFragment(),null).addToBackStack(null).commit();
                break;


            case R.id.nav_hinhhoc:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MauSacFragment(),null).addToBackStack(null).commit();
                break;
            case R.id.nav_hoso:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HoSoFragment(),null).addToBackStack(null).commit();
                break;
            case R.id.nav_meo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MeoFragment(),null).addToBackStack(null).commit();
                break;

            case R.id.nav_support:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SupportFragment(),null).addToBackStack(null).commit();
                break;

            case R.id.nav_doan:
               // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HoSoFragment()).commit();
                Intent intent = new Intent(getApplicationContext(),GhepTuActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_toanhoc:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ToanHocFragment()).commit();
                Intent intent1 = new Intent(getApplicationContext(),QuizzActivity.class);
                startActivity(intent1);
                break;
            case R.id.nav_logout:
               finish();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClickTopFragment(String str) {
        switch (str) {
            case "CHUCHU":
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChuCaiFragment(),null).addToBackStack(null).commit();
                break;

            case "CHUSO":
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChuSoFragment(),null).addToBackStack(null).commit();
                break;

            case "COLOR":
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MauSacFragment(),null).addToBackStack(null).commit();
                break;

            case "HINHHOC":
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HinhHocFragment(),null).addToBackStack(null).commit();
                break;


            case "DOANCHU":
                // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HoSoFragment()).commit();
                Intent intent = new Intent(getApplicationContext(),GhepTuActivity.class);
                startActivity(intent);
                break;

            case "TINHTOAN":
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ToanHocFragment()).commit();
                Intent intent1 = new Intent(getApplicationContext(),QuizzActivity.class);
                startActivity(intent1);
                break;



        }
    }
}