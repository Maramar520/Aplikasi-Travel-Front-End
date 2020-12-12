package com.example.travellerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText user, pass;
    private Button sign;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        sign = (Button) findViewById(R.id.signin);



        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getText().toString().equals("admin") && pass.getText().toString().equals("admin")) {
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_SHORT).show();
                }else{

                        Toast.makeText(getApplicationContext(), "Username atau Password Anda Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}