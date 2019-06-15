package com.example.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegistarActivity extends AppCompatActivity {
    EditText name,email,password,CONFIRM;
    Button register;
    DatabaseHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        name = findViewById(R.id.T1);
        email = findViewById(R.id.T2);
        password = findViewById(R.id.pass);
      CONFIRM = findViewById(R.id.confirm);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent (RegistarActivity.this, MainActivity.class);
                startActivity(mainIntent);

            }




        });




//  register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String user =name.getText().toString().trim();
//                String mail = email.getText().toString().trim();
//                String pwd = password.getText().toString().trim();
//                String cnf = CONFIRM.getText().toString().trim();
//
//                if(password.equals(CONFIRM)){
//                    long val = db.addUser(user,mail,pwd);
//                    if(val > 0){
//                        Toast.makeText(RegistarActivity.this,"You have registered",Toast.LENGTH_SHORT).show();
//                        Intent moveToLogin = new Intent(RegistarActivity.this,MainActivity.class);
//                        startActivity(moveToLogin);
//                    }
//                    else{
//                        Toast.makeText(RegistarActivity.this,"Registration Error",Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//                else{
//                    Toast.makeText(RegistarActivity.this,"Password is not matching",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
}
