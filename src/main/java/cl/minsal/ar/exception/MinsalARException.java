package cl.minsal.ar.exception;

public class MinsalARException extends Exception{
	
	
	private String code;
	
	
	public MinsalARException(String message,String code) {
		super(message);
		this.code = code;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

}
