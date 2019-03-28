package com.example.bhagyesh.hairdonationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bhagyesh.hairdonationapp.Utility.StorageBox;

public class LoginActivity extends AppCompatActivity {


    EditText userName, password;
    Button loginBTN;
    TextView signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inititializeViews();

        Signnup();
    }

    private void Signnup() {

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitdetails();
            }
        });
    }

    private void submitdetails() {
        if (validateInputs()) {
            startActivity(new Intent(this, HomeActivity.class));
            new StorageBox<Boolean>().putData(this, "isLogin", true);
            finish();
        }

    }

    private boolean validateInputs() {
        String uName = userName.getText().toString().trim();
        String pass = password.getText().toString().trim();
        boolean result = true;
        if (userName.getText().toString().trim().equals("")) {
            userName.setError("input name ");
            result = false;
        } else if (!uName.equals(new StorageBox<String>().getData(this, "MuserName"))) {
            userName.setError("userName Not Found ");
            result = false;
        } else if (password.getText().toString().trim().equals("")) {
            password.setError("please insert password");
            result = false;
        } else if (!pass.equals(new StorageBox<String>().getData(this, "Mpass"))) {

            userName.setError("invalid password ");
            result = false;
        }
        return result;

    }

    private void inititializeViews() {
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        loginBTN = findViewById(R.id.loginBTN);
        signUpBtn = findViewById(R.id.signUpBtn);
    }

}
