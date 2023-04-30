package com.example.kad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Room1 extends AppCompatActivity {
    Spinner attendeesNumber;

    // create array of Strings
    // and store name of courses
    Integer[] number_of_attendees = { 1, 2, 3, 4, 5, 6, 7, 9, 10 };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_1);

        attendeesNumber = findViewById(R.id.attendees_spinner);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, number_of_attendees);

        // Styles dropdown of numbers nicely
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        attendeesNumber.setAdapter(ad);
    }


    /*
    @Override
    public void onItemSelected(AdapterView<*> arg0, View arg1, int position, long id)
    {

        // make toastof name of course
        // which is selected in spinner
        Toast.makeText(getApplicationContext(), courses[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<*> arg0)
    {
        // Auto-generated method stub
    }
    */

        /*
        attendeesNumber.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout., new String[]{"Option 1", "Option 2", "Option 3"});
                Spinner spinner = null;
                spinner.setAdapter(adapter);

                Toast.makeText(Room1.this, "The Room1 Button Works", Toast.LENGTH_SHORT).show();
            }
        });
        */
        

}
