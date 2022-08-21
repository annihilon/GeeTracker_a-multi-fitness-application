package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    Animation topAnim, bottomAnim, footerAnim;
    EditText name, pass, fullname, mob, confirm_pass, email;
    Button go;
    TextView back;

    SharedPreferences preferences;

    private static  final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        footerAnim = AnimationUtils.loadAnimation(this, R.anim.fotter_animation);

        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

            go = findViewById(R.id.login);
            back = findViewById(R.id.signupback);
            name = findViewById(R.id.name);
            pass = findViewById(R.id.pass);
            fullname = findViewById(R.id.fullname);
            mob = findViewById(R.id.mob);
            email = findViewById(R.id.email);
            confirm_pass = findViewById(R.id.confirm_pass);

            fullname.setAnimation(footerAnim);
            name.setAnimation(footerAnim);
            mob.setAnimation(footerAnim);
            email.setAnimation(footerAnim);
            pass.setAnimation(footerAnim);
            confirm_pass.setAnimation(footerAnim);
            go.setAnimation(footerAnim);

            preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

            String edit_name = preferences.getString(KEY_NAME, null);

            if(edit_name != null){
                Intent intent = new Intent(SignUpActivity.this, Home.class);
                startActivity(intent);
            }
            go.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(KEY_NAME, name.getText().toString());
                    editor.putString(KEY_EMAIL, pass.getText().toString());
                    editor.apply();

                    Toast.makeText(SignUpActivity.this, "Sucessfully Registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, Home.class);
                    startActivity(intent);
                }
            });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}