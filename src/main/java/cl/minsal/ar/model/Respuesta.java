package cl.minsal.ar.model;

public class Respuesta {
	private Object explanation;
	private String message;
	private int status_code;
	
	public Respuesta() {
		super();
	}
	
	
	public Respuesta(Object explanation, String message, int status_code){
		this.explanation = explanation;
		this.message = message;
		this.status_code = status_code;
	}
	
	public Object getExplanation() {
		return explanation;
	}
	public void setExplanation(Object explanation) {
		this.explanation = explanation;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus_code() {
		return status_code;
	}
	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}
	
	
}
