package com.shrey.weatherforecast.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Shrey
 *
 */
public class Utility {

	/**
	 * 
	 * @param timestamp
	 * @return
	 */
	public static String getStringDateFromTimeStamp(long timestamp) {
		Date date = new Date(timestamp * 1000L);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		return sdf.format(date);
	}

}
