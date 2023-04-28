package com.example.kad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class RoomSelection extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_selection);


        // Check Box Code
        /*
        CheckBox checkBox = findViewById(R.id.room1);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true)
                    Toast.makeText(getApplicationContext(), "Room 1 Selected", Toast.LENGTH_SHORT).show();
                else if (isChecked == false)
                    Toast.makeText(getApplicationContext(), "Room 1 Unselected", Toast.LENGTH_SHORT).show();
            }
        });*/


        button = (Button) findViewById(R.id.buttonRoom1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoom1();
                System.out.println("button clicked");
                Toast.makeText(getApplicationContext(), "Room 1 Selected", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void openRoom1(){
        setContentView(R.layout.room_booking1);
    }

}