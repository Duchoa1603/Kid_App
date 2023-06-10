package com.example.apphoctap;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.apphoctap.Data.UserDao;
import com.example.apphoctap.Data.UserDataBase;
import com.example.apphoctap.model.User;


public class LoginActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword;
    Button buttonLogin;
    TextView textViewRegister;
    UserDao db;
    UserDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        textViewRegister = findViewById(R.id.textViewRegister);

        dataBase = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();


        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                User user = db.getUser(email, password);
//                if (user != null) {
//                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
//                    i.putExtra("User", user);
//                    startActivity(i);
//                    finish();
//                }else{
//                    Toast.makeText(LoginActivity.this, "Незарегистрированный пользователь или неверный", Toast.LENGTH_SHORT).show();
//                }

                if(editTextEmail.length()==0){
                    editTextEmail.setError("Введите Email");
                }
                else if(editTextPassword.length()==0){
                    editTextPassword.setError("Введите пароль");
                }
                else if (user != null) {
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    i.putExtra("User", user);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Незарегистрированный пользователь или неверный", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
