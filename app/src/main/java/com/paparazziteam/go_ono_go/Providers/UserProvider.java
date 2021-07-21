package com.paparazziteam.go_ono_go.Providers;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.paparazziteam.go_ono_go.models.User;

public class UserProvider {

    private CollectionReference mCollection;

    public UserProvider()
    {
        mCollection = FirebaseFirestore.getInstance().collection("Users");
    }

    public Task<Void> create(User user)
    {
        return mCollection.document(user.getEmail()).set(user);
    }
}
