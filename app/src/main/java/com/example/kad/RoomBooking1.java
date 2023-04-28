package com.example.kad;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RoomBooking1 extends AppCompatActivity {

    public Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_booking1);

        btn1 = (Button) findViewById(R.id.button_test);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Room 2 Selected", Toast.LENGTH_SHORT).show();

                openSelection();

            }
        });

    }
        public void openSelection() {
            setContentView(R.layout.room_selection);
        }
    }