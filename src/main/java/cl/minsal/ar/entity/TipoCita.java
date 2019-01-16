package cl.minsal.ar.entity;

import cl.minsal.ar.exception.MinsalARException;

public enum TipoCita {
	
	AR,HD;
	
	public static void validate(String tipoCita) throws MinsalARException {
		
		try{
			Origen.valueOf(tipoCita.toUpperCase());
		
			
		}catch(java.lang.IllegalArgumentException e) {
			throw new MinsalARException("el tipoCita es incorrecto", "003");
			
		}
	}


}
