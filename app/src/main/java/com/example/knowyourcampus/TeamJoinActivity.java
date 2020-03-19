package com.example.knowyourcampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class TeamJoinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_join);
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
        EditText input = (EditText) findViewById(R.id.code_input);
        String code = input.getText().toString();
        try {
            Integer.parseInt(code);
        } catch (NumberFormatException e) {
            input.setError("Input must be numeric.");
        }
        if (code.length() != 6) {
            input.setError("Code must be 6 digits.");
        } else {
            startActivity(intent);
        }
    }
}
