package com.example.loginsingupapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SingupActivity extends AppCompatActivity {

    private EditText etUsername, etPassword, etConfirmPassword;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
    }

    public void Singup(View view) {
        // TODO: 1- Get data from screen
        String username = etUsername.getText().toString();
        String password = etUsername.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();

        // TODO: 2- Data validation
        if (username.trim().isEmpty() || password.trim().isEmpty()
                || confirmPassword.trim().isEmpty()) {
            Toast.makeText(this, "Username or password is missing!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match!!", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO: 3- Check username and password with Firebase Authentication
        auth.createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // TODO: commands if successful
                        } else {


                            Toast.makeText(SingupActivity.this, "Username or password is empty!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });


    }

}
