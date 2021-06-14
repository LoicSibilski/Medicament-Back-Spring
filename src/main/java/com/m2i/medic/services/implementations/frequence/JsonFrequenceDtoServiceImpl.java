package com.m2i.medic.services.implementations.frequence;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.duree.DureeDto;
import com.m2i.medic.dtos.frequence.FrequenceDto;
import com.m2i.medic.services.frequence.JsonFrequenceDtoService;
import com.m2i.medic.services.frequence.ModificationFrequenceDtoService;

public class JsonFrequenceDtoServiceImpl implements JsonFrequenceDtoService {

	private ModificationFrequenceDtoService modifFrequenceService;
	private ObjectMapper mapper;

	public JsonFrequenceDtoServiceImpl(ModificationFrequenceDtoService modifFrequenceService, ObjectMapper mapper) {
		this.modifFrequenceService = modifFrequenceService;
		this.mapper = mapper;
	}

	public FrequenceDto createFrequenceFromMapDateFin(Map<String, Object> mapFreq, DureeDto dureeDto,
			List<LocalTime> listeHeures) {

		List<LocalDateTime> prises = new ArrayList<>();
		String choixFreq = mapFreq.get("choixFrequence").toString();
		if (choixFreq.equals("Chaque jours toutes les X heures")) {
			prises = creationListeJoursAvexChoixChaqueJoursToutesLesXHeures(dureeDto, mapFreq);
		} else {
			List<LocalDateTime> listeJours = creationListeJours(mapFreq, dureeDto, choixFreq);
			prises = creationPrisesAvecJoursEtHeures(listeJours, listeHeures);
		}
		FrequenceDto frequenceDto = new FrequenceDto();

		frequenceDto.setPrises(prises);

		FrequenceDto freqDto = this.mapper.convertValue(frequenceDto, FrequenceDto.class);
		frequenceDto = this.mapper.convertValue(this.modifFrequenceService.save(freqDto), FrequenceDto.class);

		return frequenceDto;
	}

	/**
	 * La methode permet de creer une liste de jours a partir du choix de
	 * l'utilisateur, des informations de la frequence et de sa duree.
	 * 
	 * @param mapFreq   : Map contenant toutes les informations concernant la
	 *                  frequence dans le Json envoye par l'utilisateur
	 * @param dureeDto  : duree de la frequence
	 * @param choixFreq : String : choix du type de frequence par l'utilisateur
	 * @return List<LocalDateTime> : listeJours : liste de tous les jours ou
	 *         l'utilisateur devra prendre son medicament. le temps est initialise a
	 *         00:00
	 */
	private List<LocalDateTime> creationListeJours(Map<String, Object> mapFreq, DureeDto dureeDto, String choixFreq) {

		List<LocalDateTime> listeJours = new ArrayList<>();
		System.out.println("MAPFREQ =>>>> " + mapFreq);
		if (choixFreq.equals("Chaque jours X par jours")) {
			listeJours = creationListeJoursAvexChoixChaqueJoursXParJour(dureeDto);

		} else if (choixFreq.equals("Tous les X jours")) {
			listeJours = creationListeJoursAvexChoixTousLesXJours(dureeDto, mapFreq);
		} else if (choixFreq.equals("Certains jours")) {
			listeJours = creationListeJoursAvexChoixCertainsjours(dureeDto, mapFreq);
		}

		return listeJours;
	}

	/**
	 * La methode permet part de la date de debut du traitement, et ajoute tous les
	 * jours dans la liste jusqu'a la date de fin. </br>
	 * Exemple : </br>
	 * dateDebut : 12/06/2021 </br>
	 * datefin : 20/06/2021 </br>
	 * listeJours : [12/06, 13/06, 14/06, 15/06 .... 20/06]
	 * 
	 * @param dureeDto : DureeDto. </br>
	 * @return listeJours : [12/06, 13/06, 14/06, 15/06 .... 20/06]
	 */
	private List<LocalDateTime> creationListeJoursAvexChoixChaqueJoursXParJour(DureeDto dureeDto) {
		List<LocalDateTime> listeJours = new ArrayList<>();
		ajouterJourTousLesXJours(dureeDto, listeJours, 1);
		return listeJours;
	}

	private List<LocalDateTime> creationListeJoursAvexChoixChaqueJoursToutesLesXHeures(DureeDto dureeDto,
			Map<String, Object> mapFreq) {
		List<LocalDateTime> listeJours = creationListeJoursAvexChoixChaqueJoursXParJour(dureeDto);
		List<LocalTime> listeHeures = creationListeHeureChaqueJoursToutesLesXHeures(mapFreq);
		
		return creationPrisesAvecJoursEtHeures(listeJours, listeHeures);
	}

	private List<LocalTime> creationListeHeureChaqueJoursToutesLesXHeures(Map<String, Object> mapFreq) {
		List<LocalTime> listeHeures = new ArrayList<>();
		LocalTime debut = creationLocalTimeAvecString(mapFreq.get("heureDebut").toString());
		LocalTime fin = creationLocalTimeAvecString(mapFreq.get("heureFin").toString());
		Integer x = Integer.parseInt(mapFreq.get("x").toString());
		
		for(LocalTime time = debut; (time.getHour()<=fin.getHour());time.plusHours(x)) {
			listeHeures.add(time);
		}
		return null;
	}

	private LocalTime creationLocalTimeAvecString(String str) {
		
		Integer heure = Integer.parseInt(str.substring(1, 3));
		Integer minute = Integer.parseInt(str.substring(4, 6));
		return LocalTime.of(heure, minute);
	}

