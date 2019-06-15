package com.example.loginapp;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

EditText T4,T5;
Button log;
TextView reg;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        T4 = findViewById(R.id.T4);
        T5 = findViewById(R.id.T5);
        log = findViewById(R.id.login);

        reg  = findViewById(R.id.txtRegister);
        reg .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent (MainActivity.this, RegistarActivity.class);
                startActivity(registerIntent);


            }
        });
    }
}
