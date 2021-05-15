package com.amanaryan.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView start=findViewById(R.id.starttxt);
        start.setVisibility(View.GONE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(this.getResources().getColor(R.color.white));
        }

        int time=3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                start.setVisibility(View.VISIBLE);
            }
        },time);

    start.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            startActivity(new Intent(getApplicationContext(),MainActivity.class));

        }
    });
    }
}