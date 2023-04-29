package com.example.kad;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.firestore.CollectionReference;

import java.util.HashMap;
import java.util.Map;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class firebase {

    public void add_firestore(String email, String name, int student_number){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference cities = db.collection("Logins");
        Map<String, Object> data1 = new HashMap<>();
        data1.put("Email", email);
        data1.put("Student Number", student_number);
        data1.put("name", name);


        db.collection("Logins").document()
                .set(data1)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }
}
