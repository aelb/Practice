package com.example.alejandrolozada.holamundo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Intermediaria extends Activity {

    private ImageButton imgBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediaria);
        imgBTN = (ImageButton)findViewById(R.id.imageButton);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intermediaria, menu);
        return true;
    }

    private void envia1(View view){
        Intent envia = new Intent(Intermediaria.this, Hola_Mundo.class);
        startActivity(envia);
        finish();
    }


}
