package cl.minsal.ar.entity;




import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private String idFolio;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fech_create_cita", nullable = false, updatable = false)
	private Date createCita;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_cita", nullable = false, updatable = false)
	private Date horaCita;
	
	@Column(name = "id_cita_aps", nullable = false, updatable = false)
	private String idCitaAps;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cita")
	private CitaDetalle citaDetalle;
	
	@Enumerated(EnumType.STRING)
    @Column(length = 3,name = "tipo_cita", nullable = false, updatable = false)
	private TipoCita tipoCita;
	
	
	@OneToMany(mappedBy="cita")
	private Set<Estado> estados;
	 
	

	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public String getIdFolio() {
		return idFolio;
	}

	public void setIdFolio(String idFolio) {
		this.idFolio = idFolio;
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

	public CitaDetalle getCitaDetalle() {
		return citaDetalle;
	}

	public void setCitaDetalle(CitaDetalle citaDetalle) {
		this.citaDetalle = citaDetalle;
	}

	public Set<Estado> getEstados() {
		return estados;
	}

	public void setEstados(Set<Estado> estados) {
		this.estados = estados;
	}

	public TipoCita getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(TipoCita tipoCita) {
		this.tipoCita = tipoCita;
	}
	
	
	
	


	

}
