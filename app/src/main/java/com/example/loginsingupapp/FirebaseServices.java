package com.example.loginsingupapp;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class FirebaseServices {
    private static FirebaseServices instnce ;
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;
    private FirebaseStorage storage;

    public FirebaseAuth getAuth() {
        return auth;
    }

    public FirebaseFirestore getFirestore() {
        return firestore;
    }

    public FirebaseStorage getStorage() {
        return storage;
    }

    public FirebaseServices(){
        auth =  FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();
        storage=FirebaseStorage.getInstance();
    }

    public static FirebaseServices getInstance(){
        if(instnce==null) {
            instnce=new FirebaseServices();
        }
        return instnce;
    }
}
