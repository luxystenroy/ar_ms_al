package cl.minsal.ar.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import cl.minsal.ar.entity.Cita;
import cl.minsal.ar.entity.CitaDetalle;
import cl.minsal.ar.exception.MinsalARException;
import cl.minsal.ar.model.CitaDTO;
import cl.minsal.ar.util.MinsalARUtil;

@Service
public class Mapper {
	
	
	public Cita getFromCitaDTOToCita(CitaDTO citaDTO) throws MinsalARException {
		
		Cita cita = new Cita();
		cita.setCreateCita(new Date());
		cita.setIdCitaAps(citaDTO.getIdCitaAps());
		cita.setOrigen(citaDTO.getOrigen());
		cita.setHoraCita(MinsalARUtil.fromApsDateFormatToDate(citaDTO.getHoracita()));
		return cita;
		
		
	}

	public CitaDetalle getCitaDetalleFromCitaDTO(CitaDTO citaDTO) throws MinsalARException {
		CitaDetalle citaDetalle = new CitaDetalle();
		citaDetalle.setEmailUsuario(citaDTO.getEmail());
		citaDetalle.setFechaModificacionCita(new Date());
		citaDetalle.setNombreEspecialista(citaDTO.getNombreEspecialista());
		citaDetalle.setRutPaciente(citaDTO.getRutPaciente());
		citaDetalle.setNombrePaciente(citaDTO.getNombrePaciente());
		citaDetalle.setRutPaciente(citaDTO.getRutPaciente());
		citaDetalle.setRutUsuario(citaDTO.getRutUsuario());
		citaDetalle.setNombreUsuario(citaDTO.getNombreUsuario());
		citaDetalle.setTelefonoUsuario(citaDTO.getTelefono());
		citaDetalle.setTipoConsulta(citaDTO.getTipoConsulta());
		citaDetalle.setCita(getFromCitaDTOToCita(citaDTO));
		return citaDetalle;
		
	}
	
	
	

}
