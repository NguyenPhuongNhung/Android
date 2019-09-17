package com.example.androidlinearlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] studentNames = new String[]{"Nhung", "Van", "Ngoc", "Huong"};

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);

        for (int i = 0; i < studentNames.length; i++) {
            TextView textView = new TextView(MainActivity.this);
            textView.setText("Your name is " + studentNames[i]);
            textView.setLayoutParams(params);

            Button button = new Button(MainActivity.this);
            button.setText("+");

            LinearLayout mainLayout = findViewById(R.id.main_linear);
            LinearLayout childLayout = new LinearLayout(MainActivity.this);
            childLayout.setOrientation(LinearLayout.HORIZONTAL);

            childLayout.addView(textView);
            childLayout.addView(button);
            mainLayout.addView(childLayout);
        }
    }
}
