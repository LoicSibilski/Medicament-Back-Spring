package com.m2i.medic.services.medic;

import java.util.Map;

import com.m2i.medic.dtos.duree.SimpleDureeDto;

public interface SimpleDureeDtoService {
	
	/**
	 * La methode permet de creer un dto CreationDureeDto
	 * 
	 * @param mapDuree : Map contenant toutes les informations concernant la duree dans le Json envoye par l'utilisateur
	 * 
	 * @return CreationDureeDto : un object dto contenant la duree.
	 */
	public SimpleDureeDto createDureeDtoFromMap(Map<String, Object> mapDuree);

}
