package com.example.knowyourcampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SoloNameInputActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.knowyourcampus.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo_name_input);
    }

    public void clickedContinue(View view) {
        // TODO: store the user's given name
        // TODO: do not allow user to input non-name (blank, symbols, spaces, ints)
        Intent intent = new Intent(this, TourSelectionActivity.class);
        EditText input = (EditText) findViewById(R.id.name_input);
        String name = input.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, name);
        startActivity(intent);
    }

}
