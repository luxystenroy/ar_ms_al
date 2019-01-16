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
		
		RsCita rsCita;
		
		CitaDetalle citaDetalle = mapper.getCitaDetalleFromCitaDTO(citaDTO);
		Cita cita = mapper.getFromCitaDTOToCita(citaDTO);
		Estado estado = mapper.getEstadoFromCitaDTO(citaDTO);
		cita.setIdFolio(getFolio(citaDTO));
		
		Centro centro = getCentroById(Integer.valueOf(citaDTO.getIdCentro()));
		citaDetalle.setCentro(centro);
		
		try {
			Set<Estado> setEstado = new HashSet<Estado>();
			setEstado.add(estadoRepository.save(estado));
			cita.setEstados(setEstado);
			
			
			
			citaRepository.save(cita);
			
			
			cita.setCitaDetalle(citaDetalle);
		
			citaDetalleRepository.save(cita.getCitaDetalle());
			
			
		}catch (TransactionException e) {
			throw new MinsalARException(e.getMessage(),"006");
		}
	
		
		rsCita = mapper.getRsCitaFromCita(cita);
		return rsCita;
	
		
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
