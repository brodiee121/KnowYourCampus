package com.example.knowyourcampus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class TaskARIntroduction extends AppCompatActivity {

    private boolean exampleShown = false;
    private Button btnExample;
    private ConstraintLayout layoutExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_arintroduction);
        btnExample = findViewById(R.id.btn_example);
        layoutExample = findViewById(R.id.layout_example);
    }

    public void onGiveUpClick(final View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(TaskARIntroduction.this);
        builder.setMessage("Do you really want give up on this task? You will see the answer, but won't gain any points!");
        builder.setTitle("Give up?");
        builder.setCancelable(false);

        builder.setPositiveButton("Give up", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(v.getContext(), TaskListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXTRA_AR_TASK_COMPLETED", true);
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

    public void onExampleButtonClick(View v) {
        exampleShown = !exampleShown;
        btnExample.setText(exampleShown ? "Hide Example" : "Show Example");
        layoutExample.setVisibility(exampleShown ? View.VISIBLE : View.INVISIBLE);
    }

    public void onCaptureClick(View v) {
        Intent intent = new Intent(this, TaskARCamera.class);
        startActivity(intent);
    }
}
