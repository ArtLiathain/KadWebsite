package com.example.kad;

import android.util.Log;
import android.widget.CheckBox;



public class AuthLogic {
    private static final int MIN_LENGTH = 5;
    private static final boolean no = false;
    private  static final boolean yes = true;
    private static final int MAX_LENGTH = 70;
    public boolean validLength(String name) {

        return name.length() > MIN_LENGTH && name.length() < MAX_LENGTH;
    }

    public boolean stringAlphabet(String name) {
        if (!validLength(name)) {
            return no;
        }
        else if (name.matches("^[a-zA-ZÀ-ÿ \\-\\.\\']*$") == true){
            return true;
        };

        return false;

    }


    public boolean blacklist(String name) {
        int count = 0;
        String[] blackList = {"John Smith", "Jane Doe", "Michael Johnson", "Emily Brown", "William Davis", "Olivia Taylor", "James Wilson", "Sophia Lee", "Benjamin Garcia", "Isabella Martinez", "Daniel Anderson", "Mia Thomas", "David Hernandez", "Ella Perez", "Joseph Green", "Ava Collins", "Matthew Baker", "Chloe Hall", "Andrew Rivera", "Natalie Ramirez"};
        for (int i = 0; i <= blackList.length - 1; i++) {
            if (blackList[i].equals(name)) {
                count += 1;
            }
        }
        return count == 0;
    }

    public boolean emailFormat(String email) {
        if(email.length() > 40){return false;}
        return email.matches("^(.+)@(.+)$");
    }

    public boolean studentNumLen(int number) {
        int length = (int) (Math.log10(number) + 1);
        return length == 8;
    }

    public boolean studentNumYear(int number) {
        if (number >= 22000000 && number <= 22999999){
            return yes;
        }
        else return no;
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
    public boolean colorAccessibility(int[] color1, int[] color2){
        // Checking that the colors used in the application are suitble to those who may have a visual impariment
        int theL1 = (int) (0.2126 * color1[0] + 0.7152 * color1[1] + 0.0722 * color1[2]);
        int theL2 = (int) (0.2126 * color2[0] + 0.7152 * color2[1] + 0.0722 * color2[2]);
        int ratio = (int) ((theL1 + 0.05) / (theL2 + 0.05));
        return ratio > 4.5;
    }
}

