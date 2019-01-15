package cl.minsal.ar.controller;




import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import cl.minsal.ar.entity.CitaDetalle;
import cl.minsal.ar.exception.MinsalARException;
import cl.minsal.ar.model.CitaDTO;
import cl.minsal.ar.model.Estado;
import cl.minsal.ar.model.Respuesta;
import cl.minsal.ar.service.CitasService;
import cl.minsal.ar.service.Mapper;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author luisgonzalez
 *
 */
@RestController
@RequestMapping(value = "/citas") 
public class CitasController {
	
	private static final Logger LOG = LogManager.getLogger(CitasController.class);
	
	@Autowired
	CitasService citasService;
	
	@Autowired
	Mapper mapper;
	
	@ApiOperation(value = "Citas", notes = "Obtener todos los centros")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Respuesta> addCita(@RequestBody CitaDTO citaDto) {
		
		
		LOG.info("Entrada /citas "  + citaDto.toString());
		Respuesta res = new Respuesta();
		
		
		
		try {
			CitaDetalle citaDetalle = mapper.getCitaDetalleFromCitaDTO(citaDto);
			res.setResultado(citasService.addCitaDetalle(citaDetalle));
			res.setEstado(getSuccesResult());
		} catch (MinsalARException e) {
			res.setEstado(getEstadoByMinsalException(e));
			
		}
		
		
	
		

		return new ResponseEntity<Respuesta>(res,HttpStatus.OK);
		
	}

	private Estado getEstadoByMinsalException(MinsalARException e) {
		Estado estado = new Estado();
		estado.setCodigo(e.getCode());
		estado.setDescripcion(e.getMessage());
		return estado;
	}

	private Estado getSuccesResult() {
		Estado estado = new Estado();
		estado.setCodigo("OK");
		estado.setDescripcion("resultado exitoso");
		return estado;
	}

	private Estado getEstadoFromMinsalARException(MinsalARException e) {
		
		Estado estado = new Estado();
		estado.setCodigo(e.getCode());
		estado.setDescripcion(e.getMessage());
		return estado;
	}
	
	
	
	
	
}