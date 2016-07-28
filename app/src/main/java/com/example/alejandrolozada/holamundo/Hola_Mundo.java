package com.example.alejandrolozada.holamundo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Hola_Mundo extends Activity {

    private String MI_APP;
    private TextView hola;
    private ImageView img;
    Random aleatorio = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola__mundo);
        hola = (TextView) findViewById(R.id.textView);
        img =(ImageView) findViewById(R.id.imageView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_hola__mundo, menu);
        MenuItem helpMenuItem = menu.findItem(R.id.help);
        helpMenuItem.setIntent(new Intent("com.example.android.intent.action.HELP"));
        return result;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item){
        boolean result = super.onMenuItemSelected(featureId, item);
        switch (item.getItemId()){
            case R.id.add:
                Log.d(MI_APP, getString(R.string.menu_add_log_text));
                showNotification();
                result = true;
                break;
            case R.id.remove:
                Log.d(MI_APP, getString(R.string.menu_remove_log_text));
                showToast();
                result= true;
                break;
            case R.id.help:
                Log.d(MI_APP, getString(R.string.menu_help_log_text));
                result=false;
                break;
        }
        return false;
    }

    private void showToast(){
        Toast toast = Toast.makeText(this, R.string.remove_text, Toast.LENGTH_LONG);
        toast.show();
    }

    private void showNotification(){
        NotificationManager manager =(NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);
        int icon = android.R.drawable.stat_notify_voicemail;
        String tickerText = getText(R.string.ticker_text).toString();
        String contentTitle = getText(R.string.content_title).toString();
        String contentText = getText(R.string.content_description).toString();
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,new Intent(this, Hola_Mundo.class),0);
        Notification notification = new Notification(icon, tickerText,System.currentTimeMillis());
        notification.setLatestEventInfo(this, contentTitle,contentText,contentIntent);
        manager.notify(1,notification);
    }

    @Override
    protected void onStart(){
        super.onStart();
        NotificationManager manager = (NotificationManager)getSystemService(Service.NOTIFICATION_SERVICE);
        manager.cancel(1);
    }



    public void Muestra(View view) {
        hola.setText("Hola muggles");
        img.setImageResource(R.drawable.hogwarts);
        Toast t = Toast.makeText(getApplication(), "Bienvenidos a Hogwarts ",Toast.LENGTH_SHORT);
        t.show();

    }

    public void Casa(View view){
        int casas = 1+aleatorio.nextInt(4);
        switch (casas){
            case 1:
                hola.setText("Su casa es");
                img.setImageResource(R.drawable.gryffindor);
                Toast t1 = Toast.makeText(getApplicationContext(),"Gryffindor",Toast.LENGTH_LONG);
                t1.setGravity(Gravity.CENTER|Gravity.CENTER,0,0);
                t1.show();
                break;
            case 2:
                hola.setText("Su casa es");
                img.setImageResource(R.drawable.slytherin);
                Toast t2 = Toast.makeText(getApplicationContext(),"Slytherin",Toast.LENGTH_LONG);
                t2.setGravity(Gravity.CENTER|Gravity.CENTER,0,0);
                t2.show();
                break;
            case 3:
                hola.setText("Su casa es");
                img.setImageResource(R.drawable.ravenclaw);
                Toast t3 = Toast.makeText(getApplicationContext(),"Ravenclaw",Toast.LENGTH_LONG);
                t3.setGravity(Gravity.CENTER|Gravity.CENTER,0,0);
                t3.show();
                break;
            case 4:
                hola.setText("Su casa es");
                img.setImageResource(R.drawable.hufflepuff);
                Toast t4 = Toast.makeText(getApplicationContext(),"Hufflepuff",Toast.LENGTH_LONG);
                t4.setGravity(Gravity.CENTER|Gravity.CENTER,0,0);
                t4.show();
                break;
        }
    }
}