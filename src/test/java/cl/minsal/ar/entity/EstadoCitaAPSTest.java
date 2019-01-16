package cl.minsal.ar.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cl.minsal.ar.exception.MinsalARException;

public class EstadoCitaAPSTest {

	@Test
	public void testEnumGetByName() throws MinsalARException {
		
		EstadoCitaAPS enumEntered = EstadoCitaAPS.getEnumByName("cancelled");
		assertEquals(EstadoCitaAPS.CANCELLED,enumEntered);
		
		
		
		
	}

}
