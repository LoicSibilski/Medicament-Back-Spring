package com.m2i.medic.services.duree;

import java.util.Map;

import com.m2i.medic.dtos.duree.DureeDto;

public interface JsonDureeDtoService {

	/**
	 * La methode permet de creer un dto CreationDureeDto
	 * 
	 * @param mapDuree : Map contenant toutes les informations concernant la duree dans le Json envoye par l'utilisateur
	 * 
	 * @return CreationDureeDto : un object dto contenant la duree.
	 */
	public DureeDto createDureeDtoFromMap(Map<String, Object> mapDuree);

	
}
