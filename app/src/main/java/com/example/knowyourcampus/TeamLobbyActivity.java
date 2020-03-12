package com.example.knowyourcampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TeamLobbyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_lobby);
    }

    public void clickedReady(View view) {
        //FIXME: should link to 'How to play' screen, not 'Home' screen
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
