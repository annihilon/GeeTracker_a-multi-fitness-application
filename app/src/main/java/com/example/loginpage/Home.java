package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    TextView welcome, walking, running, yoga, swimming, cycling, pushups, bmi;
    Button logout;

    SharedPreferences preferences;

    private static  final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        welcome = findViewById(R.id.hi);
        logout = findViewById(R.id.logout);
        walking = findViewById(R.id.walking);
        running = findViewById(R.id.running);
        yoga = findViewById(R.id.yoga);
        swimming = findViewById(R.id.swimming);
        cycling = findViewById(R.id.cycling);
        pushups = findViewById(R.id.pushups);
        bmi = findViewById(R.id.bmi);

        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String edit_name = preferences.getString(KEY_NAME,null);
        String edit_email = preferences.getString(KEY_EMAIL, null);

        if(edit_name != null || edit_email != null){
            welcome.setText("hi "+edit_name);
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(Home.this, "You've successfully Logged Out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        walking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Walking.class);
                startActivity(intent);
            }
        });

        running.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Running.class);
                startActivity(intent);
            }
        });

        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Yoga.class);
                startActivity(intent);
            }
        });

        swimming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Swimming.class);
                startActivity(intent);
            }
        });

        cycling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Cycling.class);
                startActivity(intent);
            }
        });

        pushups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Pushup.class);
                startActivity(intent);
            }
        });

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Bmi.class);
                startActivity(intent);
            }
        });
    }
}