package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    Animation topAnim, bottomAnim, footerAnim;
    ImageView img;
    TextView welcome, slogan, footer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        footerAnim = AnimationUtils.loadAnimation(this, R.anim.fotter_animation);

        img = findViewById(R.id.logo);
        welcome = findViewById(R.id.welcome);
        slogan = findViewById(R.id.slogan);
        footer = findViewById(R.id.footer);

        img.setAnimation(topAnim);
        welcome.setAnimation(bottomAnim);
        slogan.setAnimation(footerAnim);
        footer.setAnimation(footerAnim);

        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(3500);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };thread.start();
    }
}