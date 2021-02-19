    package com.example.koranku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

    public class SplashScreen extends AppCompatActivity {

    private static int timeSplash= 4000; //durasi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //membaca

        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // to do auto generated stub
                Intent a = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(a);

                // jeda setelah splashscren

                this.finishSplash();
            }

            private void finishSplash(){
                //auto
            }
        },timeSplash);

    };

    }

