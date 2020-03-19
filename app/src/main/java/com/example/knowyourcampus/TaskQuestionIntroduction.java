package com.example.knowyourcampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TaskQuestionIntroduction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_question_introduction);
        TextView activityTitle = findViewById(R.id.tv_task_name);
        TextView taskTypeName = findViewById(R.id.tv_task_type);

        int taskNumber = getIntent().getIntExtra("EXTRA_TASK_NUMBER", 0);
        Task task = (Task) getIntent().getSerializableExtra("EXTRA_TASK");

        activityTitle.setText(String.format("Task %s", taskNumber));
        taskTypeName.setText(task.getType().toString());
    }

    public void onReturnClick(View v) {
        finish();
    }

    public void onBeginClick(View v) {
        startActivity(new Intent(this, TaskQuestionActivity.class));
    }
}
