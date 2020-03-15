package com.example.knowyourcampus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class QuizPageThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page_three);
    }


    public void viewQuizPageFour(View view) {
        Intent intent = new Intent(this, QuizPageFourActivity.class);
        startActivity(intent);
    }
}
