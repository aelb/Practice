package com.example.alejandrolozada.holamundo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Handler;


public class Splash extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(getRunnblesStarApp(), SPLASH_DISPLAY_LENGTH);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }


    private Runnable getRunnblesStarApp(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,Intermediaria.class);
                startActivity(intent);
                finish();
            }
        };
        return runnable;
    }

}
