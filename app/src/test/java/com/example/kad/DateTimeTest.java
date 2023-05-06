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

  private String bookedDate;
  private int minsToBook;
  private String bookingDate;
  private int minutesBooked;

  private Integer inputNumber;
  private Boolean expectedResult;
  private DateTimeLogic dateTimeLogic;

  @Before
  public void initialize() {
    dateTimeLogic = new DateTimeLogic();
  }

  // Each parameter should be placed as an argument here
  // Every time runner triggers, it will pass the arguments
  // from parameters we defined in primeNumbers() method

  public DateTimeTest(String bookingDate,int minsToBook, String bookedDate, int minutesBooked, boolean expectedResult) {
    this.bookingDate = bookingDate;
    this.minsToBook = minsToBook;
    this.bookedDate = bookedDate;
    this.minutesBooked = minutesBooked;
    this.expectedResult = expectedResult;
  }

  @Parameterized.Parameters
  public static Collection dates() {
    return Arrays.asList(new Object[][] {
            {"2005-08-20 10:00", 60, "2005-08-20 09:30", 120, true},
            {"2005-08-20 10:00", 29, "2005-08-20 09:30", 29, false},

    });
  }
  @Test
  public void test_isOverLapping() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime formattedBookingDate = LocalDateTime.parse(bookingDate, formatter);
    LocalDateTime formattedBookedDate = LocalDateTime.parse(bookedDate, formatter);
    assertEquals(
        dateTimeLogic.isOverLapping(formattedBookingDate, minsToBook, formattedBookedDate, minutesBooked), expectedResult);
  }



}
