package cl.minsal.ar.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Respuesta {
	
	
	private Estado estado;
	
	private Object resultado;
	
	private Estado observaciones;
	
	@JsonProperty("error")
	private String errorMessage;

	

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Object getResultado() {
		return resultado;
	}

	public void setResultado(Object resultado) {
		this.resultado = resultado;
	}

	public Estado getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(Estado observaciones) {
		this.observaciones = observaciones;
	}
	
	
	
	
	
}
