package com.paparazziteam.go_ono_go.Providers;

import android.content.Context;

import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserProvider {

    private FirebaseAuth mAuth;

    public UserProvider() {
        mAuth = FirebaseAuth.getInstance();
    }

    public Task<AuthResult> registerWithEmail(String email, String pass)
    {
        return mAuth.createUserWithEmailAndPassword(email,pass);
    }

    public Task<AuthResult> authenticateWithEmail(String email, String pass)
    {
        return mAuth.signInWithEmailAndPassword(email, pass);
    }
}
