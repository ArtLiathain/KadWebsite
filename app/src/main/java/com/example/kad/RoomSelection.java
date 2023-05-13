package com.example.kad;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class RoomSelection extends AppCompatActivity {

    Button buttonRoom1;
    Button buttonRoom2;
    Button buttonRoom3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_selection);

        buttonRoom1 = findViewById(R.id.room1);
        buttonRoom2 = findViewById(R.id.room2);
        buttonRoom3 = findViewById(R.id.room3);

        buttonRoom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomSelection.this, RoomBookingPage.class);
                startActivity(intent);
                Toast.makeText(RoomSelection.this, "The Room1 Button Works", Toast.LENGTH_SHORT).show();
            }
        });

        buttonRoom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomSelection.this, RoomBookingPage.class);
                startActivity(intent);
                Toast.makeText(RoomSelection.this, "The Room2 Button Works", Toast.LENGTH_SHORT).show();
            }
        });

        buttonRoom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomSelection.this, RoomBookingPage.class);
                startActivity(intent);
                Toast.makeText(RoomSelection.this, "The Room3 Button Works", Toast.LENGTH_SHORT).show();
            }
        });



    }


}
