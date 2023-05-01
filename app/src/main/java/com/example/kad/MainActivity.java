package com.example.kad;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    EditText email, student_num, name;
    Button submit_btn, skipToRoomSelectionBtn;
    TextView txt1;
    CheckBox terms_box;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        student_num = findViewById(R.id.student_num);
        submit_btn = findViewById(R.id.send_btn);
        skipToRoomSelectionBtn = findViewById(R.id.skipRoomSelect_btn);
        txt1 = findViewById(R.id.txt1);
        terms_box = findViewById(R.id.term_box);

        name.setError( "Name is required!" );
        email.setError( "Email is required!" );
        student_num.setError( "Student Number is required!" );

        logic1 logic1 = new logic1();
//        Result result = JUnitCore.runClasses(MainActivityTest.class);


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(name.getText()) | TextUtils.isEmpty(email.getText()) | TextUtils.isEmpty(student_num.getText())) {
                    Toast.makeText(MainActivity.this, "Enter your fucking data", Toast.LENGTH_SHORT).show();
                    txt1.setText("You must fill in every field");
                }
                else{
                    Toast.makeText(MainActivity.this,"every field has data", Toast.LENGTH_SHORT).show();
                }
                if (logic1.student_num_year(Integer.parseInt(student_num.getText().toString())) == false | logic1.student_num_len(Integer.parseInt(student_num.getText().toString())) == false | logic1.email_format(email.getText().toString()) == true | logic1.name_length(name.getText().toString()) == false | logic1.string_alphabet(name.getText().toString()) ==false | logic1.blacklist(name.getText().toString()) ==false )  {
                    Toast.makeText(MainActivity.this, "Some of the data which you have entered is incorrect ", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(MainActivity.this,"data is entered and is valid  ", Toast.LENGTH_SHORT).show();
                }

//                if (karl.student_num_len(Integer.parseInt(student_num.toString()))== true & karl.student_num_year(Integer.parseInt(student_num.toString())) == true){
//                    System.out.println("very good");
//                }
//                else{
//                    System.out.println("Error");
//                }





            }
            });


//            Intent i = new Intent(getApplicationContext(), Login.class);
//            startActivity(i);


        skipToRoomSelectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RoomSelection.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "The Skip to Selection Button Works", Toast.LENGTH_SHORT).show();
                
            }
        });



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