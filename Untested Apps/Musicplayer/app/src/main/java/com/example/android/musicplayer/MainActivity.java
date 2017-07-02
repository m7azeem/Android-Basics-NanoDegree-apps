package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mp = new MediaPlayer().create(this, R.raw.halflife);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play = (Button)findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                mp.start();
                //Toast.makeText(MainActivity.this,"Play",Toast.LENGTH_SHORT).show();
            }
        });

        Button pause= (Button)findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                mp.stop();
                //Toast.makeText(MainActivity.this,"Pause",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
