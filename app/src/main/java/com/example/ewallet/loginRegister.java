package com.example.ewallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginRegister extends AppCompatActivity {

    Intent intent;

    SharedPreferences pref;

    public static final String NAME = "NAME";
    public static final String PWD = "PWD";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        EditText regName = findViewById(R.id.editName);
        EditText regPwd = findViewById(R.id.editPWD);

        Button login = findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = regName.getText().toString();
                String pwd = regPwd.getText().toString();

                pref = getSharedPreferences(NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString(NAME, name);
                editor.putString(PWD, pwd);
                editor.apply();
                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                intent = new Intent(loginRegister.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}