package cl.minsal.ar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.minsal.ar.entity.Cita;
import cl.minsal.ar.entity.CitaDetalle;
import cl.minsal.ar.repository.CitaDetalleRepository;
import cl.minsal.ar.repository.CitaRepository;

@Service
public class CitasService {
	
	@Autowired
	CitaRepository citaRepository;
	
	@Autowired
	CitaDetalleRepository citaDetalleRepository;
	
	public Cita addCita(Cita citaDAO) {
		
		
		citaRepository.saveAndFlush(citaDAO);
		return citaDAO;
	
		
	}
	
	public CitaDetalle addCitaDetalle(CitaDetalle citaDetalleDAO) {
		
		
		citaDetalleDAO.getCita().setIdFolio(citaRepository.getNextSeriesIdFolio());
		citaDetalleRepository.save(citaDetalleDAO);
		return citaDetalleDAO;
	
		
	}

}
