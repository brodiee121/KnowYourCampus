package com.example.knowyourcampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class TaskARCamera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_arcamera);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        VideoView vid = (VideoView) findViewById(R.id.videoView);
        MediaController m = new MediaController(this);
        vid.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.door_video_final);
        //String pathToVideo = "/home/lknapek/Documents/KnowYourCampus/app/src/main/res/raw/door_video.mp4";
        //vid.setVideoPath(pathToVideo);
        vid.start();
    }

    public void onClick(View v) {
        startActivity(new Intent(this, TaskARResult.class));
    }
}
