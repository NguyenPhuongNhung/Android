package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LoginSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        String value1 = getIntent().getExtras().getString("username");
        TextView text1 = findViewById(R.id.infor);
        text1.setText("Your name is :"+value1);
        String value2 = getIntent().getExtras().getString("password");
        TextView text2 = findViewById(R.id.infor1);
        text2.setText("Your password is :"+value2);
    }
}
