package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.media.session.MediaSessionManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.se.omapi.Session;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Swimming extends AppCompatActivity {

    private Chronometer chronometer;
    Button start;
    SessionManager sessionManager;
    SimpleDateFormat format;
    String currentTime;
//    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swimming);

        chronometer = findViewById(R.id.timer);
        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                sessionManager.setCurrentTime(currentTime);
                chronometer.start();
            }
        });

        sessionManager = new SessionManager(getApplicationContext());
        format = new SimpleDateFormat("hh:mm:ss aa");
        currentTime = format.format(new Date());

        boolean flag  = sessionManager.getflag();
        if(!flag){
            sessionManager.setCurrentTime(currentTime);
            sessionManager.setFlag(true);
            chronometer.start();
        }else{
            String sessionManagerCurrentTime = sessionManager.getCurrentTime();
            try {
                Date date = format.parse(sessionManagerCurrentTime);
                Date date2 = (format.parse(currentTime));

                long mills = date.getTime() - date2.getTime();
                chronometer.setBase(SystemClock.elapsedRealtime() - mills);
                chronometer.start();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
//    public void startChronometer (View v){
//        if(!running){
//            chronometer.start();
//            running= true;
//        }
//    }
//    public void pauseChronometer (View v){
//        if(running){
//            chronometer.stop();
//            running= false;
//        }
//    }
//    public void resetChronometer (View v){
//
//    }
}