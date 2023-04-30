package com.example.kad;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDateTime;


import static org.junit.Assert.*;


import java.time.format.DateTimeFormatter;

public class DateTimeTest {

	@Test
	public void test_isOverLapping(){
		DateTimeLogic dateTimeLogic = new DateTimeLogic();
		String bookingDate = "2005-08-20 10:00";
		String bookedDate = "2005-08-20 09:30";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime formattedBookingDate = LocalDateTime.parse(bookingDate, formatter);
		LocalDateTime formattedBookedDate = LocalDateTime.parse(bookedDate, formatter);
		assertEquals(dateTimeLogic.isOverLapping(formattedBookingDate,1, formattedBookedDate, 2), true);
	}

}
