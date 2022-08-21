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

public class LoginActivity extends AppCompatActivity {

    Animation topAnim, bottomAnim, footerAnim;
    EditText name, pass;
    Button go_1;
    TextView back_1;
    SharedPreferences preferences;

    private static  final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        footerAnim = AnimationUtils.loadAnimation(this, R.anim.fotter_animation);

        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

            back_1 = findViewById(R.id.signupback);
            name = findViewById(R.id.fullname);
            pass = findViewById(R.id.pass);
            go_1 = findViewById(R.id.login);

            name.setAnimation(footerAnim);
            pass.setAnimation(footerAnim);
            go_1.setAnimation(footerAnim);

            preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

            String edit_name = preferences.getString(KEY_NAME, null);

            if(edit_name != null){
                Intent intent = new Intent(LoginActivity.this, Home.class);
                startActivity(intent);
            }


            go_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(KEY_NAME, name.getText().toString());
                    editor.putString(KEY_EMAIL, pass.getText().toString());
                    editor.apply();

                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, Home.class);
                    startActivity(intent);
                }
            });
//        }
        back_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
