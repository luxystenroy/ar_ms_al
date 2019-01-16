package cl.minsal.ar.util;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

import cl.minsal.ar.exception.MinsalARException;

public class MinsalARUtilTest {

	@Test
	public void testDateFromAPSToDate() throws MinsalARException, ParseException {
		String dateAPS = "2017-02-19T22:36:06-08:00";
		Date fechaCita = MinsalARUtil.fromApsDateFormatToDate(dateAPS);
		
		SimpleDateFormat dateFormatOfStringInDB = new SimpleDateFormat(MinsalARUtil.DATE_FORMAT_APS, Locale.getDefault());
		
		
		assertEquals(fechaCita, dateFormatOfStringInDB.parse(dateAPS));
	}

}
