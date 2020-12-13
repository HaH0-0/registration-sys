package com.example.registrationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button btn;
    EditText ed1, ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ed1 = findViewById(R.id.Log_r);
        ed2 = findViewById(R.id.Pas_r);
        btn = findViewById(R.id.button2);
        btn.setOnClickListener(v -> {
            Toast.makeText(this, "The account was created successfully", Toast.LENGTH_LONG).show();
            String s1 = ed1.getText().toString();
            String s2 = ed2.getText().toString();
            Intent i = new Intent();
            i.putExtra("Log_r", s1);
            i.putExtra("Pas_r", s2);
            setResult(1, i);
            finish();
        });
    }
}