package cl.minsal.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.minsal.ar.entity.Cita;
import cl.minsal.ar.entity.CitaDetalle;

/**
 * Created by jvasquez.
 */
@Repository
public interface CitaDetalleRepository extends JpaRepository<CitaDetalle, Integer> {
	
	

	
}
