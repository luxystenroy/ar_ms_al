package cl.minsal.ar.controller;






import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.minsal.ar.exception.MinsalARException;
import cl.minsal.ar.model.CitaDTO;
import cl.minsal.ar.model.EstadoDTO;
import cl.minsal.ar.model.RespuestaDTO;
import cl.minsal.ar.service.CitasService;
import cl.minsal.ar.service.Mapper;
import cl.minsal.ar.util.ValidationErrorBuilder;
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
	
	@ApiOperation(value = "Citas", notes = "Agregar citas")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<RespuestaDTO> addCita(@Valid @RequestBody CitaDTO citaDto) {
		
		
		LOG.info("Entrada /citas "  + citaDto.toString());
		RespuestaDTO res = new RespuestaDTO();
		
		
		
		try {
			
			res.setResultado(citasService.addCitaDetalleAndAddEstado(citaDto));
			res.setEstado(getSuccesResult());
		} catch (MinsalARException e) {
			res.setEstado(getNotOKResult());
			res.addEstadoDTO(getEstadoByMinsalException(e));
			
		}
		
		
	
		

		return new ResponseEntity<RespuestaDTO>(res,HttpStatus.OK);
		
	}

	private EstadoDTO getEstadoByMinsalException(MinsalARException e) {
		EstadoDTO estado = new EstadoDTO();
		estado.setCodigo(e.getCode());
		estado.setDescripcion(e.getMessage());
		return estado;
	}

	private EstadoDTO getSuccesResult() {
		EstadoDTO estado = new EstadoDTO();
		estado.setCodigo("OK");
		estado.setDescripcion("resultado exitoso");
		return estado;
	}
	
	@ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public RespuestaDTO handleException(MethodArgumentNotValidException exception) {
        RespuestaDTO rs = new RespuestaDTO();
		rs.setEstado(getNotOKResult());
		
		
		rs.setObservaciones(createValidationError(exception));
		
		return rs;
    }

    private List<EstadoDTO> createValidationError(MethodArgumentNotValidException e) {
        return ValidationErrorBuilder.fromBindingErrors(e.getBindingResult());
    }
    
    private EstadoDTO getNotOKResult() {
		EstadoDTO estado = new EstadoDTO();
		estado.setCodigo("NOK");
		estado.setDescripcion("resultado con observaciones");
		return estado;
	}

	
	
	
	
	
	
}