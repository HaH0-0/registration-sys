package com.example.registrationsystem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.icu.text.RelativeDateTimeFormatter;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    Button btn;
    EditText ed1, ed2;
    TextView tw;
    private String Log = "HAHA";
    private String Pas = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        ed1 = findViewById(R.id.Log);
        ed2 = findViewById(R.id.Pas);
        tw = findViewById(R.id.textView);
        btn.setOnClickListener(v -> {
            String s_log = ed1.getText().toString();
            String s_pas = ed2.getText().toString();
            if (s_log.equals(Log) && s_pas.equals(Pas)){
                tw.setGravity(Gravity.CENTER);
                tw.setTextColor(Color.GREEN);
                tw.setTextSize(25);
                tw.setText("Sign in successful!");
            }
            else{
                Toast.makeText(this, "Wrong login or password! Please create an account!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 1:
                tw.setText("");
                Log = data.getStringExtra("Log_r");
                ed1.setText(Log);
                ed2.setText("");
                Pas = data.getStringExtra("Pas_r");
                break;
        }
    }
}