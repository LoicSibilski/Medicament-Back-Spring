package com.m2i.medic.services.frequence;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.m2i.medic.dtos.duree.SimpleDureeDto;
import com.m2i.medic.dtos.frequence.SimpleFrequenceDto;

public interface SimpleFrequenceDtoService {
	
	/**
	 * La methode permet de creer un dto FrequenceDto
	 * 
	 * @param mapFreq : Map contenant les informantions concernant la frequence.
	 * @param dureeDto 
	 * @param listeHeures : liste des horaires de prises.
	 * @return 
	 */
	public SimpleFrequenceDto createFrequenceFromMapDateFin(Map<String, Object> mapFreq, SimpleDureeDto dureeDto,
			List<LocalTime> listeHeures);


	
}
