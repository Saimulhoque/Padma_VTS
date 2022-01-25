package com.forbitbd.padmatracker.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import com.forbitbd.padmatracker.AlertFragment;
import com.forbitbd.padmatracker.R;
import com.forbitbd.padmatracker.ViewAllInMapFragment;
import com.forbitbd.padmatracker.ui.home.HomeFragment;
import com.forbitbd.padmatracker.ui.login.LoginActivity;
import com.forbitbd.padmatracker.utils.BaseActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, MainContract.View {

    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private MainPresenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter(this);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
        Fragment fragment = null;
        int id =item.getItemId();
        String title = getString(R.string.app_name);

        if (id == R.id.home){
            fragment = new HomeFragment();
        }else if (id == R.id.allinmap){
            fragment = new ViewAllInMapFragment();
            title = "View All In Map";
        }else if (id == R.id.alert){
            fragment = new AlertFragment();
            title ="Alert Setting";
        }else if (id == R.id.logout){
            signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.commit();
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        drawerLayout = findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            finishAffinity();
        }
    }
}