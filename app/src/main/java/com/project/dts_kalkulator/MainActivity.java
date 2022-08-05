package com.project.dts_kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inputAngka1, inputAngka2;
    Button btnTambah, btnKurang, btnKali, btnBagi, btnReset;
    TextView hasil;
    private double angka1, angka2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputAngka1 = findViewById(R.id.etAngka1);
        inputAngka2 = findViewById(R.id.etAngka2);
        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        btnReset = findViewById(R.id.btnReset);
        hasil = findViewById(R.id.txtHasil);

        btnTambah.setOnClickListener(view -> {
            if(TextUtils.isEmpty(inputAngka1.getText().toString().trim()) && TextUtils.isEmpty(inputAngka2.getText().toString().trim())){
                validasi();
            }else{
                getInputAngka();
                hasil.setText(String.valueOf(hitung('+', angka1, angka2)));
            }
        });
        btnKurang.setOnClickListener(view -> {
            if(TextUtils.isEmpty(inputAngka1.getText().toString().trim()) && TextUtils.isEmpty(inputAngka2.getText().toString().trim())){
                validasi();
            }else{
                getInputAngka();
                hasil.setText(String.valueOf(hitung('-', angka1, angka2)));
            }
        });
        btnKali.setOnClickListener(view -> {
            if(TextUtils.isEmpty(inputAngka1.getText().toString().trim()) && TextUtils.isEmpty(inputAngka2.getText().toString().trim())){
                validasi();
            }else if(inputAngka2.getText().toString().trim().equals(0)){
                Toast.makeText(this,"Tak Terhingga",Toast.LENGTH_LONG);
            }
            else{
                getInputAngka();
                hasil.setText(String.valueOf(hitung('*', angka1, angka2)));
            }
        });
        btnBagi.setOnClickListener(view -> {
            if(TextUtils.isEmpty(inputAngka1.getText().toString().trim()) && TextUtils.isEmpty(inputAngka2.getText().toString().trim())){
                validasi();
            }else{
                getInputAngka();
                hasil.setText(String.valueOf(hitung('/', angka1, angka2)));
            }
        });
        btnReset.setOnClickListener(view -> {
            inputAngka1.setText("");
            inputAngka2.setText("");
            hasil.setText("0");
        });
    }
    private void getInputAngka(){
        angka1 = Double.parseDouble(inputAngka1.getText().toString());
        angka2 = Double.parseDouble(inputAngka2.getText().toString());
    }

    private void validasi(){
        Toast.makeText(this, "Mohon masukkan Angka pertama & Kedua", Toast.LENGTH_LONG).show();
    }

    private double hitung(char operator, double angka1, double angka2){
        switch (operator){
            case '+':
                return angka1 + angka2;
            case '-':
                return angka1 - angka2;
            case '*':
                return angka1 * angka2;
            case '/':
                return angka1 / angka2;
            default:
                return 0;
        }
    }
}