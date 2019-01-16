package cl.minsal.ar.exception;

public class MinsalARException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String code;
	
	
	public MinsalARException(String message, String code) {
		super(message);
		this.code = code;
	}


	public String getCode() {
		return code;
	}



}
