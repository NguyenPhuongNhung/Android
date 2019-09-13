package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.login);
        Button cancel = findViewById(R.id.cancel);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText user_name = findViewById(R.id.username);
                String txtusername = user_name.getText().toString();
                EditText password = findViewById(R.id.password);
                String txtpassword = password.getText().toString();
                Toast.makeText(getApplicationContext(), txtusername, Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(view.getContext(), LoginSuccess.class);
                myIntent.putExtra("username", txtusername  );
                myIntent.putExtra("password", txtpassword  );
                startActivityForResult(myIntent, 0);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
}