	private List<LocalDateTime> creationListeJoursAvexChoixTousLesXJours(DureeDto dureeDto,
			Map<String, Object> mapFreq) {
		List<LocalDateTime> listeJours = new ArrayList<>();
		ajouterJourTousLesXJours(dureeDto, listeJours, (Integer) mapFreq.get("x"));
		return listeJours;
	}

	/**
	 * La methode part de la date de debut du de prise du medicament, et ajoute tous
	 * les jours dans la liste jusqu'a la date de fin SI le jour en question est
	 * dans la liste des jours choisis par l'utilisateur (lundi,mardi ...).
	 * 
	 * @param dureeDto : DureeDto
	 * @param mapFreq  : Map contenant toutes les informations concernant la
	 *                 frequence dans le Json envoye par l'utilisateur
	 * @return
	 */
	private List<LocalDateTime> creationListeJoursAvexChoixCertainsjours(DureeDto dureeDto,
			Map<String, Object> mapFreq) {

		List<LocalDateTime> listeJours = new ArrayList<>();
		List<String> listeJoursDeLaSemaine = creationListeJoursDeLaSemaine(mapFreq);

		for (LocalDateTime date = dureeDto.getDateDebut(); date
				.isBefore(dureeDto.getDateFin()); date = date.plusDays(1)) {
			if (listeJoursDeLaSemaine.contains(date.getDayOfWeek().toString())) {
				listeJours.add(date);
			}
		}

		return listeJours;
	}

	/**
	 * Méthode, qui retourne une liste de LocalDateTime contenant tous les jours
	 * depuis la date de debut de dureeDto jusque sa date de fin avec un intervalle
	 * de X </br>
	 * Exemple => </br>
	 * debut : 14/06/2021</br>
	 * fin : 20/06/2021</br>
	 * x : 2</br>
	 * RETURN : [14/06/2021, 16/06/2021, 18/06/2021, 20/06/2021]
	 * 
	 * @param dureeDto
	 * @param listeJours
	 * @param x          : Integer Intervalle entre chaque jours de la liste.
	 */
	private void ajouterJourTousLesXJours(DureeDto dureeDto, List<LocalDateTime> listeJours, Integer x) {
		for (LocalDateTime date = dureeDto.getDateDebut(); date
				.isBefore(dureeDto.getDateFin()); date = date.plusDays(x)) {
			listeJours.add(date);
		}
	}

	/**
	 * La methode permet de convertir une liste de dates et une liste d'horaires en
	 * une liste des deux.
	 * 
	 * @param listeJours  : List<LocalDateTime> => tous les horaires des dates sont
	 *                    egals a 00:00:00.
	 * @param listeHeures : List<LocalTime> => contient tous les horaires de prises.
	 * @return List<LocalDateTime>
	 */
	private List<LocalDateTime> creationPrisesAvecJoursEtHeures(List<LocalDateTime> listeJours,
			List<LocalTime> listeHeures) {
		List<LocalDateTime> listeJoursHeures = new ArrayList<>();
		for (LocalDateTime jour : listeJours) {
			for (LocalTime temps : listeHeures) {
				listeJoursHeures.add(LocalDateTime.of(jour.toLocalDate(), temps));
			}
		}
		System.out.println("listeJoursHeures => " + listeJoursHeures);
		System.out.println("listeJoursHeures size  => " + listeJoursHeures.size());
		return listeJoursHeures;
	}

	/**
	 * creer une liste de jours de la semaines sous format Java.LocalDateTime.
	 * 
	 * @param mapFreq : Map contenant toutes les informations concernant la
	 *                frequence dans le Json envoye par l'utilisateur
	 * 
	 * @return List<String> = liste des jours de la semaines ["MONDAY", "WEDNESDAY",
	 *         "THURSDAY", "SUNDAY"]
	 */
	private List<String> creationListeJoursDeLaSemaine(Map<String, Object> mapFreq) {
		List<String> listeJoursDeLaSemaine = new ArrayList<>();
		for (int i = 5; i < mapFreq.keySet().size(); i++) {
			Boolean bool = (Boolean) mapFreq.get(mapFreq.keySet().toArray()[i]);
			if (bool) {
				listeJoursDeLaSemaine.add((String) mapFreq.keySet().toArray()[i]);
			}
		}

		return convertListeJoursEnListDaysOfWeek(listeJoursDeLaSemaine);
	}

	/**
	 * Convertie une liste de jours avec le nommage en francais en une liste de
	 * jours avec le nommage de Java.LocalDateTime. </br>
	 * EXEMPLE : ["lundi","mardi","jeudi","dimanche"] ====>
	 * ["MONDAY","TUESDAY","THURSDAY","SUNDAY"]
	 * 
	 * @param listeJours
	 * @return
	 */
	private List<String> convertListeJoursEnListDaysOfWeek(List<String> listeJours) {
		List<String> listDays = new ArrayList<>();
		for (String jour : listeJours) {
			listDays.add(convertJourEnDay(jour));
		}
		return listDays;
	}

	/**
	 * Convertie un nom de jour en Français en un nom de jour sous le format
	 * Java.LocalDateTime </br>
	 * EXEMPLE : "lundi" ====> "MONDAY"
	 * 
	 * @param jour : String = "lundi"
	 * @return
	 */
	private String convertJourEnDay(String jour) {
		if (jour == "lundi")
			return "MONDAY";
		else if (jour == "mardi")
			return "TUESDAY";
		else if (jour == "mercredi")
			return "WEDNESDAY";
		else if (jour == "jeudi")
			return "THURSDAY";
		else if (jour == "vendredi")
			return "FRIDAY";
		else if (jour == "samedi")
			return "SATURDAY";
		else
			return "SUNDAY";
	}

}
