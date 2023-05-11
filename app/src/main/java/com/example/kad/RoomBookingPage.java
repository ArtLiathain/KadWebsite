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
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.List;
import com.example.kad.roomBookingPageLogic;


public class RoomBookingPage extends AppCompatActivity {


    Button roomSelectionButton;
    Spinner hoursAvailable;
    DatePicker datePicker;

    @SuppressLint("MissingInflatedId")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_booking_page);

// ---------------------------------Back Button---------------------------------

        RoomSelection = findViewById(R.id.backButtonRoomSelection);
        RoomSelection.setOnClickListener(new View.OnClickListener() {
            @Generated
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomBookingPage.this, RoomSelection.class);
                startActivity(intent);
                Toast.makeText(RoomBookingPage.this, "The Back Button Works", Toast.LENGTH_SHORT).show();
            }
        });


// ---------------------------------Date Picker---------------------------------

        datePicker = findViewById(R.id.datePicker);
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(RoomBookingPage.this, "Calendar Works " + dayOfMonth + ' ' + monthOfYear + ' ' + year, Toast.LENGTH_SHORT).show();
            }
        });

// ---------------------------------Hours Available---------------------------------
        hoursAvailable = findViewById(R.id.dropdownTimeSelection);
        // Retrieve a list of available times from a data source
        roomBookingPageLogic RoomBookingPageLogicLogic = new roomBookingPageLogic();
        List<String> listHoursAvailable = RoomBookingPageLogicLogic.functionListHoursAvailable();

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listHoursAvailable);
        // Styles dropdown of numbers nicely
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hoursAvailable.setAdapter(ad);
// ------------------------------------------------------------------------
        hoursAvailable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "The Selected Hours -> " + selectedItem, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });


    }
}
