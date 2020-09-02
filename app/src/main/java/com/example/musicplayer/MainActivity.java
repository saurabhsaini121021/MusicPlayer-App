package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play , pause , stop;
    MediaPlayer mediaPlayer;
    int pauseCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.btnPlay);
        stop = findViewById(R.id.btnStop);
        pause = findViewById(R.id.btnPause);

        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        pause.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnPlay:
                if (mediaPlayer == null){
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.cradles);
                mediaPlayer.start();}

                else if (!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pauseCurrentPosition);
                    mediaPlayer.start();
                }
                break;

            case R.id.btnStop:
                if (mediaPlayer!=null){
                mediaPlayer.stop();
                mediaPlayer= null;}
                break;

            case R.id.btnPause:
                if (mediaPlayer!= null){
                    mediaPlayer.pause();
                    pauseCurrentPosition = mediaPlayer.getCurrentPosition();
                }
                break;
        }
    }
}