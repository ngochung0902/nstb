package com.app.langta.niemsotribenh.activity;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.app.langta.niemsotribenh.R;

public class Splash extends AppCompatActivity {
    ImageView img_splash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_splash = findViewById(R.id.img_splash);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this, Home.class));
                finish();
            }
        }, 3000);
    }
}
