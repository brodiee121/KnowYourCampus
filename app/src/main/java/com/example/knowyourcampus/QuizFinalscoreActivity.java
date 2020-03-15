package com.example.knowyourcampus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class QuizFinalscoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_finalscore);
    }

    public void viewFinalScore(View view) {
        Intent intent = new Intent(this, LeaderboardActivity.class);
        startActivity(intent);
    }

    public void TryAgain(View view) {
        Intent intent = new Intent(this, StartQuizActivity.class);
        startActivity(intent);
    }

    // TODO add continue tour button's intent

}
