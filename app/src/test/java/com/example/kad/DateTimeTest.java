package com.example.kad;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DateTimeTest {
  private String day;


  private boolean expectedValue;
  DateTimeLogic dateTimeLogic;

  public DateTimeTest(String day, boolean expectedValue) {
    this.day = day;
    this.expectedValue = expectedValue;
  }


  @Before
  public void setUp() throws Exception {
    dateTimeLogic = new DateTimeLogic();
    }

  @Parameterized.Parameters
  public static Collection dates() {
    return Arrays.asList(new Object[][] {
            {"2022-08-20 10:00", false},
            {"2022-12-26 10:00", true},
            {"2022-12-31 09:00", true}
    });
  }
  @Test
  public void test_isHolidayApiWorking(){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime formattedDay = LocalDateTime.parse(day, formatter);
    assertEquals(dateTimeLogic.isHoliday(formattedDay), expectedValue);
  }



}
