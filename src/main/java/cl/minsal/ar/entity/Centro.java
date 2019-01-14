package cl.minsal.ar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="lk_centros")
public class Centro {

	@Id
    @Column(name = "id_centro", nullable = false, updatable = false)
	@SequenceGenerator(name = "centro_generator", sequenceName = "lk_centros_id_centro_seq")
	@GeneratedValue(generator = "centro_generator")
	Integer idCentro;

	@Column(name="nombre_centro")
	String nombreCentro;
	
	String host_centro;
	
	public Centro(Integer idCentro, String nombreCentro, String host_centro) {
		super();
		this.idCentro = idCentro;
		this.nombreCentro = nombreCentro;
		this.host_centro = host_centro;
	}

	public Centro() {};
	
	public Integer getidCentro() {
		return idCentro;
	}

	public void setidCentro(Integer idCentro) {
		this.idCentro = idCentro;
	}

	public String getnombreCentro() {
		return nombreCentro;
	}

	public void setnombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}

	public String getHost_centro() {
		return host_centro;
	}

	public void setHost_centro(String host_centro) {
		this.host_centro = host_centro;
	}

	
}
