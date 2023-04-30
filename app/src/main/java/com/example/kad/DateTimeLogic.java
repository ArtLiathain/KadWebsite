package com.example.kad;
import java.time.LocalDateTime;

public class DateTimeLogic {

	public boolean isOverLapping(LocalDateTime date1,int minsToBook, LocalDateTime date2, int minutesBooked){
		if ((date1.isBefore(date2) && date1.plusMinutes(minsToBook).isBefore(date2)) || (date1.isAfter(date2) && date1.isAfter(date2.plusMinutes(minutesBooked)))){
			return false;
		}


		return true;
	}
}
