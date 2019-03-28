package com.example.bhagyesh.hairdonationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.bhagyesh.hairdonationapp.Utility.StorageBox;

public class SignupActivity extends AppCompatActivity {
    EditText userName, password, email, phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);


        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validatedetails()) {
                    StorageBox<String> box = new StorageBox<>();
                    box.putData(SignupActivity.this, "MuserName", userName.getText().toString().trim());
                    box.putData(SignupActivity.this, "Mpass", password.getText().toString().trim());
                    box.putData(SignupActivity.this, "Memail", email.getText().toString().trim());
                    box.putData(SignupActivity.this, "Mphone", phone.getText().toString().trim());
                    finish();
                }


            }
        });
    }

    private boolean validatedetails() {
        boolean result = true;
        if (userName.getText().toString().trim().equals("")) {
            userName.setError("input name ");
            result = false;
        }
        if (password.getText().toString().trim().equals("")) {
            userName.setError("input password ");
            result = false;
        }
        if (email.getText().toString().trim().equals("")) {
            userName.setError("input email ");
            result = false;
        }
        if (phone.getText().toString().trim().equals("")) {
            userName.setError("input phone no ");
            result = false;
        }
        return result;
    }
}
