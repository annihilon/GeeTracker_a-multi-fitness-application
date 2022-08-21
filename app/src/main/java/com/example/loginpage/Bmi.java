package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bmi extends AppCompatActivity {

    EditText weight, height;
    TextView result;
    Button calculate, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.graph);
        clear = findViewById(R.id.clear);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (weight.getText().toString().length()==0){
                    weight.setText("0");
                }
                if (height.getText().toString().length()==0){
                    height.setText("0");
                }
                Float v0 = Float.parseFloat(height.getText().toString());
                Float v1 = v0/100;
                Float v2 = Float.parseFloat(weight.getText().toString());
                float div = v2/(v1*v1);
                result.setText("BMI = "+String.valueOf(div));

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight.setText("");
                height.setText("");
                result.setText("Your result will appear here");
            }
        });
    }
}