package com.forbitbd.padmatracker.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.forbitbd.padmatracker.utils.BaseActivity;
import com.forbitbd.padmatracker.ui.main.MainActivity;
import com.forbitbd.padmatracker.PasswordActivity;
import com.forbitbd.padmatracker.R;
import com.forbitbd.padmatracker.SignUpActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.material.button.MaterialButton;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginContract.View {

    private MaterialButton btnnxt;
    private TextView btnsignup;
    private ImageView google;
    private static final int RC_SIGN_IN = 9001;
    private LoginContract.Presenter mPresenter;
    private EditText etEmail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mPresenter = new LoginPresenter(this);

        etEmail = findViewById(R.id.email);
        btnnxt = findViewById(R.id.next);
        btnsignup = findViewById(R.id.signup);
        google = findViewById(R.id.google);

        btnnxt.setOnClickListener(this);
        btnsignup.setOnClickListener(this);
        google.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.next){
            String email = etEmail.getText().toString().trim();
            Intent intent = new Intent(LoginActivity.this, PasswordActivity.class);
            intent.putExtra("Email", email);
//            Log.d("hhh", "onClick: "+email);
            startActivity(intent);
        }else if (id == R.id.signup){
            startActivity(new Intent(this, SignUpActivity.class));
        }else if (id == R.id.google){
            googleSignIn();
        }
    }

    private void googleSignIn() {
        Intent signInIntent = getGoogleApiClient().getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case RC_SIGN_IN:
                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                mPresenter.startAutentication(result);
                break;
        }
    }

    @Override
    public void startMainActivity() {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}