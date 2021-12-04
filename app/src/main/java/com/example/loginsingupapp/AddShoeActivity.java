package com.example.loginsingupapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

import java.io.IOException;


public class AddShoeActivity extends AppCompatActivity {

    private static final String TAG = "AddRestActivity";
    private EditText etComppanyname,etcolorsho,etprice,etsize, etAddress, etPhone;
    private Spinner spCat;
    private ImageView ivPhoto;
    private FirebaseServices fbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shoe);

        //getSupportActionBar().hide();
        connectComponents();
    }
    private void connectComponents() {
        etComppanyname= findViewById(R.id.etCompanyname);
        etcolorsho= findViewById(R.id.etcolorshoes);
        etprice= findViewById(R.id.etprice);
        etsize=findViewById(R.id.etsize);
         etAddress=findViewById(R.id.etAddress);
        etPhone=findViewById(R.id.etPhone);
       ivPhoto=findViewById(R.id.etPhoto);
        fbs = FirebaseServices.getInstance();
        spCat.setAdapter(new ArrayAdapter<Companysnames>(this, android.R.layout.simple_list_item_1, Companysnames.values()));

    }

    public void add(View view) {
        // check if any field is empty
        String Comppanyname, colorsho, price, size, address, Phone, photo, category;

        Comppanyname = etComppanyname.getText().toString();
        colorsho = etcolorsho.getText().toString();
        address = etAddress.getText().toString();
        Phone = etPhone.getText().toString();
        price = etprice.getText().toString();
        size = etsize.getText().toString();
        category = spCat.getSelectedItem().toString();
        if (ivPhoto.getDrawable() == null)
            photo = "no_image";
        else photo = ivPhoto.getDrawable().toString();

        if (Comppanyname.trim().isEmpty() || colorsho.trim().isEmpty() || address.trim().isEmpty() ||
                price.trim().isEmpty() || size.trim().isEmpty() || Phone.trim().isEmpty()|| photo.trim().isEmpty() ) {
            Toast.makeText(this, "Some fields are empty!", Toast.LENGTH_SHORT).show();
            return;
        }

    Sneakers sneakers = new Sneakers( size, colorsho,Comppanyname,Phone, price, address , photo,Companysnames.valueOf(category));
       fbs.getFirestore().collection("Sneakers")
                     .add(sneakers)
                     .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {

        @Override
        public void onSuccess(DocumentReference documentReference) {
            Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
        }
    })
         .addOnFailureListener(new OnFailureListener() {

        @Override
        public void onFailure(@NonNull Exception e) {
            Log.w(TAG, "Error adding document", e);
        }
    });
}

    public void selectPhoto(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),40);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 40) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED)  {
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
