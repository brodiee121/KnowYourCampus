package com.example.knowyourcampus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class FindLocation extends AppCompatActivity {

    TextView anagram = null;
    TextView desc = null;
    ImageView image = null;
    Button reveal = null;
    Button hint = null;
    Button qr = null;

    LinkedList<Integer> toRev = new LinkedList<Integer>();

    public static Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_location);

        anagram = (TextView) findViewById(R.id.anagramHint);
        desc = (TextView) findViewById(R.id.descHint);
        image = (ImageView) findViewById(R.id.imageHint);
        reveal = (Button) findViewById(R.id.revealButton);
        qr = (Button) findViewById(R.id.qrButton);
        hint = (Button) findViewById(R.id.hintButton);

        Random rand  = new Random();
        c = this;
        int r;

        createNotificationChannel();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(c, "1")
                .setSmallIcon(R.drawable.libhint)
                .setContentTitle("WARNING")
                .setContentText("Approaching Road, Please Look Both Ways")
                .setPriority(NotificationCompat.PRIORITY_MAX);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(c);

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(1, builder.build());

        LinearLayout myLinearLayout = (LinearLayout) findViewById(R.id.linLay);
        int childcount = myLinearLayout.getChildCount();
        View[] children = new View[childcount];

        for (int i=0; i < childcount; i++){
            children[i] = myLinearLayout.getChildAt(i);
        }
        myLinearLayout.removeAllViews();

        do{
            r = rand.nextInt(3);
            if (toRev.contains(r)){
                continue;
            }
            toRev.add(r);
            myLinearLayout.addView(children[r]);
        }while(toRev.size() < 3);

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toRev.peek() == 0){
                    anagram.setVisibility(View.VISIBLE);
                }
                if (toRev.peek() == 1){
                    desc.setVisibility(View.VISIBLE);
                }
                if (toRev.peek() == 2){
                    image.setVisibility(View.VISIBLE);
                }
                toRev.pop();
                if (toRev.size() == 0){
                    hint.setVisibility(View.INVISIBLE);
                }
            }
        });

        qr.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(FindLocation.this, QRScanning.class);
                startActivity(intent);

            }
        });

        reveal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(FindLocation.this, TaskListActivity.class);
                startActivity(intent);
            }
        });

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "One";
            String description = "Description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("1", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}
