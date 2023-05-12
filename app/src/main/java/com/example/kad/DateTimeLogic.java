package com.example.kad;

import com.github.agogs.holidayapi.api.APIConsumer;
import com.github.agogs.holidayapi.api.impl.HolidayAPIConsumer;
import com.github.agogs.holidayapi.model.Holiday;
import com.github.agogs.holidayapi.model.HolidayAPIResponse;
import com.github.agogs.holidayapi.model.QueryParams;

import java.io.IOException;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
          return (!holidays.isEmpty());
      }
    } catch (IOException e) {
      //handle exception
      return false;
    }
  }
}
