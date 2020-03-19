package com.example.knowyourcampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class TeamNameInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_name_input);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void clickedContinue(View view) {
        Intent intent = new Intent(this, TeamLobbyActivity.class);
        EditText input = (EditText) findViewById(R.id.team_name_input);
        String name = input.getText().toString();
        if (name.length() < 2 || name.length() > 14) {
            input.setError("Name must be 2 to 14 characters.");
        }
        else if (!name.matches("[a-zA-Z]+")) {
            input.setError("Name must only contain alphabetic characters.");
        }
        else {
            startActivity(intent);
        }
    }
}
