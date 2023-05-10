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

public class DateTimeTest {


  //Should return all the valid times for the day
  //unsure of what input is currently
  @Test
  public void test_returnStartTimes() {
    DateTimeLogic dateTimeLogic = new DateTimeLogic();
    String[] times = new String[]{"Not Selected", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM"};
    assertArrayEquals(
        dateTimeLogic.returnStartTimes(), times);
  }



}
