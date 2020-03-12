package com.example.knowyourcampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TourSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_selection);
    }

    public void clickedContinue(View view) {
        Intent intent = new Intent(this, PlayerSelectionActivity.class);
        startActivity(intent);
    }
}
