package com.m2i.medic.services.medic;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.m2i.medic.dtos.duree.CreationDureeDto;
import com.m2i.medic.dtos.frequence.CreationFrequenceDto;

public interface CreationFrequenceDtoService {
	
	/**
	 * La methode permet de creer un dto FrequenceDto
	 * 
	 * @param mapFreq : Map contenant les informantions concernant la frequence.
	 * @param dureeDto 
	 * @param listeHeures : liste des horaires de prises.
	 * @return 
	 */
	public CreationFrequenceDto createFrequenceFromMapDateFin(Map<String, Object> mapFreq, CreationDureeDto dureeDto,
			List<LocalTime> listeHeures);


	
}
