package com.example.knowyourcampus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TaskQuestionActivity extends AppCompatActivity {

    private int nAttempts = 3;
    private int DEMO_ANSWER = 155;
    private TextView attemptsText;
    private TextView answerResultText;
    private EditText answerText;
    private LinearLayout infoBlurb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_question);
        attemptsText = findViewById(R.id.tv_n_attempts);
        answerResultText = findViewById(R.id.tv_answer_result);
        answerText = findViewById(R.id.et_answer);
        infoBlurb = findViewById(R.id.info_blurb);
        updateAttemptsText();
    }

    public void onAttemptSubmit(View v) {
        int guess = Integer.parseInt(answerText.getText().toString());
        if (guess != DEMO_ANSWER) {
            nAttempts -= 1;
            if (nAttempts <= 0) {
                answerResultText.setText("Out of attempts, no points gained!");
                revealAnswer();
            } else {
                answerResultText.setText("Incorrect!");
            }
            answerResultText.setTextColor(Color.RED);
            updateAttemptsText();
        } else {
            answerResultText.setText("Correct!");
            answerResultText.setTextColor(Color.GREEN);
            revealAnswer();

        }
        answerResultText.setVisibility(View.VISIBLE);
    }

    private void revealAnswer() {
        infoBlurb.setVisibility(View.VISIBLE);
        findViewById(R.id.btn_giveup).setVisibility(View.GONE);
        findViewById(R.id.btn_submit).setVisibility(View.GONE);
        findViewById(R.id.btn_continue).setVisibility(View.VISIBLE);
    }

    private void updateAttemptsText() {
        attemptsText.setText(String.format("%d attempt%s remaining", nAttempts, nAttempts != 1 ? "s" : ""));
    }

    public void onContinueClick(View v) {
        Intent intent = new Intent(this, TaskListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXTRA_QUESTION_TASK_COMPLETED", true);
        startActivity(intent);
    }

    public void onGiveUpClick(final View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(TaskQuestionActivity.this);
        builder.setMessage("Do you really want give up on this task? You will see the answer, but won't gain any points!");
        builder.setTitle("Give up?");
        builder.setCancelable(false);

        builder.setPositiveButton("Give up", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(v.getContext(), TaskListActivity.class);
                intent.putExtra("EXTRA_QUESTION_TASK_COMPLETED", true);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}
