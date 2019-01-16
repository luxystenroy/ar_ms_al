package cl.minsal.ar.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import cl.minsal.ar.model.EstadoDTO;

public class ValidationErrorBuilder {

    public static List<EstadoDTO> fromBindingErrors(Errors errors) {
    	List<EstadoDTO> estados = new ArrayList<EstadoDTO>();
        for (ObjectError objectError : errors.getAllErrors()) {
        	
        	EstadoDTO estado = new EstadoDTO();
        	estado.setCodigo("003");
        	estado.setDescripcion(objectError.getDefaultMessage());
            estados.add(estado);
        }
        return estados;
    }
}