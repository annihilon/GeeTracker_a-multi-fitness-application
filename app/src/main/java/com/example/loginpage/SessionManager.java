package com.example.loginpage;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private SharedPreferences sharedPreferences ;
    private  SharedPreferences.Editor editor;

    public SessionManager(Context context){
        sharedPreferences = context.getSharedPreferences("AppKey", 0);
        editor = sharedPreferences.edit();
        editor.apply();

    }

    public void setFlag(Boolean flag){
        editor.putBoolean("KEY_FLAG", flag);
        editor.commit();
    }

    public boolean getflag(){
        return sharedPreferences.getBoolean("KEY_FLAG", false);
    }

    public void setCurrentTime(String currentTime){
        editor.putString("KEY_TIME", currentTime);
        editor.commit();
    }

    public String getCurrentTime(){
        return sharedPreferences.getString("KEY_TIME", "");
    }
}
