package com.example.kad;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;


public class RoomBookingPage extends AppCompatActivity {
    Spinner hoursAvailable;
    DatePicker datePicker;
    Button buttonToRoomSelection;
    Button buttonToPlaceBooking;
    TextView textOfRoomInfo;


    @SuppressLint("MissingInflatedId")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    @Generated
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_booking_page);

//-------------------------Argument Passed Into TextView---------------------------
        textOfRoomInfo = findViewById(R.id.textViewRoomInfo);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String passedArgument = extras.getString("roomArgumentKey");
            textOfRoomInfo.setText(passedArgument);
            Toast.makeText(RoomBookingPage.this, passedArgument, Toast.LENGTH_SHORT).show();
        }

// ---------------------------------Back Button---------------------------------
        buttonToRoomSelection = findViewById(R.id.backButtonRoomSelection);
        buttonToRoomSelection.setOnClickListener(new View.OnClickListener() {
            @Generated
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomBookingPage.this, RoomSelection.class);
                startActivity(intent);
                Toast.makeText(RoomBookingPage.this, "The Back Button Works", Toast.LENGTH_SHORT).show();
            }
        });


// -----------------------------Place Booking Button---------------------------------
        buttonToPlaceBooking = findViewById(R.id.placeBookingButton);
        buttonToPlaceBooking.setOnClickListener(new View.OnClickListener() {
            @Generated
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomBookingPage.this, BookingConfirmation.class);
                startActivity(intent);
                Toast.makeText(RoomBookingPage.this, "The Place Booking Button Works", Toast.LENGTH_SHORT).show();
            }
        });


// ---------------------------------Date Picker---------------------------------

        datePicker = findViewById(R.id.datePicker);
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            @Generated
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(RoomBookingPage.this, "Calendar Works " + dayOfMonth + ' ' + monthOfYear + ' ' + year, Toast.LENGTH_SHORT).show();
            }
        });


// ---------------------------------Hours Available---------------------------------
        hoursAvailable = findViewById(R.id.dropdownTimeSelection);
        // Retrieve a list of available times from a data source
        RoomBookingPageLogic roomBookingPageLogicLogic = new RoomBookingPageLogic();
        List<String> listHoursAvailable = roomBookingPageLogicLogic.functionListHoursAvailable();

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listHoursAvailable);
        // Styles dropdown of numbers nicely
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hoursAvailable.setAdapter(ad);
// ------------------------------------------------------------------------
        hoursAvailable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            @Generated
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "The Selected Hours -> " + selectedItem, Toast.LENGTH_SHORT).show();
            }
            @Override
            @Generated
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

    }
}
