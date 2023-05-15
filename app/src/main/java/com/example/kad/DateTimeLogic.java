package com.example.kad;
import java.util.logging.Level;
import java.util.logging.Logger;
import android.os.Debug;
import android.util.Log;

import com.github.agogs.holidayapi.api.APIConsumer;
import com.github.agogs.holidayapi.api.impl.HolidayAPIConsumer;
import com.github.agogs.holidayapi.model.Holiday;
import com.github.agogs.holidayapi.model.HolidayAPIResponse;
import com.github.agogs.holidayapi.model.QueryParams;


import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;



public class DateTimeLogic {
  private static final Logger LOGGER = Logger.getLogger(DateTimeLogic.class.getName());
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

  public String[] returnStartTimes(ArrayList<LocalDateTime> StartTimes, LocalDateTime dayOfBooking) {
    if(isHoliday(dayOfBooking)){
      return new String[]{"No Times Available"};
    }
    if (StartTimes.size() == 0) {

      return availableTimes.toArray(String[]::new);
    }
    int count = 0;
    int day = dayOfBooking.getDayOfMonth();
    int year = dayOfBooking.getYear();
    int month = dayOfBooking.getMonthValue();
    ArrayList<String> availableTimesCopy = new ArrayList<>(availableTimes);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd HH:mm");
    for (int i = 1; i < availableTimesCopy.size(); i++) {
      try {
      LocalDateTime time = LocalDateTime.parse(dayOfBooking.getYear() + "-" +
              dayOfBooking.getMonthValue()+ "-" + dayOfBooking.getDayOfMonth()+ " " +
              availableTimesCopy.get(i).substring(0,5), formatter);


        for (int h = 0; h < StartTimes.size(); h++) {
          if (time.equals(StartTimes.get(h))) {
              availableTimes.remove(i-count);
              count++;
              break;
              }
          }
        } catch (Exception e) {
        return new String[]{"Error"};
      }
    }



    return availableTimes.toArray(String[]::new);
  }
  public boolean isHoliday(LocalDateTime stevensDay) {
    APIConsumer consumer = new HolidayAPIConsumer("https://holidayapi.com/v1/holidays");

    QueryParams params = new QueryParams();
    params.key(BuildConfig.HOLIDAY_API_KEY)
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
        LOGGER.log(Level.SEVERE, "Status was: ", status);
        return false;
        //handle error scenario

      } else {

        //handle success scenario

        List<Holiday> holidays = response.getHolidays();
          return (!holidays.isEmpty());
      }
    } catch (IOException e) {
      //handle exception
      LOGGER.log(Level.SEVERE, "An error occurred while making the API request.", e.toString());
      return false;
    }
  }
}
