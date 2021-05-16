package com.amanaryan.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class endpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endpage);
        String s=getIntent().getExtras().getString("s");
        TextView stxt=findViewById(R.id.sss);
        stxt.setText("Score:"+s);
        TextView r=findViewById(R.id.restart);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(this.getResources().getColor(R.color.white));
        }

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}