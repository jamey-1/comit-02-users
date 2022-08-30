package org.comit.course.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static Date parseDate(String str) {
		Date date = null;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = formatter.parse(str.trim());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}

}
