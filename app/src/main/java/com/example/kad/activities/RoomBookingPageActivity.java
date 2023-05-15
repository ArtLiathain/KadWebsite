package com.example.kad.activities;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.kad.DateTimeLogic;
import com.example.kad.FirebaseLogic;

import com.example.kad.Generated;
import com.example.kad.R;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;


public class RoomBookingPageActivity extends AppCompatActivity {


    Spinner hoursAvailable;
    DatePicker datePicker;
    Button buttonToRoomSelection;
    Button buttonToPlaceBooking;
    TextView textOfRoomInfo;
    LocalDateTime chosenDate;
    Date uploadDate;
    int roomNumberInt;
    DateTimeLogic dateTimeLogic = new DateTimeLogic();
    FirebaseLogic firebaseLogic = new FirebaseLogic();
    String passedStudentNumberArgument;
    int studentNumberArgument;


    @SuppressLint("MissingInflatedId")
    @Override
    @Generated
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_booking_page);

//-------------------------Argument Passed Into TextView---------------------------
        textOfRoomInfo = findViewById(R.id.textViewRoomInfo);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            passedStudentNumberArgument = extras.getString("studentNumberKey");
            studentNumberArgument = Integer.parseInt(passedStudentNumberArgument);
            String passedArgument = extras.getString("roomArgumentKey");
            textOfRoomInfo.setText(passedArgument);
            Character roomNumberChar = passedArgument.charAt(5);
            roomNumberInt = Character.getNumericValue(roomNumberChar);
        }


// ---------------------------------Back Button---------------------------------
        buttonToRoomSelection = findViewById(R.id.backButtonRoomSelection);
        buttonToRoomSelection.setOnClickListener(new View.OnClickListener() {
            @Generated
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomBookingPageActivity.this, RoomSelectionActivity.class);
                startActivity(intent);
            }
        });


// -----------------------------Place Booking Button---------------------------------
        buttonToPlaceBooking = findViewById(R.id.placeBookingButton);
        buttonToPlaceBooking.setOnClickListener(new View.OnClickListener() {
            @Generated
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomBookingPageActivity.this, BookingConfirmationActivity.class);
                firebaseLogic.addBooking(roomNumberInt, studentNumberArgument, uploadDate); // Start is of type 'Date'
                startActivity(intent);
            }
        });


// ---------------------------------Date Picker---------------------------------

        datePicker = findViewById(R.id.datePicker);
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            @Generated
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                chosenDate = LocalDateTime.of(year, monthOfYear, dayOfMonth, 00, 00);
                uploadDate = Date.from(chosenDate.toInstant(ZoneOffset.UTC));
            }
        });
        // LocalDateTime startDate = LocalDateTime.of(122, 4, 2, 0, 00, 00);


// ---------------------------------Hours Available---------------------------------
        hoursAvailable = findViewById(R.id.dropdownTimeSelection);
        // Retrieve a list of available times from a data source
        firebaseLogic.getDates(LocalDateTime.now(), 1);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item,
                dateTimeLogic.returnStartTimes(firebaseLogic.getStartDates(), chosenDate));
        // Styles dropdown of numbers nicely
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hoursAvailable.setAdapter(ad);
// ------------------------------------------------------------------------
        hoursAvailable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            @Generated
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Method is not implemented yet
            }
            @Override
            @Generated
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

    }
}
