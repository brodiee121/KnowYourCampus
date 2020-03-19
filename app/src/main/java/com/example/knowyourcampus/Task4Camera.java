package com.example.knowyourcampus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class Task4Camera extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    private ImageView capturedImage;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    public Bitmap photo;
    public byte[] byteArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4_camera);

        Button continueButton = findViewById(R.id.continueButton);


        continueButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(Task4Camera.this, Task4Completed.class);
                intent.putExtra("picture", byteArray);
                startActivity(intent);

            }
        });


        capturedImage = findViewById(R.id.capturedImage);

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(cameraIntent, CAMERA_REQUEST);



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK)
        {
            photo = (Bitmap) data.getExtras().get("data");
            capturedImage.setImageBitmap(photo);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byteArray = stream.toByteArray();
        }
    }

}
