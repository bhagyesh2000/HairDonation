package com.example.bhagyesh.hairdonationapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class Time extends AppCompatActivity {
    private TimePicker tp;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        time();
    }

    public void time() {
        tp = (TimePicker) findViewById(R.id.time);
        b = (Button) findViewById(R.id.button);
        tp.setIs24HourView(true);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), tp.getCurrentHour() + ":" + tp.getCurrentMinute() +"Is The slot you have booked, Here is the Address", Toast.LENGTH_LONG).show();
                Intent i=new Intent(Time.this,Address.class);
                startActivity(i);

            }
        });
    }
}
