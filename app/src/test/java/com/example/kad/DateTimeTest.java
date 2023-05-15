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
