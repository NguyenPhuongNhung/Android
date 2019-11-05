package com.example.android_simplecalculate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button sum, multiple, average;
    EditText tvNumber1, tvNumber2;
    TextView result;
    Float number1, number2;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sum = findViewById(R.id.sum);
        multiple = findViewById(R.id.multiple);
        average = findViewById(R.id.average);


        result = findViewById(R.id.result);

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue();
                setSum(number1, number2);
            }
        });

        multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue();
                setMultiple(number1, number2);
            }
        });

        average.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue();
                setAvarage(number1, number2);
            }
        });
    }

    private void setValue() {
        tvNumber1 = (EditText) findViewById(R.id.tvnumber1);
        tvNumber2 = (EditText) findViewById(R.id.tvnumber2);
        number1 = Float.parseFloat(tvNumber1.getText().toString());
        number2 = Float.parseFloat(tvNumber2.getText().toString());
    }


    private float setSum(float number1, float number2) {
        result.setText((number1 + number2) + "");
        return number1 + number2;
    }

    private float setMultiple(float number1, float number2) {
        result.setText((number1 * number2) + "");
        return number1 + number2;
    }

    private float setAvarage(float number1, float number2) {
        float sun = setSum(number1, number2);
        result.setText(sun / 2 + "");
        return number1 + number2;
    }
}
