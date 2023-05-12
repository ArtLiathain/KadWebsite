package com.example.kad;

import android.media.MediaPlayer;
import android.util.Log;
import android.widget.CheckBox;

public class AuthLogic {
    static MediaPlayer mediaPlayer;
    public boolean validLength(String name) {
        return (name.length() <= 70 && name.length() > 0) ? true : false;
    }

    public boolean stringAlphabet(String name) {
        if (!validLength(name)){return false;}
        return name.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]+)*$");
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
        return email.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]+)*$");
    }

    public boolean studentNumLen(int number) {
        int length = (int) (Math.log10(number) + 1);
        return length == 8;
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
    public void playAudio() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("res/raw/entry.mp3");
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
    public boolean colorAccessibility(int color1[], int color2[]){

        int L1 = (int) (0.2126 * color1[0] + 0.7152 * color1[1] + 0.0722 * color1[2]);
        int L2 = (int) (0.2126 * color2[0] + 0.7152 * color2[1] + 0.0722 * color2[2]);
        int ratio = (int) ((L1 + 0.05) / (L2 + 0.05));
        if (ratio > 4.5){
            return true;

        }
        else
        { return false;}

    }
}
