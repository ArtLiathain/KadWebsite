package com.example.kad;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class FirebaseLogic {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference docRef = db.collection("Logins");
    CollectionReference bookingsRef = db.collection("Bookings");

    private static final Logger LOGGER = Logger.getLogger(FirebaseLogic.class.getName());


    String studentNumber = "Student Number";
    String studentName = "Student Name";
    String studentEmail = "Student Email";

    ArrayList<LocalDateTime> startDatesList;

    String startDATE = "Start DateTime";
    String roomNumberString = "Room Number";

    public void addFirestore(String email, String name, int studentNumberAddFire){
        Map<String, Object> data1 = new HashMap<>();
        data1.put(studentEmail, email);
        data1.put(studentNumber, studentNumberAddFire);
        data1.put(studentName, name);

        db.collection("Logins").document()
                .set(data1)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                        Log.d(TAG,"Happy, data has been added");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }


    public void checkFirestore(String name, int studentNumberCheckFire, String email){
        Query query = docRef.whereEqualTo(studentName, name).whereEqualTo(studentEmail, email).whereEqualTo(studentNumber, studentNumberCheckFire);

        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult().isEmpty()) {
                        // No documents match the query
                        Log.d(TAG,"There is no dcuments matching the inputed name");
                    } else {
                        Log.d(TAG,"There has been documents found matching the name");
                        // At least one document matches the query
                    }
                } else {
                    Log.d(TAG,"Was unable to connect to the firebase");
                    // Failed to retrieve documents from the collection
                }
                }


        });

    }

    public void getDates(LocalDateTime time, int room){
        ArrayList<LocalDateTime> dates = new ArrayList<LocalDateTime>();
        LocalDateTime startDate = LocalDateTime.of(time.getYear()-1900, time.getMonthValue(),
                time.getDayOfMonth(), 0, 00, 00);
        LocalDateTime endDate = LocalDateTime.of(time.getYear()-1900, time.getMonthValue(),
                time.getDayOfMonth(), 23, 59, 59);
        int chosenRoom = 2; //Needs to be changed to ge the room number form RoomSelection.java
        Query query = bookingsRef.whereGreaterThanOrEqualTo(startDATE, startDate).whereLessThan(startDATE, endDate).whereEqualTo(roomNumberString, room);
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>
                () {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        dates.add(document.getDate(startDATE).toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDateTime());
                        Log.d(TAG, document.getId() + " => " + document.getDate(startDATE));
                    }
                } else {
                    Log.d(TAG, "Error getting documents: ",
                            task.getException());
                }
                Log.d(TAG,"These are all of the dates for the period date period range");
                LOGGER.info(dates.toString());
                startDatesList = dates;

            }

        });

    }

    public void addBooking(int roomNumberAddBooking, int studentNumberAddBooking, Date start){
        Map<String, Object> data1 = new HashMap<>();
        data1.put("Room Number", roomNumberAddBooking);
        data1.put("Student Number", studentNumberAddBooking);
        data1.put(startDATE, start);



        db.collection("Bookings").document()
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
    public ArrayList<LocalDateTime> getStartDates(){
        return startDatesList;

    }
}
