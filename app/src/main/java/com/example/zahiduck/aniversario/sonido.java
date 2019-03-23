package com.example.zahiduck.aniversario;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class sonido extends AppCompatActivity {

    private MediaPlayer mPlayer;
    private Button boton_ante, boton_play, boton_pause, boton_det, boton_sig;
    private  double startTime = 0;
    private  double finalTime = 0;
    private Handler myHandler = new Handler();
    private SeekBar seekBar;
    private TextView tx1, tx2, tx3;
    int canciones[] = {R.raw.a, R.raw.b, R.raw.c, R.raw.d, R.raw.e};
    String can[] = {"I don't want to miss a thing", "All of me", "Can't help falling in love", "Stereo Hearts", "Locked Away"};
    int index=0;
    public static int oneTimeOnly = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido);

        boton_ante = (Button)findViewById(R.id.btnAnte);
        boton_play = (Button)findViewById(R.id.btnPlay);
        boton_pause = (Button)findViewById(R.id.btnPause);
        boton_sig = (Button)findViewById(R.id.btnSig);
        mPlayer = MediaPlayer.create(this, canciones[index]);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        tx1 = (TextView)findViewById(R.id.textView2);
        tx2 = (TextView)findViewById(R.id.textView3);
        tx3 = (TextView)findViewById(R.id.textView4);
        tx3.setText(can[index]);

        boton_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.start();
                finalTime = mPlayer.getDuration();
                startTime = mPlayer.getCurrentPosition();
                if(oneTimeOnly == 0){
                    seekBar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }

                tx2.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                finalTime)))
                );

                tx1.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        startTime)))
                );

                seekBar.setProgress((int) startTime);
                myHandler.postDelayed(UpdateSongTime, 100);


            }
        });


        boton_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.pause();
            }
        });

        boton_sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                if(index>4) index=0;
                mPlayer.stop();
                mPlayer = MediaPlayer.create(getApplication(), canciones[index]);
                finalTime = mPlayer.getDuration();
                startTime = mPlayer.getCurrentPosition();
                tx3.setText(can[index]);
            }
        });

        boton_ante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index--;
                if(index<0) index=4;
                mPlayer.stop();
                mPlayer = MediaPlayer.create(getApplication(), canciones[index]);
                finalTime = mPlayer.getDuration();
                startTime = mPlayer.getCurrentPosition();
                tx3.setText(can[index]);
            }
        });



    }


    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            startTime = mPlayer.getCurrentPosition();
            tx1.setText(String.format("%d:%d",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                    startTime))));

            seekBar.setProgress((int) startTime);
            myHandler.postDelayed(this, 100);
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        mPlayer.stop();
        mPlayer = MediaPlayer.create(getApplication(), canciones[index]);
        finalTime = mPlayer.getDuration();
        startTime = mPlayer.getCurrentPosition();
        tx3.setText(can[index]);
    }
}
