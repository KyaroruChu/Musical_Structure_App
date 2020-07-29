package com.example.android.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ContainerActivity extends AppCompatActivity {

    // page that is meant to be empty page so I can have 4 buttons on the main page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
    }
}