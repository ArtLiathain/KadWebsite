package com.example.kad;
import java.time.LocalDateTime;

public class DateTimeLogic {

	public boolean isOverLapping(LocalDateTime date1,int timeBooked, LocalDateTime date2, int hoursBooked){
		if (date1.isBefore(date2) && date1.plusHours(timeBooked).isBefore(date2)){
			if(date1.isAfter(date2) && date1.isAfter(date2.plusHours(hoursBooked))){
				return false;
			}
		}
		return true;
	}
}
