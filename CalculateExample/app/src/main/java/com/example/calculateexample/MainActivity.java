package com.example.calculateexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtNumber1, txtNumber2;
    TextView txtResult;
    Float number1, number2;
    Button btncong, btntru, btnnhan, btnchia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber1 = findViewById(R.id.number1);
        txtNumber2 = findViewById(R.id.number2);
        txtResult = findViewById(R.id.result);


        btncong = findViewById(R.id.cong);
        btntru = findViewById(R.id.tru);
        btnnhan = findViewById(R.id.nhan);
        btnchia = findViewById(R.id.chia);


        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number1 = Float.parseFloat(txtNumber1.getText().toString());
                number2 = Float.parseFloat(txtNumber2.getText().toString());
                txtResult.setText(" " + tong(number1, number2));
            }
        });

        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number1 = Float.parseFloat(txtNumber1.getText().toString());
                number2 = Float.parseFloat(txtNumber2.getText().toString());
                txtResult.setText(" " + hieu(number1, number2));
            }
        });

        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number1 = Float.parseFloat(txtNumber1.getText().toString());
                number2 = Float.parseFloat(txtNumber2.getText().toString());
                txtResult.setText(" " + tich(number1, number2));
            }
        });

        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number1 = Float.parseFloat(txtNumber1.getText().toString());
                number2 = Float.parseFloat(txtNumber2.getText().toString());
                txtResult.setText(" " + thuong(number1, number2));
            }
        });

    }

    public float tong(float number1, float number2) {

        float result = number1 + number2;
        return result;
    }

    public float hieu(float number1, float number2) {
        float result = number1 - number2;
        return result;
    }

    public float tich(float number1, float number2) {
        float result = number1 * number2;
        return result;
    }

    public float thuong(float number1, float number2) {
        float result = number1 / number2;
        return result;
    }
}
