package cl.minsal.ar.model;

import java.sql.Date;
import java.time.OffsetDateTime;

public class Cita {
	
	private String idCitaAps;
	private String idCentro;
	private String estado;
	private String horacita;
	private String nombreCentro;
	private String rutUsuario;
	private String nombreUsuario;
	private String rutPaciente;
	private String nombrePaciente;
	private String tipoConsulta;
	private String nombreEspecialista;
	private String email;
	private String telefono;
	private String canal;
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
	public String getIdCentro() {
		return idCentro;
	}
	public void setIdCentro(String idCentro) {
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
