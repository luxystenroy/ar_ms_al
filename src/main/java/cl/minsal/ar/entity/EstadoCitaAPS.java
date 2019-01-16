package cl.minsal.ar.entity;

import cl.minsal.ar.exception.MinsalARException;

public enum EstadoCitaAPS {
	
	
	
	PROPOSED("PROPOSED"),
	PENDING("PENDING"),
	BOOKED("BOOKED"),
	CONFIRMED("PROPOSED"),
	ARRIVED("CONFIRMED"),
	FULFILLED("FULFILLED"),
	CANCELLED("CANCELLED"),
	NOSHOW("NOSHOW"),
	ENTERED_IN_ERROR("ENTERED-IN-ERROR");
	
	
	private EstadoCitaAPS(String realName) {
		this.realName = realName;
		
	}
	
	public static EstadoCitaAPS getEnumByName(String realname) throws MinsalARException {
		for(EstadoCitaAPS e: EstadoCitaAPS.values()) {
		    if(e.realName.equalsIgnoreCase(realname)) {
		      return e;
		    }
		  }
		throw new MinsalARException("Estado de la cita es incorrecto", "003");
	}
	
	

	private final String realName;



	public String getRealName() {
		return realName;
	}

}
