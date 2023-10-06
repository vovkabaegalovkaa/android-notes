package com.example.labazametkiiisus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class mybad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybad);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}