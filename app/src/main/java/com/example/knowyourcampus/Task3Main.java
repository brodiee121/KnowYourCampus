package com.example.knowyourcampus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Task3Main extends AppCompatActivity {

    public Button captureButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3_main);

        captureButton = (Button) findViewById(R.id.Capture);


        captureButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
            Intent intent = new Intent(Task3Main.this, Task3Camera.class);
            startActivity(intent);
            }
        });

    }

    public void onGiveUpClick(final View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Task3Main.this);
        builder.setMessage("Do you really want give up on this task? You will see the answer, but won't gain any points!");
        builder.setTitle("Give up?");
        builder.setCancelable(false);

        builder.setPositiveButton("Give up", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(v.getContext(), TaskListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXTRA_REPRODUCTION_TASK_COMPLETED", true);
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
