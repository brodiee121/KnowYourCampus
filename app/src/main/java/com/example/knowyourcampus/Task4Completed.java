package com.example.knowyourcampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Task4Completed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4_completed);

        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("picture");

        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView image = (ImageView) findViewById(R.id.selfie);
        image.setImageBitmap(bmp);
    }

    public void onContinueClick(View v) {
        Intent intent = new Intent(this, TaskListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXTRA_SELFIE_TASK_COMPLETED", true);
        startActivity(intent);
    }
}
