package com.example.loginsingupapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText emailmain, passwodmain;
    private FirebaseAuth auth;
    private EditText etUsername, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.emailmain);
        etPassword = findViewById(R.id.passwordmain);
        auth = FirebaseAuth.getInstance();
    }

    public void login(View view) {
        // TODO: 1- Get data from screen

        String username = emailmain.getText().toString();
        String password = passwodmain.getText().toString();

        // TODO: 2- Data validation

        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            Toast.makeText(this, "Username or password is missing!", Toast.LENGTH_SHORT).show();
            return;

        }

        auth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // TODO: commands if successful
                        } else {


                            Toast.makeText(MainActivity.this, "Username or password is empty!", Toast.LENGTH_SHORT).show();
                            return;
                        }


                    }
                });
    }
}







