package com.m2i.medic.services.frequence;

import java.time.LocalTime;
import java.util.List;

import com.m2i.medic.dtos.duree.DureeDto;
import com.m2i.medic.dtos.frequence.CreationFrequenceDto;
import com.m2i.medic.dtos.frequence.FrequenceDto;

public interface CreationFrequenceDtoService {

	/**
	 * 
	 * La methode permet de creer un FrequenceDto à partir du CréationFrequenceDto
	 * fournis par le FRONT
	 * 
	 * @param CreationFrequenceDto : DTO contenant les informations fournis par
	 *                             l'utilisateur depuis le FRONT
	 * @param dureeDto : DTO contenant les informations sur la durée de prise du medicament
	 * @param listeHeures : Liste de toutes les heures choisis par l'utilisateur
	 * @return FrequenceDto : DTO contenant les informations après le traitement par
	 *         le BACK
	 */
	public FrequenceDto convertCreationFrequenceDtoToFrequenceDto(CreationFrequenceDto creationFrequenceDto,
			DureeDto dureeDto, List<LocalTime> listeHeures);

}
