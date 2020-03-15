package com.example.knowyourcampus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class QuizPageFourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page_four);
    }


    public void viewFinalScore(View view) {
        Intent intent = new Intent(this, QuizFinalscoreActivity.class);
        startActivity(intent);
    }
}
