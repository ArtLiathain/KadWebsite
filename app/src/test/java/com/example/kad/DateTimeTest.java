package com.example.kad;

import static org.junit.Assert.*;
import static org.mockito.Mockito.reset;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Enclosed.class)
public class DateTimeTest {

  @RunWith(Parameterized.class)
  public static class HolidayApi {
    private String day;

    private boolean expectedValue;
    DateTimeLogic dateTimeLogic2;


    public HolidayApi(String day, boolean expectedValue) {
      this.day = day;
      this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection dates() {
      return Arrays.asList(
              new Object[][] {
                      {"2022-12-26 10:00", true},
                      {"2022-08-20 10:00", false},
                      {"2022-12-10 09:00", false},
                      {"2022-12-31 08:00", true}
              });
    }

    @Test
    public void test_isHolidayApiWorking() {
      dateTimeLogic2 = new DateTimeLogic();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd HH:mm");
      LocalDateTime formattedDay = LocalDateTime.parse(day, formatter);
      assertEquals(dateTimeLogic2.isHoliday(formattedDay), expectedValue);
    }
  }


}
