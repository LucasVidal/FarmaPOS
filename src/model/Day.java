package model;

import java.util.Calendar;
import java.util.Date;

public class Day {

	private Date date;
	
	public Day()
	{
		super();
		this.date=new Date();
	}
	
	public Day(Date date)
	{
		super();
		this.date=date;
	}

	public boolean equalsDate(Date date2) {
		return 		this.date.getYear()==date2.getYear() 
				&& 	this.date.getMonth()==date2.getMonth() 
				&& 	this.date.getDate()==date2.getDate();
	}
	
	
}
