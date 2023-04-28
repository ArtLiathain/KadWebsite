package com.example.kad;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import org.junit.runner.JUnitCore;
//import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    EditText email, student_num, name;
    Button submit_btn;
    TextView txt1;
    DatabaseReference KadDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        student_num = findViewById(R.id.student_num);
        submit_btn = findViewById(R.id.send_btn);
        txt1 = findViewById(R.id.txt1);
        name.setError( "Name is required!" );
        email.setError( "Email is required!" );
        student_num.setError( "Student Number is required!" );
        logic1 karl = new logic1();
//        Result result = JUnitCore.runClasses(MainActivityTest.class);


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(name.getText()) | TextUtils.isEmpty(email.getText()) | TextUtils.isEmpty(student_num.getText())) {
                    Toast.makeText(MainActivity.this, "Enter your fucking data", Toast.LENGTH_SHORT).show();
                    txt1.setText("You must fill in every field");
                }
//                if (karl.student_num_len(Integer.parseInt(student_num.toString()))== true & karl.student_num_year(Integer.parseInt(student_num.toString())) == true){
//                    System.out.println("very good");
//                }
//                else{
//                    System.out.println("Error");
//                }

                Toast.makeText(MainActivity.this,"Data entered", Toast.LENGTH_SHORT).show();
            }
            });


//            Intent i = new Intent(getApplicationContext(), Login.class);
//            startActivity(i);



    }
    private void insertBookingData(){
//        String student_email = email.getText().toString();
//        int student_number = Integer.parseInt(student_num.getText().toString());
//        Bookings booking1 = new Bookings(student_email, student_number);
//        KadDbRef.push().setValue(booking1);
        System.out.println("button clicked");
//        Toast.makeText(MainActivity.this,"Data entered", Toast.LENGTH_SHORT).show();

    }




}