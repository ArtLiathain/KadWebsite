package com.example.kad;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    EditText email, student_num, name;

    Button submit_btn, check_data, dates;
    Button skipToRoomSelectionBtn;

    TextView txt1;
    CheckBox terms_box;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        student_num = findViewById(R.id.student_num);
        dates = findViewById(R.id.dates);
        submit_btn = findViewById(R.id.send_btn);

        check_data = findViewById(R.id.check_data);
        skipToRoomSelectionBtn = findViewById(R.id.skipRoomSelect_btn);

        txt1 = findViewById(R.id.txt1);
        terms_box = findViewById(R.id.term_box);

        terms_box.setText("By checking this box, you agree to our terms of service and privacy policy at https://google.ie");
        terms_box.setMovementMethod(LinkMovementMethod.getInstance());



        name.setError( "Name is required!" );
        email.setError( "Email is required!" );
        student_num.setError( "Student Number is required!" );

        logic1 logic1 = new logic1();
        Firebase firebase = new Firebase();



        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ensuring that all fields are filled
                if (TextUtils.isEmpty(name.getText()) | TextUtils.isEmpty(email.getText()) | TextUtils.isEmpty(student_num.getText())) {
                    Toast.makeText(MainActivity.this, "Enter your fucking data", Toast.LENGTH_SHORT).show();
                    txt1.setText("You must fill in every field");
                }
                else{
                    Toast.makeText(MainActivity.this,"every field has data", Toast.LENGTH_SHORT).show();
                }

                // ensuring all fields are following the logic in logic1.java
                if (logic1.student_num_year(Integer.parseInt(student_num.getText().toString())) == false | logic1.student_num_len(Integer.parseInt(student_num.getText().toString())) == false | logic1.email_format(email.getText().toString()) == true | logic1.name_length(name.getText().toString()) == false | logic1.string_alphabet(name.getText().toString()) ==false | logic1.blacklist(name.getText().toString()) ==false )  {
                    Toast.makeText(MainActivity.this, "Some of the data which you have entered is incorrect ", Toast.LENGTH_SHORT).show();

                }
                else if(logic1.check_box(terms_box) == false){
                    Toast.makeText(MainActivity.this,"You must agree to our Terms", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(MainActivity.this,"data is entered and is valid  ", Toast.LENGTH_SHORT).show();
                    firebase.add_firestore(email.getText().toString(), name.getText().toString(),Integer.parseInt(student_num.getText().toString()));
                }



            }
            });

        check_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebase.check_firestore(name.getText().toString(),Integer.parseInt(student_num.getText().toString()), email.getText().toString() );
            }
        });
        dates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebase.get_dates();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                Date dates_s = new Date(1220701200000L);
                Date dates_e = new Date(1222701200000L);
                Date date_s = new Date(122, 4, 2, 12, 00, 00); // Year: 1900+122= 2022, Month: every month needs to be decremented, month 0 is january
                Date date_e = new Date(122, 4, 2, 13, 00, 00);

                firebase.add_booking(1,true,22349111,(date_s), (date_e));
            }
        });



        skipToRoomSelectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RoomSelection.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "The Skip to Selection Button Works", Toast.LENGTH_SHORT).show();
                
            }
        });




    }


}