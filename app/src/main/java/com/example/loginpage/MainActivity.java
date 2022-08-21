package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation topAnim, bottomAnim, footerAnim;
    ImageView logo;
    Button login_b, signup_b;
    TextView skip, welcomeline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        footerAnim = AnimationUtils.loadAnimation(this, R.anim.fotter_animation);

        logo = findViewById(R.id.logo_1);
        welcomeline = findViewById(R.id.welcomeline);
        login_b = findViewById(R.id.login_button);
        signup_b = findViewById(R.id.signup_button);
        skip = findViewById(R.id.textView5);

        logo.setAnimation(topAnim);
        welcomeline.setAnimation(footerAnim);
        login_b.setAnimation(footerAnim);
        signup_b.setAnimation(footerAnim);

        login_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        signup_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
            }
        });
    }
}