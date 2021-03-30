package com.mmt.trainingbroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TrackDataBroadcastReceiver trackDataBroadcastReceiver = new TrackDataBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter("com.mmt.training");
        registerReceiver(trackDataBroadcastReceiver,filter);

        SharedPreferences sharedPreferences = getSharedPreferences("TRACK_DETAILS", Context.MODE_PRIVATE);

        String track_title = sharedPreferences.getString("track_title"," Not Set Yet ");
        String artist_name = sharedPreferences.getString("artist_name"," Not Set Yet ");
        String playlist_name = sharedPreferences.getString("playlist_name"," Not Set Yet ");

        TextView tv_show_text = findViewById(R.id.tv_show_text);
        String textToSet = "recently clicked track details are : \n" +
                "track_title : " + track_title + "\n" +
                "artist_name : " + artist_name + "\n" +
                "playlist : " + playlist_name + "\n";

        tv_show_text.setText(textToSet);





    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(trackDataBroadcastReceiver);
    }
}