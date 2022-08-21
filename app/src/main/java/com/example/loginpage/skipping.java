package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class skipping extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 900000;

    private TextView timertext, learn;//mtextviewcountdown
    private Button start, reset;//mbuttonstart mbuttonreset

    private CountDownTimer timer;//mcountdowntimer

    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skipping);
        timertext = findViewById(R.id.timer);
        learn = findViewById(R.id.textView4);
        start = findViewById(R.id.start);
        reset = findViewById(R.id.reset);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTimerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }
        });
        
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(skipping.this, "redirecting......", Toast.LENGTH_SHORT).show();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wikihow.com/Jump-Rope"));
                startActivity(browserIntent);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });

        updateCountdownText();
        
    }
    private void pauseTimer() {
        timer.cancel();
        mTimerRunning = false;
        start.setText("pause");
    }
    private void startTimer() {
        timer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMillis = l;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                start.setText("start");
            }
        }.start();

        mTimerRunning = true;
        start.setText("pause");
    }
    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
//        start.setText("start");
        updateCountdownText();
    }
    private void updateCountdownText() {
        int minutes = (int) (mTimeLeftInMillis/ 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis/ 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d : %02d", minutes, seconds);
        timertext.setText(timeLeftFormatted);
    }
}