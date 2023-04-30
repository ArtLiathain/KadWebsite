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

public class Room1 extends AppCompatActivity { //--------------------------------------------------
    Button RoomSelection;
    Spinner hoursAvailable;

    DatePicker datePicker;

    @SuppressLint("MissingInflatedId")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_1);

// ---------------------------------Back Button---------------------------------

        RoomSelection = findViewById(R.id.backRoom1);
        RoomSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Room1.this, RoomSelection.class);
                startActivity(intent);
                Toast.makeText(Room1.this, "The Back R1 Button Works", Toast.LENGTH_SHORT).show();
            }
        });


// ---------------------------------Date Picker---------------------------------

        datePicker = findViewById(R.id.datePicker1);
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(Room1.this, "Calendar Works " + dayOfMonth + ' ' + monthOfYear + ' ' + year, Toast.LENGTH_SHORT).show();
            }
        });


// ---------------------------------Hours Available---------------------------------

        hoursAvailable = findViewById(R.id.hours_spinner);
        // Retrieve a list of available times from a data source
        List<Integer> listHoursAvailable = functionListHoursAvailable();;
        //functionListHoursAvailable();
        //roomSelectionLogic.functionListHoursAvailable();

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


    } //---------------------------------End of On Create---------------------------------
    private List<Integer> functionListHoursAvailable() {
        return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // "10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM"
    }

}