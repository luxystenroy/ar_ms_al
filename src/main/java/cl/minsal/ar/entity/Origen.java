package cl.minsal.ar.entity;

import cl.minsal.ar.exception.MinsalARException;

public enum Origen {
	
	HD,AR,WEB,MOV;
	
	public static void validate(String origen) throws MinsalARException {
		
		try{
			Origen.valueOf(origen.toUpperCase());
		
			
		}catch(java.lang.IllegalArgumentException e) {
			throw new MinsalARException("el campo origen es incorrecto", "003");
			
		}
	}

}
