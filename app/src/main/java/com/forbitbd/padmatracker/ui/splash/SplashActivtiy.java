package com.forbitbd.padmatracker.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.forbitbd.padmatracker.ui.main.MainActivity;
import com.forbitbd.padmatracker.R;
import com.forbitbd.padmatracker.ui.login.LoginActivity;

public class SplashActivtiy extends AppCompatActivity implements SplashContract.View{

    private SplashPresenter mPresenter;
    Handler handler = new Handler();
    Runnable runnable;
    int delay = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activtiy);
        mPresenter = new SplashPresenter(this);

    }

    @Override
    protected void onResume() {
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(runnable,delay);
                mPresenter.checkdealer();
            }
        },delay);
        super.onResume();
    }

    @Override
    protected void onPause() {
        handler.removeCallbacks(runnable);
        super.onPause();
    }

    @Override
    public void Startlogin() {
        startActivity(new Intent(this,LoginActivity.class));
    }

    @Override
    public void StartMain() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
