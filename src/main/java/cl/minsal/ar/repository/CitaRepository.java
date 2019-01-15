package cl.minsal.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.minsal.ar.entity.Cita;

/**
 * Created by jvasquez.
 */
@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
	
	@Query(value = "SELECT nextval('lk_cita_idfolio_seq')", nativeQuery =
            true)
    Integer getNextSeriesIdFolio();

	
}
