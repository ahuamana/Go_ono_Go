package com.paparazziteam.go_ono_go.Providers;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserProvider {

    FirebaseAuth mAuth;

    public UserProvider() {
        this.mAuth = FirebaseAuth.getInstance();
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
