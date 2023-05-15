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

  @RunWith(Parameterized.class)
  public static class StartTimeTests {
    DateTimeLogic dateTimeLogic;
    private String[] StartTimes;
    private LocalDateTime dayOfBooking;
    private String[] expectedOutput;
    private boolean isDayOff;
    DateTimeLogic a;
    public StartTimeTests(String[] startTimes,boolean isDayOff, String[] expectedOutput) {
      this.StartTimes = startTimes;
      this.isDayOff = isDayOff;
      this.dayOfBooking = LocalDateTime.now();
      this.expectedOutput = expectedOutput;
    }

    @Before
    public void setUp() throws Exception {
      dateTimeLogic = new DateTimeLogic();

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
              {new String[]{"02:00", "03:00", "04:00"}, true, new String[]{"No Times Available"}},
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
      DateTimeLogic aSpy = Mockito.spy(dateTimeLogic);
      Mockito.when(aSpy.isHoliday(dayOfBooking)).thenReturn(isDayOff);
      assertArrayEquals(expectedOutput, aSpy.returnStartTimes(StartTimesDates,dayOfBooking));
  }
}
}
