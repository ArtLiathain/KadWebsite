package com.example.kad;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    EditText email, student_num;
    Button send_btn;
    TextView number_vw;
    DatabaseReference KadDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        student_num = findViewById(R.id.student_num);
        send_btn = findViewById(R.id.send_btn);
        number_vw = findViewById(R.id.number);



        KadDbRef = FirebaseDatabase.getInstance().getReference().child("bookings");

        send_btn.setOnClickListener(view -> insertBookingData());

        // Write a message to the database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
    }
    private void insertBookingData(){
        String student_email = email.getText().toString();
        int student_number = Integer.parseInt(student_num.getText().toString());
        Bookings booking1 = new Bookings(student_email, student_number);
        KadDbRef.push().setValue(booking1);
        Toast.makeText(MainActivity.this,"Data entered", Toast.LENGTH_SHORT).show();

    }




}