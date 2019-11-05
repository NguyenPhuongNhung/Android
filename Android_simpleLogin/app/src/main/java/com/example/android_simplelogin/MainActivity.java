package com.example.android_simplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_register, btn_login;
    EditText tvEmail, tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_register = findViewById(R.id.btn_register);
        btn_login  =findViewById(R.id.btn_login);

        tvEmail = findViewById(R.id.email);
        tvPassword = findViewById(R.id.password);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoRegisterScreen();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void gotoRegisterScreen(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void login(){
        String email = tvEmail.getText().toString();
        String password = tvPassword.getText().toString();

        if (email.equals("admin") && password.equals("admin")){
            Toast.makeText(this, "Login successfully",
                    Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Email or Password is incorrect",
                    Toast.LENGTH_LONG).show();
        }

    }


}
