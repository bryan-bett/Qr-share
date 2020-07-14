package com.bett.qrshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void launchGenerateActivity (View view){
        Intent myIntent = new Intent(this, generate.class);
        startActivity(myIntent);
    }
    public void launchScanActivity (View view){
        Intent scanIntent = new Intent(this, scan.class);
        startActivity(scanIntent);
    }
}