package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        // btn = null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.text);
//              TextView textResult = findViewById(R.id.result);
//              textResult.setText(textResult.getText().toString()+ editText.getText()+"\n");
//              String editText = textResult.getText().toString();
                TextView tv = new TextView(MainActivity.this);
                tv.setText(editText.getText().toString());
                LinearLayout main = findViewById(R.id.main_linear);
                main.addView(tv);

            }
        });
    }
}
