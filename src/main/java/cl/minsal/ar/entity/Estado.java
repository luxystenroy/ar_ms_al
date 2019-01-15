package cl.minsal.ar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="lk_estado")
public class Estado {
	
	@Column(name = "id_estado", nullable = false, updatable = false)
	@SequenceGenerator(name = "cita_estado_generator", sequenceName = "lk_cita_idEstado_seq")
	@GeneratedValue(generator = "cita_estado_generator")
	private Integer idEstado;
	@Column(name = "estado_cita", nullable = false, updatable = false)
	private String estadoCita;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fech_creacion_estado", nullable = false, updatable = false)
	private Date fechaCreacionEstado;

}
