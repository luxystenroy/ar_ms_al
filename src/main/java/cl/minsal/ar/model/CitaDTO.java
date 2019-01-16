package cl.minsal.ar.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class CitaDTO {
	
	@NotBlank(message = "idCitaAps no puede estar vacío o nulo")
	@NotEmpty(message = "idCitaAps no puede estar vacío o nulo")
	private String idCitaAps;
	
	private int idCentro;
	@NotBlank(message = "estado no puede estar vacío o nulo")
	@NotEmpty(message = "estado no puede estar vacío o nulo")
	private String estado;
	@NotBlank(message = "horacita no puede estar vacío o nulo")
	@NotEmpty(message = "horacita no puede estar vacío o nulo")
	private String horacita;
	@NotBlank(message = "nombreCentro no puede estar vacío o nulo")
	@NotEmpty(message = "nombreCentro no puede estar vacío o nulo")
	private String nombreCentro;
	@NotBlank(message = "rutUsuario no puede estar vacío o nulo")
	@NotEmpty(message = "rutUsuario no puede estar vacío o nulo")
	private String rutUsuario;
	@NotBlank(message = "nombreUsuario no puede estar vacío o nulo")
	@NotEmpty(message = "nombreUsuario no puede estar vacío o nulo")
	private String nombreUsuario;
	@NotBlank(message = "rutPaciente no puede estar vacío o nulo")
	@NotEmpty(message = "rutPaciente no puede estar vacío o nulo")
	private String rutPaciente;
	
	@NotBlank(message = "nombrePaciente no puede estar nulo")
	private String nombrePaciente;
	
	@NotBlank(message = "tipoConsulta no puede estar vacío o nulo")
	@NotEmpty(message = "tipoConsulta no puede estar vacío o nulo")
	private String tipoConsulta;
	@NotBlank(message = "nombreEspecialista no puede estar vacío o nulo")
	@NotEmpty(message = "nombreEspecialista no puede estar vacío o nulo")
	private String nombreEspecialista;
	@NotBlank(message = "email no puede estar vacío o nulo")
	@NotEmpty(message = "email no puede estar vacío o nulo")
	private String email;
	@NotBlank(message = "telefono no puede estar vacío o nulo")
	@NotEmpty(message = "telefono no puede estar vacío o nulo")
	private String telefono;
	@NotBlank(message = "canal no puede estar vacío o nulo")
	@NotEmpty(message = "canal no puede estar vacío o nulo")
	private String canal;
	@NotBlank(message = "origen no puede estar vacío o nulo")
	@NotEmpty(message = "origen no puede estar vacío o nulo")
	private String origen;
	
	public String getHoracita() {
		return horacita;
	}
	public void setHoracita(String horacita) {
		this.horacita = horacita;
	}
	public String getIdCitaAps() {
		return idCitaAps;
	}
	public void setIdCitaAps(String idCitaAps) {
		this.idCitaAps = idCitaAps;
	}
	public int getIdCentro() {
		return idCentro;
	}
	public void setIdCentro(int idCentro) {
		this.idCentro = idCentro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNombreCentro() {
		return nombreCentro;
	}
	public void setNombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}
	public String getRutUsuario() {
		return rutUsuario;
	}
	public void setRutUsuario(String rutUsuario) {
		this.rutUsuario = rutUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getRutPaciente() {
		return rutPaciente;
	}
	public void setRutPaciente(String rutPaciente) {
		this.rutPaciente = rutPaciente;
	}
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	public String getNombreEspecialista() {
		return nombreEspecialista;
	}
	public void setNombreEspecialista(String nombreEspecialista) {
		this.nombreEspecialista = nombreEspecialista;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	
	
	
	

}
