package com.example.project3app1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AttractionsBroadcast(View v) {
        Toast.makeText(getApplicationContext(),"Sending Attractions Broadcast!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setAction("com.abelabraham.broadcast1attractions");
        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }

    public void RestaurantBroadcast(View v) {
        Toast.makeText(getApplicationContext(),"Sending Restaurants Broadcast!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setAction("com.abelabraham.broadcast2restaurants");
        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }
}