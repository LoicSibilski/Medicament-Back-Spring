package com.m2i.medic.services.implementations.medic;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.m2i.medic.dtos.duree.SimpleDureeDto;
import com.m2i.medic.dtos.frequence.SimpleFrequenceDto;
import com.m2i.medic.services.medic.SimpleFrequenceDtoService;

public class SimpleFrequenceDtoServiceImpl implements SimpleFrequenceDtoService {

	public SimpleFrequenceDto createFrequenceFromMapDateFin(Map<String, Object> mapFreq, SimpleDureeDto dureeDto,
			List<LocalTime> listeHeures) {

		String choixFreq = mapFreq.get("choixFrequence").toString();
		List<LocalDateTime> listeJours = creationListeJours(mapFreq, dureeDto, choixFreq);
		List<LocalDateTime> prises = creationPrisesAvecJoursEtHeures(listeJours, listeHeures);
		SimpleFrequenceDto frequenceDto = new SimpleFrequenceDto();

		frequenceDto.setPrises(prises);

		return frequenceDto;
	}

	/**
	 * La methode permet de creer une liste de jours a partir du choix de l'utilisateur, des informations de la frequence et de sa duree.
	 * 
	 * @param mapFreq : Map contenant toutes les informations concernant la frequence dans le Json envoye par l'utilisateur
	 * @param dureeDto : duree de la frequence
	 * @param choixFreq : String : choix du type de frequence par l'utilisateur 
	 * @return List<LocalDateTime> : listeJours : liste de tous les jours ou l'utilisateur devra prendre son medicament. le temps est initialise a 00:00
	 */
	private List<LocalDateTime> creationListeJours(Map<String, Object> mapFreq, SimpleDureeDto dureeDto,
			String choixFreq) {

		List<LocalDateTime> listeJours = new ArrayList<>();

		if (choixFreq.equals("Chaque jours X par jours")) {
			listeJours = creationListeJoursAvexChoixChaqueJoursXParJour(dureeDto);
		} else if (choixFreq.equals("Chaque jours toutes les X heures")) {
			listeJours = creationListeJoursAvexChoixChaqueJoursToutesLesXHeures(dureeDto);
		} else if (choixFreq.equals("Tous les X jours")) {
			listeJours = creationListeJoursAvexChoixTousLesXJours(dureeDto);
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
	 * @param dureeDto : object CreationDureeDto. </br>
	 * @return listeJours : [12/06, 13/06, 14/06, 15/06 .... 20/06]
	 */
	private List<LocalDateTime> creationListeJoursAvexChoixChaqueJoursXParJour(SimpleDureeDto dureeDto) {
		List<LocalDateTime> listeJours = new ArrayList<>();
		for (LocalDateTime date = dureeDto.getDateDebut(); date
				.isBefore(dureeDto.getDateFin()); date = date.plusDays(1)) {
			listeJours.add(date);
		}
		return listeJours;
	}

	private List<LocalDateTime> creationListeJoursAvexChoixChaqueJoursToutesLesXHeures(SimpleDureeDto dureeDto) {
		List<LocalDateTime> listeJours = new ArrayList<>();
		System.out.println("COUCOU JE SUIS DANS creationListeJoursAvexChoixChaqueJoursToutesLesXHeures");
		return listeJours;
	}

	private List<LocalDateTime> creationListeJoursAvexChoixTousLesXJours(SimpleDureeDto dureeDto) {
		List<LocalDateTime> listeJours = new ArrayList<>();
		System.out.println("COUCOU JE SUIS DANS creationListeJoursAvexChoixTousLesXJours");

		return listeJours;
	}

	private List<LocalDateTime> creationListeJoursAvexChoixCertainsjours(SimpleDureeDto dureeDto,
			Map<String, Object> mapFreq) {
		
		List<LocalDateTime> listeJours = new ArrayList<>();
		System.out.println("COUCOU JE SUIS DANS creationListeJoursAvexChoixCertainsjours");

		List<String> listeJoursDeLaSemaine = createlisteJoursDeLaSemaine(mapFreq);
		return listeJours;
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
	 * La methode permet de creer une liste de jours de la semaines.
	 * 
	 * @param mapFreq : Map contenant toutes les informations concernant la frequence dans le Json envoye par l'utilisateur

	 * @return List<String> = liste des jours de la semaines ["Lundi", "Mercredi",
	 *         "Jeudi", "Dimanche"]
	 */
	private List<String> createlisteJoursDeLaSemaine(Map<String, Object> mapFreq) {
		List<String> listeJoursDeLaSemaine = new ArrayList<>();
		for (int i = 5; i < mapFreq.keySet().size(); i++) {
			Boolean bool = (Boolean) mapFreq.get(mapFreq.keySet().toArray()[i]);
			if (bool) {
				listeJoursDeLaSemaine.add((String) mapFreq.keySet().toArray()[i]);
			}
		}
		return listeJoursDeLaSemaine;
	}

}
