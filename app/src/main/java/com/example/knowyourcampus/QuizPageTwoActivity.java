package com.example.knowyourcampus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class QuizPageTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page_two);
    }


    public void viewQuizPageThree(View view) {
        Intent intent = new Intent(this, QuizPageThreeActivity.class);
        startActivity(intent);
    }
}
