package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class Walking extends AppCompatActivity {

    Button button1, button2;
    TextView nutrition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walking);

        button1 = findViewById(R.id.yoga1);
        button2 = findViewById(R.id.yoga2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Walking.this, yoga1.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Walking.this, yoga2.class);
                startActivity(intent);
            }
        });
    }

    public void beforeage18(View view){
        Intent intent = new Intent(Walking.this, yoga1.class);
        startActivity(intent);
    }
    public void afterage18(View view){
        Intent intent = new Intent(Walking.this, yoga2.class);
        startActivity(intent);
    }

    public void nutrition(View view) {
        Toast.makeText(this, "Redirecting......", Toast.LENGTH_SHORT).show();
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthifyme.com/blog/best-indian-diet-plan-weight-loss/"));
        startActivity(browserIntent);
    }
}