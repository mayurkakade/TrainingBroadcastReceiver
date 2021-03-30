package com.mmt.trainingbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class TrackDataBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("com.mmt.training")) {
            int resultCode = getResultCode();
            String resultData = getResultData();
            Bundle extras = intent.getExtras();
            String track_title = extras.getString("track_title");
            String artist_name = extras.getString("artist_name");
            String playlist_name = extras.getString("playlist_name");

            Toast.makeText(context,
                    "track_title : " + track_title + "\n" +
                    "artist_name : " + artist_name + "\n" +
                    "playlist : " + playlist_name + "\n" ,
                    Toast.LENGTH_LONG).show();

            SharedPreferences sharedPreferences = context.getSharedPreferences("TRACK_DETAILS", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("track_title",track_title);
            editor.putString("artist_name",artist_name);
            editor.putString("playlist_name",playlist_name);
            editor.apply();

            context.startActivity(new Intent(context, MainActivity.class));


        }
    }
}
