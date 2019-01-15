package cl.minsal.ar.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import cl.minsal.ar.exception.MinsalARException;

public class MinsalARUtilTest {

	@Test
	public void testDateFromAPSToDate() throws MinsalARException {
		String dateAPS = "2017-02-19T22:36:06-08:00";
		Date fechaCita = MinsalARUtil.fromApsDateFormatToDate(dateAPS);
	}

}
