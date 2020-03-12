package com.example.knowyourcampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlayerSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_selection);
    }

    public void clickedSolo(View view) {
        //FIXME: should link to 'How to play' screen, not 'Home' screen
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickedTeam(View view) {
        Intent intent = new Intent(this, TeamRoleSelectionActivity.class);
        startActivity(intent);
    }
}
