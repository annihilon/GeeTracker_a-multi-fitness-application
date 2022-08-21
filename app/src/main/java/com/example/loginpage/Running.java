package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Running extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 600000;

    private TextView timertext, speed;//mtextviewcountdown
    private Button start, reset;//mbuttonstart mbuttonreset

    private CountDownTimer timer;//mcountdowntimer

    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

//    Timer timer;
//    TimerTask timertask;
//    Double time = 0.0;
//
//    boolean timerstarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);

        timertext = findViewById(R.id.timer);
        speed = findViewById(R.id.speed);
        start = findViewById(R.id.start);
        reset = findViewById(R.id.reset);

//        timer = new Timer();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (timerstarted == false){
//                    timerstarted = true;
//                    start.setText("stop");
////                    start.setTextColor(ContextCompat.getColor(this, R.color.red));
//                }else{
//                    timerstarted = false;
//                    start.setText("start");
//                }
//                startTimer();
                if(mTimerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
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