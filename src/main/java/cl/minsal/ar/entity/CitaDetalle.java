package cl.minsal.ar.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="lk_cita_detalle")
public class CitaDetalle {
	
	@Id
    @Column(name = "id_detalle", nullable = false, updatable = false)
	@SequenceGenerator(name = "cita_detalle_generator", sequenceName = "lk_cita_iddetalle_seq")
	@GeneratedValue(generator = "cita_detalle_generator")
	private Integer idDetalle;
	
	@Column(name = "rut_paciente", nullable = false, updatable = false)
	private String rutPaciente;
	
	@Column(name = "nombre_paciente")
	private String nombrePaciente;
	
	@Column(name = "rut_usuario", nullable = false, updatable = false)
	private String rutUsuario;
	
	@Column(name = "nombre_usuario", nullable = false, updatable = false)
	private String nombreUsuario;
	
	@Column(name = "fech_modif_cita", nullable = false, updatable = false)
	private Date fechaModificacionCita;
	
	@Column(name = "tipo_consulta", nullable = false, updatable = false)
	private String tipoConsulta;
	
	@Column(name = "email_usuario", nullable = false, updatable = false)
	private String emailUsuario;
	
	@Column(name = "telefono_usuario", nullable = false, updatable = false)
	private String telefonoUsuario;
	
	@Column(name = "nombre_especialista", nullable = false, updatable = false)
	private String nombreEspecialista;
	
	@Column(name = "canal", nullable = false, updatable = false)
	private String canal;
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "centro_id_centro")
	private Centro centro;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cita_id_cita")
	private Cita cita;
	
	
	

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
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

	public Date getFechaModificacionCita() {
		return fechaModificacionCita;
	}

	public void setFechaModificacionCita(Date fechaModificacionCita) {
		this.fechaModificacionCita = fechaModificacionCita;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public String getNombreEspecialista() {
		return nombreEspecialista;
	}

	public void setNombreEspecialista(String nombreEspecialista) {
		this.nombreEspecialista = nombreEspecialista;
	}


	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	
	
	
	

}
