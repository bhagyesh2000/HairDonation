package com.example.bhagyesh.hairdonationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class Date extends AppCompatActivity {
    Button b;
    DatePicker dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        date();
    }

    public void date() {
        b = (Button) findViewById(R.id.button2);
        dp = (DatePicker) findViewById(R.id.date);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear() + " " + "DONATE BETWEEN 10-6PM,THANKS", Toast.LENGTH_LONG).show();
            Intent i=new Intent(Date.this,Time.class);
           startActivity(i);
            }
        });


    }


}
