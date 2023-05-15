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


public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText name;
    EditText studentNumberEditText;
    Button submitButton;
    TextView txt1;
    CheckBox termsCheckBox;


    @Override
    @Generated
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        studentNumberEditText = findViewById(R.id.student_num);
        submitButton = findViewById(R.id.send_btn);
        txt1 = findViewById(R.id.txt1);
        termsCheckBox = findViewById(R.id.term_box);

        termsCheckBox.setText("By checking this box, you agree to our terms of service and privacy policy ");
        termsCheckBox.setMovementMethod(LinkMovementMethod.getInstance());
        name.setError("Name is required!");
        email.setError("Email is required!");
        studentNumberEditText.setError("Student Number is required!");

        Firebase firebase = new Firebase();
        AuthLogic authLogic = new AuthLogic();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            @Generated
            public void onClick(View view) {
                // ensuring that all fields are filled
                if (TextUtils.isEmpty(name.getText()) | TextUtils.isEmpty(email.getText()) | TextUtils.isEmpty(studentNumberEditText.getText())) {
                    Toast.makeText(MainActivity.this, "Enter your fucking data", Toast.LENGTH_SHORT).show();
                    txt1.setText("You must fill in every field");
                } else {
                    Toast.makeText(MainActivity.this, "every field has data", Toast.LENGTH_SHORT).show();
                }

                // ensuring all fields are following the logic in logic1.java
                if (!authLogic.studentNumYear(Integer.parseInt(studentNumberEditText.getText().toString())) || !authLogic.studentNumLen(Integer.parseInt(studentNumberEditText.getText().toString())) || authLogic.emailFormat(email.getText().toString()) || !authLogic.validLength(name.getText().toString()) || !authLogic.stringAlphabet(name.getText().toString()) || !authLogic.blacklist(name.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Some of the data which you have entered is incorrect ", Toast.LENGTH_SHORT).show();

                } else if (!authLogic.checkBox(termsCheckBox)) {
                    Toast.makeText(MainActivity.this, "You must agree to our Terms", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "data is entered and is valid  ", Toast.LENGTH_SHORT).show();
                    firebase.addFirestore(email.getText().toString(), name.getText().toString(), Integer.parseInt(studentNumberEditText.getText().toString()));
                    txt1.setText("Valid data entered");
                }

                Intent intent = new Intent(MainActivity.this, RoomSelection.class);
                startActivity(intent);

            }
        });
    }
}