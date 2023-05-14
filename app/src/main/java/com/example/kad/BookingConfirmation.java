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

public class BookingConfirmation extends AppCompatActivity {
    Button buttonToRoomSelection;
    TextView textViewMessage;

    @SuppressLint("MissingInflatedId")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    @Generated
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_confirmation_page);

        buttonToRoomSelection = findViewById(R.id.returnToRoomSelectionButton);


//----------------------------Return to Room Selection Page----------------------------------------
        buttonToRoomSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            @Generated
            public void onClick(View view) {
                Intent intent = new Intent(BookingConfirmation.this, RoomSelection.class);
                startActivity(intent);
                Toast.makeText(BookingConfirmation.this, "The Return to Room Selection Button Works", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

