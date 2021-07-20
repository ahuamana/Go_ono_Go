package com.paparazziteam.go_ono_go.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.paparazziteam.go_ono_go.Providers.UserProvider;
import com.paparazziteam.go_ono_go.R;

public class LoginActivity extends AppCompatActivity {

    TextView txtEmail, txtPassword;
    Button btnAcceder, btnRegistrar;

    UserProvider mUserProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = findViewById(R.id.edtEmail);
        txtPassword = findViewById(R.id.edtPassword);
        btnAcceder = findViewById(R.id.btnAcceder);
        btnRegistrar = findViewById(R.id.btnRegistrarse);

        mUserProvider = new UserProvider();


       implementsClickListener();




    }

    private void implementsClickListener() {

        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            goToLogin();


            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              gotoRegister();

            }
        });

    }

    private void gotoRegister() {

        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void goToLogin() {

        String email = txtEmail.getText().toString();
        String pass = txtPassword.getText().toString();

        if(email != null)
        {
            if(pass != null)
            {
                if (!email.equals(""))
                {
                    if(!pass.equals(""))
                    {
                        //login
                        mUserProvider.authenticateWithEmail(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful())
                                {
                                    Toast.makeText(LoginActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                    }
                }
            }
        }
    }
}