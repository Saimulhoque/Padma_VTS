package com.forbitbd.padmatracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.forbitbd.padmatracker.ui.main.MainActivity;
import com.forbitbd.padmatracker.utils.BaseActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PasswordActivity extends BaseActivity {

    private MaterialButton btnlogin;
    private EditText etPassword;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        mAuth = FirebaseAuth.getInstance();
        etPassword = findViewById(R.id.password);
        btnlogin = findViewById(R.id.login);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        Intent intent = getIntent();
        String email = intent.getStringExtra("Email");

        String password = etPassword.getText().toString();
     
      mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull  Task<AuthResult> task) {
              if(task.isSuccessful()){
                  final FirebaseUser user = mAuth.getCurrentUser();

                  startActivity(new Intent(PasswordActivity.this, MainActivity.class));
              }
          }
      });

    }
}