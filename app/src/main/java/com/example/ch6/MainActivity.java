package com.example.ch6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Declare Variables

    Button bttnFirstSong, bttnSecondSong;
    MediaPlayer mpFirstSong, mpSecondSong;
    int playing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bttnFirstSong = (Button) findViewById(R.id.button);
        bttnSecondSong = (Button) findViewById(R.id.button2);

        //mp
        mpFirstSong = new MediaPlayer();
        mpSecondSong = new MediaPlayer();

        mpFirstSong = MediaPlayer.create(this,R.raw.track1);
        mpSecondSong = MediaPlayer.create(this,R.raw.track2);

        playing = 0;


        //clicklisteners
        bttnFirstSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpSecondSong.pause();
                switch (playing){
    case 0:
        mpFirstSong.start();
        playing = 1;
        bttnFirstSong.setText("Pause First Song");
        break;
    case 1:
        mpFirstSong.pause();
        playing = 0;
        bttnFirstSong.setText("Start First Song");
        break;
}
            }
        });

        bttnSecondSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpFirstSong.pause();
                switch (playing){
                    case 0:
                        mpSecondSong.start();
                        playing = 1;
                        bttnSecondSong.setText("Pause Second Song");
                        break;
                    case 1:
                        mpSecondSong.pause();
                        playing = 0;
                        bttnSecondSong.setText("Start Second Song");
                        break;
                }

            }
        });

        Button back = (Button) findViewById(R.id.button3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(MainActivity.this, Splash.class);
                startActivity(goBack);
            }
        });
    }
}