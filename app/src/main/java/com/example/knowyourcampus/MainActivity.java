package com.example.knowyourcampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTour(View view) {
        Intent intent = new Intent(this, SoloNameInputActivity.class);
        startActivity(intent);
    }

    public void viewLeaderboard(View view) {
        //FIXME: should point to 'Leaderboard' screen, not 'Home' screen
        Intent intent = new Intent(this, LeaderboardActivity.class);
        startActivity(intent);
    }
}
