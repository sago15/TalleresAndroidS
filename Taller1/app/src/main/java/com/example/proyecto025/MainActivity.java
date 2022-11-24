package com.example.proyecto025;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
 MediaPlayer mp;
 MediaPlayer np;
 Button button;
 Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        mp= MediaPlayer.create(this, R.raw.gato);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        button2 = (Button)findViewById(R.id.button2);
        np= MediaPlayer.create(this, R.raw.perro);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                np.start();
            }
        });
    }
}