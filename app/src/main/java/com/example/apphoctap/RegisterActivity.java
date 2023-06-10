package com.example.apphoctap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apphoctap.Data.UserDao;
import com.example.apphoctap.Data.UserDataBase;
import com.example.apphoctap.model.User;
import com.shashank.sony.fancytoastlib.FancyToast;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextUsername, editTextEmail, editTextPassword, editTextCnfPassword;
    Button buttonRegister;

    TextView textViewLogin;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextCnfPassword = findViewById(R.id.editTextCnfPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        textViewLogin = findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        userDao = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.buttonRegister);
                String userName = editTextUsername.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passwordConf = editTextCnfPassword.getText().toString().trim();

//                if (password.equals(passwordConf)) {
//                    User user = new User(userName,password,email);
//                    userDao.insert(user);
//                    Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
//                    startActivity(moveToLogin);
//                FancyToast.makeText(RegisterActivity.this, "Зарегистрироваться успех", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();
//
//
//                }
                if(editTextUsername.length()==0){
                    editTextUsername.setError("Введите ИМЯ");
                }
                else if(editTextEmail.length()==0){
                    editTextEmail.setError("Введите email");

                }
                else if(editTextPassword.length()==0){
                    editTextPassword.setError("Введите пароль");
                }
                else if(editTextCnfPassword.length()==0){
                    editTextCnfPassword.setError("Введите пароль");

                }
                else if (password.equals(passwordConf)) {
                    User user = new User(userName,password,email);
                    userDao.insert(user);
                    Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(moveToLogin);
                    FancyToast.makeText(RegisterActivity.this, "Зарегистрироваться успех", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();


                }

                else {
                    FancyToast.makeText(RegisterActivity.this, "Пароль не подходит", FancyToast.LENGTH_SHORT, FancyToast.ERROR, true).show();

                }
            }
        });
    }
}
