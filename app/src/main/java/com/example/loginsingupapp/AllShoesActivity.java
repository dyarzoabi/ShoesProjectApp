package com.example.loginsingupapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AllShoesActivity extends AppCompatActivity {
    private RecyclerView rvAllRest;
    AdapterShoes adapter;
    FirebaseServices fbs;
    ArrayList<Sneakers> Shoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_shoes);
        fbs = FirebaseServices.getInstance();
       Shoes = new ArrayList<Sneakers>();
        readData();

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvRestsAllRest);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterShoes(this, Shoes);
        recyclerView.setAdapter(adapter);
    }
    private void readData() {
        fbs.getFirestore().collection("sneakers")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Shoes.add(document.toObject(Sneakers.class));
                            }
                        } else {
                            Log.e("AllRestActivity: readData()", "Error getting documents.", task.getException());
                        }
                    }
                });
    }






}