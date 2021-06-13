package com.m2i.medic.services.frequence;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.m2i.medic.dtos.duree.DureeDto;
import com.m2i.medic.dtos.frequence.FrequenceDto;

public interface JsonFrequenceDtoService {
	
	/**
	 * La methode permet de creer un dto FrequenceDto
	 * 
	 * @param mapFreq : Map contenant les informantions concernant la frequence.
	 * @param dureeDto 
	 * @param listeHeures : liste des horaires de prises.
	 * @return 
	 */
	public FrequenceDto createFrequenceFromMapDateFin(Map<String, Object> mapFreq, DureeDto dureeDto,
			List<LocalTime> listeHeures);

}
