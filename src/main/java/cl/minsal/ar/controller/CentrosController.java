package cl.minsal.ar.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.minsal.ar.entity.Centro;
import cl.minsal.ar.model.Respuesta;
import cl.minsal.ar.repository.CentroRepository;
import io.swagger.annotations.ApiOperation;

/**
 * Created by jvasquez
 */
@RestController
@RequestMapping(value = "/centros") //Aca ponemos /centros
public class CentrosController {

	private static Logger LOG = LogManager.getLogger(CentrosController.class);

	@Autowired
	CentroRepository centroRepository;
	
	@ApiOperation(value = "/centros", notes = "Obtener todos los centros")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Respuesta> findAllCentros() {
		Respuesta responseMessage = new Respuesta();
		responseMessage.setExplanation(centroRepository.findAll());
		responseMessage.setMessage("");
		responseMessage.setStatus_code(200);
		try {
			LOG.info("Inicio servicio prueba");
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info("Ocurrio un error al llamar al servicio prueba "
					.concat(" : ".concat(e.getMessage().concat(e.getLocalizedMessage()))));
			String mensajeError = "Error: " + e.getMessage() + e.getLocalizedMessage();
			responseMessage.setMessage(mensajeError);
			responseMessage.setStatus_code(1);
		}
		LOG.info("Fin servicio prueba");
		return new ResponseEntity<Respuesta>(responseMessage, HttpStatus.OK);
	}

	@ApiOperation(value = "Centros", notes = "Obtener todos los centros")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Respuesta> findCentroById(@PathVariable("id") Integer id) {
		Respuesta responseMessage = new Respuesta();
		try {
			LOG.info("Inicio servicio prueba");
			responseMessage.setExplanation(centroRepository.findByidCentro(id));
			responseMessage.setMessage("");
			responseMessage.setStatus_code(200);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info("Ocurrio un error al llamar al servicio prueba "
					.concat(" : ".concat(e.getMessage().concat(e.getLocalizedMessage()))));
			String mensajeError = "Error: " + e.getMessage() + e.getLocalizedMessage();
			responseMessage.setMessage(mensajeError);
			responseMessage.setStatus_code(1);
		}
		LOG.info("Fin servicio prueba");
		return new ResponseEntity<Respuesta>(responseMessage, HttpStatus.OK);
	}

//	@ApiOperation(value = "Centros", notes = "Actualizar un centro")
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Respuesta> updateCentro(@RequestBody Centro centro) {
		Respuesta responseMessage = new Respuesta();
		try {
			Centro centro2 = centroRepository.findByidCentro(centro.getidCentro());
			Centro centro3 = centroRepository.findBynombreCentro(centro.getnombreCentro());
			if (centro2 != null) {
				if (centro3 == null) {
					centroRepository.save(centro);
					responseMessage.setExplanation(centro);
					responseMessage.setMessage("");
					responseMessage.setStatus_code(200);
				} else {
					responseMessage.setExplanation("");
					responseMessage.setMessage("Ya existe un centro con ese nombre");
					responseMessage.setStatus_code(500);
				}
			} else {
				responseMessage.setExplanation("");
				responseMessage.setMessage("No se ha encontrado el centro");
				responseMessage.setStatus_code(500);
			}
		} catch (Exception e) {
			responseMessage.setExplanation("");
			responseMessage.setMessage("No se ha encontrado el centro");
			responseMessage.setStatus_code(500);
		}
		return new ResponseEntity<Respuesta>(responseMessage, HttpStatus.valueOf(responseMessage.getStatus_code()));
	}

	@ApiOperation(value = "Centros", notes = "Crear un centro")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Respuesta> createCentro(@RequestBody Centro centro) {
		Respuesta responseMessage = new Respuesta();
		try {
			if (centro.getidCentro() == 0) {
				Centro centro2 = centroRepository.findBynombreCentro(centro.getnombreCentro());
				if (centro2 == null) {
					centro.setidCentro(null);
					centroRepository.save(centro);
					responseMessage.setExplanation(centro);
					responseMessage.setMessage("");
					responseMessage.setStatus_code(200);
				} else {
					responseMessage.setExplanation("");
					responseMessage.setMessage("Ya existe un centro con ese nombre");
					responseMessage.setStatus_code(500);
				}

			} else {
				responseMessage.setExplanation("");
				responseMessage.setMessage("No se ha creado el centro");
				responseMessage.setStatus_code(500);
			}
		} catch (Exception e) {
			responseMessage.setExplanation("");
			responseMessage.setMessage("No se ha creado el centro");
			responseMessage.setStatus_code(500);
		}
		return new ResponseEntity<Respuesta>(responseMessage, HttpStatus.valueOf(responseMessage.getStatus_code()));
	}

	@ApiOperation(value = "Centros", notes = "Eliminar un centro")
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Respuesta> deleteCentroById(@RequestBody Integer id) {
		Respuesta responseMessage = new Respuesta();
		try {
			LOG.info("Inicio servicio prueba");
			Centro centro = centroRepository.findByidCentro(id);
			if (centro != null) {
				centroRepository.delete(centro);
				responseMessage.setExplanation(centro);
				responseMessage.setMessage("");
				responseMessage.setStatus_code(200);
			} else {
				responseMessage.setExplanation("");
				responseMessage.setMessage("El centro no existe");
				responseMessage.setStatus_code(200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info("Ocurrio un error al llamar al servicio prueba "
					.concat(" : ".concat(e.getMessage().concat(e.getLocalizedMessage()))));
			String mensajeError = "Error: " + e.getMessage() + e.getLocalizedMessage();
			responseMessage.setMessage(mensajeError);
			responseMessage.setStatus_code(500);
		}
		LOG.info("Fin servicio prueba");
		return new ResponseEntity<Respuesta>(responseMessage, HttpStatus.valueOf(responseMessage.getStatus_code()));
	}
}
