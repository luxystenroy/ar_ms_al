package cl.minsal.ar.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.minsal.ar.model.Cita;
import cl.minsal.ar.model.Respuesta;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author luisgonzalez
 *
 */
@RestController
@RequestMapping(value = "/citas") 
public class CitasController {
	
	private static Logger LOG = LogManager.getLogger(CentrosController.class);
	
	@ApiOperation(value = "Citas", notes = "Obtener todos los centros")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Void> addCita(@RequestBody Cita cita) {
		

		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
		
	}
	
	
	
	
	
}