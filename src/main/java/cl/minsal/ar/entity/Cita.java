package cl.minsal.ar.entity;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="lk_cita")
public class Cita {
	
	@Id
    @Column(name = "id_cita", nullable = false, updatable = false)
	@SequenceGenerator(name = "cita_generator", sequenceName = "lk_cita_idcita_seq")
	@GeneratedValue(generator = "cita_generator")
	private Integer idCita;

    @Column(name = "id_folio")
	private Integer idFolio;
	
	@Column(name = "origen_cita", nullable = false, updatable = false)
	private String origen;	
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fech_create_cita", nullable = false, updatable = false)
	private Date createCita;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_cita", nullable = false, updatable = false)
	private Date horaCita;
	
	@Column(name = "id_cita_aps", nullable = false, updatable = false)
	private String idCitaAps;
	
	@OneToOne(mappedBy = "cita")
	private CitaDetalle citaDetalle;
	
	
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<Estado> comments = new ArrayList<Estado>();
	 
	

	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public Integer getIdFolio() {
		return idFolio;
	}

	public void setIdFolio(Integer idFolio) {
		this.idFolio = idFolio;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public Date getCreateCita() {
		return createCita;
	}

	public void setCreateCita(Date createCita) {
		this.createCita = createCita;
	}

	public Date getHoraCita() {
		return horaCita;
	}

	public void setHoraCita(Date horaCita) {
		this.horaCita = horaCita;
	}

	public String getIdCitaAps() {
		return idCitaAps;
	}

	public void setIdCitaAps(String idCitaAps) {
		this.idCitaAps = idCitaAps;
	}
	


	

}
