package com.example.kad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateTimeLogic {

  ArrayList<String> availableTimes =
      new ArrayList<>(
          List.of(
              "Not Selected",
              "09:00 AM",
              "10:00 AM",
              "11:00 AM",
              "12:00 PM",
              "01:00 PM",
              "02:00 PM",
              "03:00 PM",
              "04:00 PM"));
  Firebase firebase = new Firebase();

  public String[] returnStartTimes() {
    List<Date> StartDates;
    firebase.getDates();
    StartDates = firebase.getStartdates();
    if (StartDates.size() == 0) {
      return availableTimes.toArray(String[]::new);
    }
    int year = StartDates.get(0).getYear();
    int month = StartDates.get(0).getMonth();
    ArrayList<String> availableTimesCopy = availableTimes;
    for (int i = 1; i < availableTimesCopy.size(); i++) {
      try {
        Date dateToCheck =
            new SimpleDateFormat("dd/MM/yyyy")
                .parse(availableTimesCopy.get(i).substring(0, 1) + "/" + month + "/" + year);
        for (int h = 0; h < StartDates.size(); h++) {
          if (dateToCheck.equals(StartDates.get(h))) {
            availableTimesCopy.remove(h);
          }
        }
      } catch (ParseException e) {
        throw new RuntimeException(e);
      }
    }

    return availableTimesCopy.toArray(String[]::new);
  }

  public boolean isHoliday(LocalDateTime date) {
    return false;
  }
}
