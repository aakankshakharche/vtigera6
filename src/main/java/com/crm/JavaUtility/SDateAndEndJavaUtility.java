package com.crm.JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SDateAndEndJavaUtility {

	public static String startDate(String format) {
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat(format);
		String currentdate = sim.format(d);
		return currentdate;
	}
	
	public static String endDate(String format) {
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat(format);
		Calendar calen=sim.getCalendar();
		calen.add(Calendar.DAY_OF_MONTH, 90);
		String enddate = sim.format(calen.getTime());
		return enddate;
	}
	
}
