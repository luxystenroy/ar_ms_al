package cl.minsal.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.minsal.ar.entity.Centro;



/**
 * Created by jvasquez.
 */
@Repository
public interface CentroRepository extends JpaRepository<Centro, Integer> {

	Centro findByidCentro(Integer id);
	Centro findBynombreCentro(String nombre);
}
