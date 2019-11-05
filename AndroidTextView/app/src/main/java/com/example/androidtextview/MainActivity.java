package com.example.androidtextview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView ;
        textView = findViewById(R.id.tv);
        textView.setText("Hey, one more TextView");
      //  textView.setTextColor(getResources().getColor(R.color.maucuaNhung));
        textView.setTextColor(Color.parseColor("#FFFFFF"));


    }
}
