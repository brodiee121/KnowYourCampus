package com.example.knowyourcampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TeamNameInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_name_input);
    }

    public void clickedContinue(View view) {
        //TODO: check for valid name (no non-alphabetic)
        Intent intent = new Intent(this, TeamLobbyActivity.class);
        startActivity(intent);
    }
}
