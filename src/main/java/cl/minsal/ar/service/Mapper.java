package cl.minsal.ar.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import cl.minsal.ar.entity.Cita;
import cl.minsal.ar.entity.CitaDetalle;
import cl.minsal.ar.entity.Estado;
import cl.minsal.ar.entity.EstadoCitaAPS;
import cl.minsal.ar.entity.Origen;
import cl.minsal.ar.exception.MinsalARException;
import cl.minsal.ar.model.CitaDTO;
import cl.minsal.ar.model.RsCita;
import cl.minsal.ar.util.MinsalARUtil;

@Service
public class Mapper {
	
	/**
	 * 
	 * @param citaDTO
	 * @return
	 * @throws MinsalARException
	 */
	public Cita getFromCitaDTOToCita(CitaDTO citaDTO) throws MinsalARException {
		
		Cita cita = new Cita();
		cita.setCreateCita(new Date());
		cita.setIdCitaAps(citaDTO.getIdCitaAps());
		cita.setOrigen(citaDTO.getOrigen());
		cita.setHoraCita(MinsalARUtil.fromApsDateFormatToDate(citaDTO.getHoracita()));

		return cita;
		
		
	}
	/**
	 * 
	 * @param citaDTO
	 * @return
	 * @throws MinsalARException 
	 */
	public Estado getEstadoFromCitaDTO(CitaDTO citaDTO) throws MinsalARException {
		
		Origen.validate(citaDTO.getOrigen());
		
		Estado estado = new Estado();
		estado.setEstadoCita(EstadoCitaAPS.getEnumByName(citaDTO.getEstado()));
		estado.setFechaCreacionEstado(new Date());
		estado.setOrigen(Origen.valueOf(citaDTO.getOrigen().toUpperCase()));
		
		return estado;
	}

	/**
	 * 
	 * @param citaDTO
	 * @return
	 * @throws MinsalARException
	 */
	public CitaDetalle getCitaDetalleFromCitaDTO(CitaDTO citaDTO){
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
		citaDetalle.setCanal(citaDTO.getCanal());
		return citaDetalle;
		
	}
	
	public RsCita getRsCitaFromCita(Cita cita) {
		
		CitaDetalle citaDetalle = cita.getCitaDetalle();
		Estado ultimoEstado = new Estado();
		for (Estado estado : cita.getEstados()) {
			ultimoEstado = estado;
		}
		
		RsCita rsCita = new RsCita();
		rsCita.setEstado(ultimoEstado.getEstadoCita().getRealName());
		rsCita.setHoraCita(MinsalARUtil.fromDateToFormatFrontString(cita.getHoraCita()));
		rsCita.setIdAPSCita(cita.getIdCitaAps());
		rsCita.setIdCentroAtencion(citaDetalle.getCentro().getidCentro().toString());
		rsCita.setNombreCentroAtencion(citaDetalle.getCentro().getnombreCentro());
		rsCita.setNombreEspecialista(citaDetalle.getNombreEspecialista());
		rsCita.setIdFolio(cita.getIdFolio());
		rsCita.setIdCita(cita.getIdCita().toString());
		rsCita.setEmail(citaDetalle.getEmailUsuario());
		rsCita.setTelefono(citaDetalle.getTelefonoUsuario());
		
		return rsCita;
		
	}

	
	

}
