package com.java1234.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemUtil {
	
	public static String getTime(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
}
