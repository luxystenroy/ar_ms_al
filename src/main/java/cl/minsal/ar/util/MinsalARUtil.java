package cl.minsal.ar.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import cl.minsal.ar.exception.MinsalARException;

public class MinsalARUtil {
	
	public  static final String DATE_FORMAT_APS = "yyyy-MM-dd'T'HH:mm:ssXXX";
	
	public  static final String DATE_FORMAT_FRONT = "yyyy-MM-dd HH:mm:ss";
	
	
	
	private MinsalARUtil() {}
	
	public static Date fromApsDateFormatToDate(String date) throws MinsalARException {
		SimpleDateFormat dateFormatOfStringInDB = new SimpleDateFormat(DATE_FORMAT_APS, Locale.getDefault());
		
		try {
			return dateFormatOfStringInDB.parse(date);
		} catch (ParseException e) {
			throw new MinsalARException("formato de horacita incorrecto","003");
		}
	}
	
	
	public static String fromDateToFormatFrontString(Date date) {
		DateFormat df = new SimpleDateFormat(DATE_FORMAT_FRONT);
		
		return df.format(date);
	}

}
