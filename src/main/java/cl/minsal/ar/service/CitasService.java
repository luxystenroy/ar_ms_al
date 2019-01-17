package cl.minsal.ar.service;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.minsal.ar.entity.Centro;
import cl.minsal.ar.entity.Cita;
import cl.minsal.ar.entity.CitaDetalle;
import cl.minsal.ar.entity.Estado;
import cl.minsal.ar.exception.MinsalARException;
import cl.minsal.ar.model.CitaDTO;
import cl.minsal.ar.model.RsCita;
import cl.minsal.ar.repository.CentroRepository;
import cl.minsal.ar.repository.CitaDetalleRepository;
import cl.minsal.ar.repository.CitaRepository;
import cl.minsal.ar.repository.EstadoRepository;

@Service
public class CitasService {
	
	@Autowired
	CitaRepository citaRepository;
	
	@Autowired
	CitaDetalleRepository citaDetalleRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CentroRepository centroRepository;
	
	@Autowired
	Mapper mapper;
	
	@Transactional
	public RsCita addCitaDetalleAndAddEstado(CitaDTO citaDTO) throws MinsalARException {
		
		
		CitaDetalle citaDetalle = mapper.getCitaDetalleFromCitaDTO(citaDTO);
		Cita cita = mapper.getFromCitaDTOToCita(citaDTO);
		Estado estado = mapper.getEstadoFromCitaDTO(citaDTO);
		cita.setIdFolio(getFolio(citaDTO));
		
		Centro centro = getCentroById(Integer.valueOf(citaDTO.getIdCentro()));
		citaDetalle.setCentro(centro);
		
		try {
			
			
			Cita citaresult = citaRepository.save(cita);
			
			estado.setCita(citaresult);
			
			Estado estadoResult = estadoRepository.saveAndFlush(estado);
			
			Set<Estado> setEstado = new HashSet<Estado>();
			setEstado.add(estadoResult);
			
			citaDetalle.setCita(citaresult);
			
			CitaDetalle citadetalleResult = citaDetalleRepository.save(citaDetalle);
			
			cita.setCitaDetalle(citadetalleResult);
			cita.setEstados(setEstado);
			
			
			
			
			
		}catch (TransactionException e) {
			throw new MinsalARException(e.getMessage(),"006");
		}
	
		
		return mapper.getRsCitaFromCitaAndLastEstado(cita, getTheLastEstadoByCita(cita.getIdCita()));
		
	
		
	}
	
	@Transactional
	public RsCita getRsCitabyIdFolio(String idFolio) throws MinsalARException{
		
	
		
		Cita cita = getCitaByIdFolio(idFolio);
		
		Estado estado = getTheLastEstadoByCita(cita.getIdCita());
		
		
		
		return mapper.getRsCitaFromCitaAndLastEstado(cita, estado);
		
	}
	
	
	public Estado getTheLastEstadoByCita(Integer idCita) throws MinsalARException {
		
		Estado estado = estadoRepository.getTheLastEstadoByIdCita(idCita);
		if(null == estado ) {
			throw new MinsalARException("Cita sin estado","006");
		}
		return estado;
	}
	
	
	public Cita getCitaByIdFolio(String idFolio) throws MinsalARException {
		
		Cita cita = citaRepository.findByidFolio(idFolio);
		
		if(null == cita) {
			throw new MinsalARException("Cita no encontrada","006");
		}
		return cita;
	}
	
	
	
	
	
	

	private String getFolio(CitaDTO citaDTO) {
		StringBuilder idFolio = new StringBuilder();
		idFolio.append(citaDTO.getIdCentro()).append(citaRepository.getNextSeriesIdFolio());
		return idFolio.toString();
	}
	
	private Centro getCentroById(Integer id) throws MinsalARException {
		
		Centro centro = centroRepository.findByidCentro(id);
		if(null == centro ) {
			throw new MinsalARException("Centro no encontrado","006");
		}
		return centro;
		
	}

}
