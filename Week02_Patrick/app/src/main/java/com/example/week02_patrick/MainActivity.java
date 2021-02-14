package com.example.week02_patrick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText angka1, angka2;
    TextView hasil;
    Button btnTambah, btnKurang, btnKali, btnBagi;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angka1 = (EditText) findViewById(R.id.angka1);
        angka2 = (EditText) findViewById(R.id.angka2);
        hasil = (TextView) findViewById(R.id.hasil);
        btnTambah = (Button) findViewById(R.id.btnTambah);
        btnKurang = (Button) findViewById(R.id.btnKurang);
        btnKali = (Button) findViewById(R.id.btnKali);
        btnBagi = (Button) findViewById(R.id.btnBagi);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { hitung('+');

            }
        });
        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { hitung ('-');

            }
        });
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { hitung('*');

            }
        });
        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { hitung('/');

            }
        });

    }
    protected void hitung (char operator) {
        if(angka1.getText().toString().isEmpty() || angka2.getText().toString().isEmpty()){
            hasil.setText("Masukkan kedua angka");
            return;
        }
        double operand1 = Double.parseDouble(angka1.getText().toString());
        double operand2 = Double.parseDouble(angka2.getText().toString());
        double result = 0.0;
        switch (operator) {
            case ('+'):
                result = operand1 + operand2;
                break;
            case ('-'):
                result = operand1 - operand2;
                break;
            case ('*'):
                result = operand1 * operand2;
                break;
            case ('/'):
                if(operand2 <= 0){
                    hasil.setText("Undefined");
                    return;
                }else {
                    result = operand1 / operand2;
                }
        }
        hasil.setText(String.valueOf(result));
    }
}