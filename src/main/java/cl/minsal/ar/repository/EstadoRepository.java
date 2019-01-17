package cl.minsal.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cl.minsal.ar.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
	
	@Query(value = "SELECT * FROM lk_estado where cita_id_cita = :idCita order by fech_creacion_estado desc limit 1;", nativeQuery = true)
	Estado getTheLastEstadoByIdCita(@Param("idCita") Integer icCita);
	
	
	
}
