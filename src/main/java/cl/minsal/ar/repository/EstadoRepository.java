package cl.minsal.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.minsal.ar.entity.Cita;
import cl.minsal.ar.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
	
	
}
