package com.bett.qrshare;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class generate extends AppCompatActivity {
    Button generateQrBtn,scanQrBtn;
    EditText fistName, secondName, contactNumber;
    ImageView qrPlaceholder;
    String data, concatenatedData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        generateQrBtn = findViewById(R.id.generateQrBtn);
        scanQrBtn = findViewById(R.id.scanQrBtn);
        fistName = findViewById(R.id.firstName);
        secondName = findViewById(R.id.secondName);
        contactNumber = findViewById(R.id.contactNumber);
        qrPlaceholder = findViewById(R.id.qrPlaceholder);

        generateQrBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)// added from the String.join cintion
            @Override
            public void onClick(View v) {
                List<String> data = Arrays.asList(fistName.getText().toString(), secondName.getText().toString(), contactNumber.getText().toString());

                concatenatedData = String.join(",", data);
                QRGEncoder qrgEncoder= new QRGEncoder(concatenatedData, null, QRGContents.Type.TEXT,500);
                // Getting QR-Code as Bitmap
                Bitmap bitmap = qrgEncoder.getBitmap();
                // Setting Bitmap to ImageView
                qrPlaceholder.setImageBitmap(bitmap);
            }
        });

        scanQrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),scan.class));
            }
        });
    }


    public void noValueToast(View view) {
        Toast noValue = Toast.makeText( this, R.string.no_value_toast,Toast.LENGTH_SHORT);
        noValue.show();
    }
}