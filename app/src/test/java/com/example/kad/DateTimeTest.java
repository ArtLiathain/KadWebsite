package com.example.kad;

import static org.junit.Assert.*;

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
    DateTimeLogic dateTimeLogic;


    public HolidayApi(String day, boolean expectedValue) {
      this.day = day;
      this.expectedValue = expectedValue;
    }

    @Before
    public void setUp() throws Exception {
      dateTimeLogic = new DateTimeLogic();
    }

    @Parameterized.Parameters
    public static Collection dates() {
      return Arrays.asList(
          new Object[][] {
            {"2022-08-20 10:00", false},
            {"2022-12-26 10:00", true},
            {"2022-12-31 09:00", true}
          });
    }

    @Test
    public void test_isHolidayApiWorking() {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
      LocalDateTime formattedDay = LocalDateTime.parse(day, formatter);
      assertEquals(dateTimeLogic.isHoliday(formattedDay), expectedValue);
    }
  }


  @RunWith(Parameterized.class)
  public static class StartTimeTests {
    DateTimeLogic dateTimeLogic;
    private String[] StartTimes;
    private LocalDateTime dayOfBooking;
    private String[] expectedOutput;
    private boolean isDayOff;
    public StartTimeTests(String[] startTimes,boolean isDayOff, String[] expectedOutput) {
      this.StartTimes = startTimes;
      this.isDayOff = isDayOff;
      this.dayOfBooking = LocalDateTime.now();
      this.expectedOutput = expectedOutput;
    }

    @Before
    public void setUp() throws Exception {
      dateTimeLogic = new DateTimeLogic();
      DateTimeLogic a = new DateTimeLogic();
      DateTimeLogic aSpy = Mockito.spy(a);
      Mockito.when(aSpy.isHoliday(dayOfBooking)).thenReturn(isDayOff);
    }
    @Parameterized.Parameters
    public static Collection availableTimes() {
      return Arrays.asList(new Object[][] {
              {new String[]{"10:00", "03:00", "01:00"}, false, new String[]{"Not Selected",
                      "09:00 AM", "11:00 AM", "12:00 PM",
                      "02:00 PM", "04:00 PM"}},
              {new String[]{"11:00"}, false, new String[]{"Not Selected",
                      "09:00 AM", "10:00 AM", "12:00 PM", "01:00 PM",
                      "02:00 PM", "03:00 PM", "04:00 PM"}},
              {new String[]{"02:00", "03:00", "04:00"}, false, new String[]{"Not Selected",
                      "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM"}}
      });
      }
    @Test
    public void test_returnStartDates(){
      ArrayList<LocalDateTime> StartTimesDates = new ArrayList<>();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd HH:mm");
      for (String time : StartTimes){
        LocalDateTime times = LocalDateTime.parse(dayOfBooking.getYear() + "-" +
                dayOfBooking.getMonthValue()+ "-" + dayOfBooking.getDayOfMonth()+ " " +
                time, formatter);
        StartTimesDates.add(times);
      }

      assertArrayEquals(expectedOutput, dateTimeLogic.returnStartTimes(StartTimesDates,dayOfBooking));
  }
}
}
