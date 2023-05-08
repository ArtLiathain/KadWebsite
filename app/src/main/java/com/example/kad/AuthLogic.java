package com.example.kad;

import android.util.Log;
import android.widget.CheckBox;

public class AuthLogic {
    public boolean nameLength(String email) {
        if (email.length() <= 70 & email.length() > 0) {
            return true;
        }
        return false;

    }

    public boolean stringAlphabet(String name) {
        return name.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
    }


    public boolean blacklist(String name) {
        int count = 0;
        String[] blackList = {"John Smith", "Jane Doe", "Michael Johnson", "Emily Brown", "William Davis", "Olivia Taylor", "James Wilson", "Sophia Lee", "Benjamin Garcia", "Isabella Martinez", "Daniel Anderson", "Mia Thomas", "David Hernandez", "Ella Perez", "Joseph Green", "Ava Collins", "Matthew Baker", "Chloe Hall", "Andrew Rivera", "Natalie Ramirez"};
        for (int i = 0; i <= blackList.length - 1; i++) {
            if (blackList[i] == name) {
                count += 1;
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean emailFormat(String email) {
        return email.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
    }

    public boolean studentNumLen(int number) {
        int length = (int) (Math.log10(number) + 1);
        if (length != 8) {
            return false;
        }
        return true;
    }

    public boolean studentNumYear(int number) {
        if (number >= 22000000) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkBox(CheckBox checkBox) {
        if (checkBox.isChecked()) {
            // Do something if the CheckBox is checked
            Log.d("MyApp", "The CheckBox is checked");
            return true;

        } else {
            // Do something if the CheckBox is not checked
            Log.d("MyApp", "The CheckBox is not checked");
            return false;


        }
    }
}
