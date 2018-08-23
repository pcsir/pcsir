package com.example.shubhankar.pcs_irsap;

import android.app.Application;

public class GlobalVariables extends Application {

    private DatabaseHelper databaseHelper;

    @Override
    public void onCreate() {
        databaseHelper = new DatabaseHelper(getApplicationContext());
    }

    public DatabaseHelper getLocations() {
        return databaseHelper;
    }
}
