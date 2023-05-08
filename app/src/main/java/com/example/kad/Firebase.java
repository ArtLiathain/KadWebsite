package com.example.kad;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Firebase {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference docRef = db.collection("Logins");
    CollectionReference bookingsRef = db.collection("Bookings");
    public void addFirestore(String email, String name, int student_number){
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
                        System.out.println("Happy, data has been added");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }

    // check to see if there is a matching document in the firestore
    public void checkFirestore(String name, int student_num, String email){
        Query query = docRef.whereEqualTo("name", name).whereEqualTo("Email", email).whereEqualTo("Student Number", student_num);

        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult().isEmpty()) {
                        // No documents match the query
                        System.out.println("There is no dcuments matching the inputed name");
                    } else {
                        System.out.println("There has been documents found matching the name");
                        // At least one document matches the query
                        for (DocumentSnapshot document : task.getResult()) {
                            String name = document.getString("name");
                            System.out.println("The name that has been discovereed in the firestore is:"+ name);
                            // Access the document data here
                        }
                    }
                } else {
                    System.out.println("Was unable to connect to the firebase");
                    // Failed to retrieve documents from the collection
                }
                }


        });

    }

    public void get_dates(){
        List<Date> dates = new ArrayList<Date>();
        Date startDate = new Date(122, 4, 2, 0, 00, 00); // Year: 1900+122= 2022, Month: every month needs to be decremented, month 0 is january
        Date endDate = new Date(122, 4, 2, 23, 59, 59);
        Query query = bookingsRef.whereGreaterThanOrEqualTo("Start DateTime", startDate).whereLessThan("Start DateTime", endDate);
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>
                () {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        dates.add(document.getDate("Start DateTime"));
//                        System.out.println(document.getDate("Start DateTime"));
                        Log.d(TAG, document.getId() + " => " + document.getDate("Start DateTime"));
                    }
                } else {
                    Log.d(TAG, "Error getting documents: ",
                            task.getException());
                }
                System.out.println("These are all of the dates for the period date period range");
                System.out.println(dates);
            }

        });

        System.out.println("hello");

    }

    public void addBooking(int room_number, boolean snacks, int student_number, Date start, Date end){
        Map<String, Object> data1 = new HashMap<>();
        data1.put("Room Number", room_number);
        data1.put("Snacks", snacks);
        data1.put("Student Number", student_number);
        data1.put("Start DateTime", start);
        data1.put("End DateTime", end);


        db.collection("Bookings").document()
                .set(data1)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                        System.out.println("Happy, data has been added");
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
