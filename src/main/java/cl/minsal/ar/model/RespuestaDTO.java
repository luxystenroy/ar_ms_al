package cl.minsal.ar.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RespuestaDTO {
	
	@JsonProperty("estado")
	private EstadoDTO estado;
	
	private Object resultado;
	
	private List<EstadoDTO> observaciones;
	


	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}

	public Object getResultado() {
		return resultado;
	}

	public void setResultado(Object resultado) {
		this.resultado = resultado;
	}

	public void addEstadoDTO(EstadoDTO estado) {
		if(observaciones == null) {
			observaciones = new ArrayList<EstadoDTO>();
		}
		observaciones.add(estado);
	}

	public List<EstadoDTO> getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(List<EstadoDTO> observaciones) {
		this.observaciones = observaciones;
	}
	
	
	
	
	
}
