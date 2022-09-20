package com.example.project3app2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AttractionsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Intent i = new Intent();
        i.setClassName("com.example.project3app2","com.example.project3app2.AttractionsActivity");
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}