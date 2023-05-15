package com.example.kad.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kad.Generated;
import com.example.kad.R;


public class RoomSelectionActivity extends AppCompatActivity {

    Button buttonRoom1;
    Button buttonRoom2;
    Button buttonRoom3;
    public static final String roomArgumentKey = "roomArgumentKey";

    @Override
    @Generated
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_selection);

        buttonRoom1 = findViewById(R.id.room1);
        buttonRoom2 = findViewById(R.id.room2);
        buttonRoom3 = findViewById(R.id.room3);

        buttonRoom1.setOnClickListener(new View.OnClickListener() {

            @Generated
            @Override
            public void onClick(View view) {

                String room1Argument = "Room 1 - Conference Room";

                Intent intent = new Intent(RoomSelectionActivity.this, RoomBookingPageActivity.class);
                intent.putExtra(roomArgumentKey, room1Argument);
                startActivity(intent);
            }
        });

        buttonRoom2.setOnClickListener(new View.OnClickListener() {
            @Generated
            @Override
            public void onClick(View view) {
                String room2Argument = "Room 2 - Forest";
                Intent intent = new Intent(RoomSelectionActivity.this, RoomBookingPageActivity.class);
                intent.putExtra(roomArgumentKey, room2Argument);
                startActivity(intent);
            }
        });

        buttonRoom3.setOnClickListener(new View.OnClickListener() {
            @Generated
            @Override
            public void onClick(View view) {

                String room3Argument = "Room 3 - Office Space";
                Intent intent = new Intent(RoomSelectionActivity.this, RoomBookingPageActivity.class);
                intent.putExtra(roomArgumentKey, room3Argument);
                startActivity(intent);
            }
        });
    }
}
