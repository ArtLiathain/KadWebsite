package com.example.kad.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kad.Generated;
import com.example.kad.R;


public class BookingConfirmationActivity extends AppCompatActivity {
    Button buttonToRoomSelection;
    TextView textViewMessage;

    @SuppressLint("MissingInflatedId")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    @Generated
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_confirmation_page);


//----------------------------Return to Room Selection Page----------------------------------------
        buttonToRoomSelection = findViewById(R.id.returnToRoomSelectionButton);
        buttonToRoomSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            @Generated
            public void onClick(View view) {
                Intent intent = new Intent(BookingConfirmationActivity.this, RoomSelectionActivity.class);
                startActivity(intent);
                Toast.makeText(BookingConfirmationActivity.this, "The Return to Room Selection Button Works", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

