package com.example.kad;

import android.util.Log;

import com.github.agogs.holidayapi.api.APIConsumer;
import com.github.agogs.holidayapi.api.impl.HolidayAPIConsumer;
import com.github.agogs.holidayapi.model.Holiday;
import com.github.agogs.holidayapi.model.HolidayAPIResponse;
import com.github.agogs.holidayapi.model.QueryParams;

import org.mockito.internal.matchers.Null;

import java.io.IOException;

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
//  Firebase firebase = new Firebase();
////
//  public String[] returnStartTimes() {
//    Log.d("TEST", "got here");
//    List<Date> StartDates;
//    firebase.getDates();
//    Log.d("NOPE", "got here");
//    StartDates = firebase.getStartdates();
//    if (StartDates == null) {
//      return availableTimes.toArray(String[]::new);
//    }
//    int year = StartDates.get(0).getYear();
//    int month = StartDates.get(0).getMonth();
//    ArrayList<String> availableTimesCopy = availableTimes;
//    for (int i = 1; i < availableTimesCopy.size(); i++) {
//      try {
//        Date dateToCheck =
//            new SimpleDateFormat("dd/MM/yyyy")
//                .parse(availableTimesCopy.get(i).substring(0, 1) + "/" + month + "/" + year);
//        for (int h = 0; h < StartDates.size(); h++) {
//          if (dateToCheck.equals(StartDates.get(h))) {
//            availableTimesCopy.remove(h);
//          }
//        }
//      } catch (ParseException e) {
//        throw new RuntimeException(e);
//      }
//    }
//
//    return availableTimesCopy.toArray(String[]::new);
//  }

  public boolean isHoliday(LocalDateTime stevensDay) {
    APIConsumer consumer = new HolidayAPIConsumer("https://holidayapi.com/v1/holidays");

    QueryParams params = new QueryParams();
    params.key("97231d0e-86f6-4f8f-adb5-6567be20b20c")
            .day(stevensDay.getDayOfMonth())
            .month(stevensDay.getMonthValue())
            .country(QueryParams.Country.IRELAND)
            .year(2022);

    try {
      //make the API call
      HolidayAPIResponse response = consumer.getHolidays(params);

      //check the status code of the API call
      int status = response.getStatus();

      if (status != 200) {
        return false;
        //handle error scenario

      } else {

        //handle success scenario

        List<Holiday> holidays = response.getHolidays();
        if (holidays.size() > 0){
          return true;
        }

      }
    } catch (IOException e) {
      //handle exception
      return false;
    }
    return false;
  }
}
