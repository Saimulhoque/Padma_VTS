package com.forbitbd.padmatracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.forbitbd.padmatracker.ui.login.LoginActivity;
import com.forbitbd.padmatracker.ui.main.MainActivity;
import com.forbitbd.padmatracker.utils.BaseActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUpActivity extends BaseActivity {

    private MaterialButton btnsignup;
    private TextInputEditText etEmail, etPassword;
    FirebaseAuth mAuth;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        etEmail = findViewById(R.id.email);
        etPassword = findViewById(R.id.password);
        btnsignup = findViewById(R.id.signup);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            final FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {

                                            HashMap<String, Object> userMap = new HashMap<>();
                                            userMap.put("email", email);
                                            userMap.put("password", password);

                                            reference.push().setValue(userMap);
                                            showSignupSuceesDialog();
                                        }
                                    }
                                });
                            }
                        }
                    }
                });
            }
        });
    }

    private void showSignupSuceesDialog() {
        Toast toast = Toast.makeText(this, "We send a verification mail to your Email. Please verify and then Login", Toast.LENGTH_SHORT);
        toast.show();


    }

}