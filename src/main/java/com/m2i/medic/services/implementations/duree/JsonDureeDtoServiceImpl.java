package com.m2i.medic.services.implementations.duree;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.m2i.medic.dtos.duree.SimpleDureeDto;
import com.m2i.medic.services.duree.JsonDureeDtoService;
import com.m2i.medic.services.duree.ModificationDureeService;

public class JsonDureeDtoServiceImpl implements JsonDureeDtoService{

	private DateTimeFormatter dateFormatter;
	private ModificationDureeService dureeDtoService;
	
	public JsonDureeDtoServiceImpl(DateTimeFormatter dateFormatter, ModificationDureeService dureeDtoService) {
		this.dureeDtoService = dureeDtoService;
		this.dateFormatter = dateFormatter;
	}

	public SimpleDureeDto createDureeDtoFromMap(Map<String, Object> mapDuree) {

		SimpleDureeDto dureeDto = getDureeWithDateDebutFromMap(mapDuree);
		String choix = mapDuree.get("choixDuree").toString();
		
		setDureeDtoFromMap(mapDuree, dureeDto, choix);
		
		return dureeDto;
	}

	/**
	 * 
	 * @param mapDuree : Map contenant toutes les informations concernant la duree dans le Json envoye par l'utilisateur
	 * @param dureeDto: CreationDureeDto = Object dto contenant la date de debut.
	 * @param choix :String = option que l'utilisateur a choisit ("Pas de fin", "Pendant X jours" ...).
	 */
	private void setDureeDtoFromMap(Map<String, Object> mapDuree, SimpleDureeDto dureeDto, String choix) {
		if (choix.equals("Pas de fin")) {
			dureeDto.setDateFin(dureeDto.getDateDebut().plusYears(1));

		} else if (choix.equals("Pendant X jours") && mapDuree.get("nbJour") != null) {
			Integer nbJour = (Integer) mapDuree.get("nbJour");
			dureeDto.setDateFin(dureeDto.getDateDebut().plusDays(nbJour));

		} else if (choix.equals("Jusque date") && mapDuree.get("dateFin") != null) {
			LocalDate date = LocalDate.parse(mapDuree.get("dateFin").toString(), this.dateFormatter);
			dureeDto.setDateFin(date.atStartOfDay());
		}
	}

	/**
	 * La methode initialise la date de debut du dto CreationDureeDto
	 * @param mapDuree : Map contenant toutes les informations concernant la duree dans le Json envoye par l'utilisateur
	 * @return CreationDureeDto 
	 */
	private SimpleDureeDto getDureeWithDateDebutFromMap(Map<String, Object> mapDuree) {
		SimpleDureeDto dureeDto = new SimpleDureeDto();

		LocalDate date = LocalDate.parse(mapDuree.get("dateDebut").toString(), this.dateFormatter);
		LocalDateTime dateDebut = date.atStartOfDay();
		dureeDto.setDateDebut(dateDebut);
		return dureeDto;
	}
}
