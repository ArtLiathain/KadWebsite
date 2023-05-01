package com.example.kad;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class RoomSelection extends AppCompatActivity {

    Button Room1, Room2, Room3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_selection);

        Room1 = findViewById(R.id.room1);
        Room2 = findViewById(R.id.room2);
        Room3 = findViewById(R.id.room3);

        Room1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomSelection.this, Room1.class);
                startActivity(intent);
                Toast.makeText(RoomSelection.this, "The Room1 Button Works", Toast.LENGTH_SHORT).show();
            }
        });

        Room2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomSelection.this, Room2.class);
                startActivity(intent);
                Toast.makeText(RoomSelection.this, "The Room2 Button Works", Toast.LENGTH_SHORT).show();
            }
        });

        Room3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomSelection.this, Room3.class);
                startActivity(intent);
                Toast.makeText(RoomSelection.this, "The Room3 Button Works", Toast.LENGTH_SHORT).show();
            }
        });



    }


}
