package com.example.ewallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        pref = getSharedPreferences("user_details", MODE_PRIVATE);

        EditText uname = findViewById(R.id.editName);
        EditText pwd = findViewById(R.id.editPWD);

        Button login = findViewById(R.id.loginButton);
        Button register = findViewById(R.id.register);
        Button home = findViewById(R.id.button20);

        pref = getSharedPreferences("user_details", MODE_PRIVATE);

        if(pref.contains("username") && pref.contains("password")) {
            startActivity(intent);
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, home.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = uname.getText().toString();
                String password = pwd.getText().toString();
                intent = new Intent(MainActivity.this, home.class);

                if(username.equals(loginRegister.NAME) && password.equals(loginRegister.PWD)) {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Credentials Mismatched", Toast.LENGTH_SHORT).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, loginRegister.class);

                startActivity(intent);
            }
        });
    }
}