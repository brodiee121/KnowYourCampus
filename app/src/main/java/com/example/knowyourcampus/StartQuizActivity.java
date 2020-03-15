package com.example.knowyourcampus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);

//        Button btn = findViewById(R.id.button5);
//        btn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(StartQuizActivity.this, QuizPageOneActivity.class));
//            }
//        });
    }

    public void startQuiz(View view) {
        Intent intent = new Intent(this, QuizPageOneActivity.class);
        startActivity(intent);
    }
}