package cl.minsal.ar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="lk_estado")
public class Estado {
	
	@Id
	@Column(name = "id_estado", nullable = false, updatable = false)
	@SequenceGenerator(name = "cita_estado_generator", sequenceName = "lk_cita_idestado_seq")
	@GeneratedValue(generator = "cita_estado_generator")
	private Integer idEstado;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado_cita", nullable = false, updatable = false)
	private EstadoCitaAPS estadoCita;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fech_creacion_estado", nullable = false, updatable = false)
	private Date fechaCreacionEstado;
	
	@Enumerated(EnumType.STRING)
    @Column(length = 3,name = "origen", nullable = false, updatable = false)
	private Origen origen;
	
	
	@ManyToOne
	@JoinColumn(name = "cita_id_cita")
    private Cita cita;

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public EstadoCitaAPS getEstadoCita() {
		return estadoCita;
	}

	public void setEstadoCita(EstadoCitaAPS estadoCita) {
		this.estadoCita = estadoCita;
	}

	public Date getFechaCreacionEstado() {
		return fechaCreacionEstado;
	}

	public void setFechaCreacionEstado(Date fechaCreacionEstado) {
		this.fechaCreacionEstado = fechaCreacionEstado;
	}

	public Origen getOrigen() {
		return origen;
	}

	public void setOrigen(Origen origen) {
		this.origen = origen;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	
	
	

}
