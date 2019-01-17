package cl.minsal.ar.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import cl.minsal.ar.entity.Cita;
import cl.minsal.ar.entity.CitaDetalle;
import cl.minsal.ar.entity.Estado;
import cl.minsal.ar.entity.EstadoCitaAPS;
import cl.minsal.ar.entity.Origen;
import cl.minsal.ar.entity.TipoCita;
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
		TipoCita.validate(citaDTO.getTipoCita());
		Cita cita = new Cita();
		cita.setCreateCita(new Date());
		cita.setIdCitaAps(citaDTO.getIdCitaAps());
		cita.setHoraCita(MinsalARUtil.fromApsDateFormatToDate(citaDTO.getHoracita()));
		cita.setTipoCita(TipoCita.valueOf(citaDTO.getTipoCita().toUpperCase()));
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
	
	public RsCita getRsCitaFromCitaAndLastEstado(Cita cita, Estado estado) {
		
		CitaDetalle citaDetalle = cita.getCitaDetalle();
		
		RsCita rsCita = new RsCita();
		rsCita.setEstado(estado.getEstadoCita().getRealName());
		rsCita.setHoraCita(MinsalARUtil.fromDateToFormatFrontString(cita.getHoraCita()));
		rsCita.setIdAPSCita(cita.getIdCitaAps());
		rsCita.setIdCentroAtencion(citaDetalle.getCentro().getidCentro().toString());
		rsCita.setNombreCentroAtencion(citaDetalle.getCentro().getnombreCentro());
		rsCita.setNombreEspecialista(citaDetalle.getNombreEspecialista());
		rsCita.setIdFolio(cita.getIdFolio());
		rsCita.setIdCita(cita.getIdCita().toString());
		rsCita.setEmail(citaDetalle.getEmailUsuario());
		rsCita.setTelefono(citaDetalle.getTelefonoUsuario());
		rsCita.setRutPaciente(citaDetalle.getRutPaciente());
		rsCita.setRutUsuario(citaDetalle.getRutUsuario());
		
		return rsCita;
		
	}

	
	

}
