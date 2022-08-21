package com.example.loginpage;

import android.location.Location;

public class cLocation extends Location {

    private boolean bUseMetricUnits = false;

    public cLocation(String provider) {
        super(provider);
    }
}
