package com.m2i.medic.services.implementations.frequence;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.duree.DureeDto;
import com.m2i.medic.dtos.frequence.CreationFrequenceDto;
import com.m2i.medic.dtos.frequence.FrequenceDto;
import com.m2i.medic.services.frequence.CreationFrequenceDtoService;
import com.m2i.medic.services.frequence.ModificationFrequenceDtoService;

public class CreationFrequenceDtoServiceImpl implements CreationFrequenceDtoService {

	private static final String CHAQUE_JOURS_TTS_JOURS = "Chaque jours X par jours";
	private static final String CHAQUE_JOURS_TTS_X_HEURES = "Chaque jours toutes les X heures";
	private static final String TTS_X_JOURS = "Tous les X jours";
	private static final String CERTAIN_JOURS = "Certains jours";

	private ObjectMapper mapper;
	private ModificationFrequenceDtoService modifFrequenceService;


	public CreationFrequenceDtoServiceImpl(ObjectMapper mapper, ModificationFrequenceDtoService modifFrequenceService) {
		super();
		this.mapper = mapper;
		this.modifFrequenceService = modifFrequenceService;
	}

	@Override
	public FrequenceDto convertCreationFrequenceDtoToFrequenceDto(CreationFrequenceDto creationFrequenceDto,
			DureeDto dureeDto, List<LocalTime> listeHeures) {
		List<LocalDateTime> prises = new ArrayList<>();

		if (creationFrequenceDto.getChoixFrequence().equals(CHAQUE_JOURS_TTS_X_HEURES)) {
			prises = creationListeJoursAvexChoixChaqueJoursToutesLesXHeures(creationFrequenceDto, dureeDto);
		} else {
			List<LocalDateTime> listeJours = creationListeJours(creationFrequenceDto, dureeDto);
			prises = creationPrisesAvecJoursEtHeures(listeJours, listeHeures);
		}

		FrequenceDto frequenceDto = new FrequenceDto();

		frequenceDto.setPrises(prises);
		frequenceDto = this.mapper.convertValue(this.modifFrequenceService.save(frequenceDto), FrequenceDto.class);

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
	private List<LocalDateTime> creationListeJours(CreationFrequenceDto creationFrequenceDto, DureeDto dureeDto) {

		List<LocalDateTime> listeJours = new ArrayList<>();
		System.out.println("MAPFREQ =>>>> " + creationFrequenceDto);
		if (creationFrequenceDto.getChoixFrequence().equals(CHAQUE_JOURS_TTS_JOURS)) {
			listeJours = creationListeJoursAvexChoixChaqueJoursXParJour(dureeDto);
		} else if (creationFrequenceDto.getChoixFrequence().equals(TTS_X_JOURS)) {
			listeJours = creationListeJoursAvexChoixTousLesXJours(creationFrequenceDto, dureeDto);
		} else if (creationFrequenceDto.getChoixFrequence().equals(CERTAIN_JOURS)) {
			listeJours = creationListeJoursAvexChoixCertainsjours(creationFrequenceDto, dureeDto);
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

	private List<LocalDateTime> creationListeJoursAvexChoixChaqueJoursToutesLesXHeures(
			CreationFrequenceDto creationFrequenceDto, DureeDto dureeDto) {
		List<LocalDateTime> listeJours = creationListeJoursAvexChoixChaqueJoursXParJour(dureeDto);
		List<LocalTime> listeHeures = creationListeHeureChaqueJoursToutesLesXHeures(creationFrequenceDto);

		return creationPrisesAvecJoursEtHeures(listeJours, listeHeures);
	}

	private List<LocalTime> creationListeHeureChaqueJoursToutesLesXHeures(CreationFrequenceDto creationFrequenceDto) {
		List<LocalTime> listeHeures = new ArrayList<>();

		LocalTime debut = creationLocalTimeAvecString(creationFrequenceDto.getHeureDebut().toString());
		LocalTime fin = creationLocalTimeAvecString(creationFrequenceDto.getHeureFin().toString());
		Integer x = Integer.parseInt(creationFrequenceDto.getX().toString());

		for (LocalTime time = debut; (time.getHour() <= fin.getHour()); time.plusHours(x)) {
			listeHeures.add(time);
		}
		return listeHeures;
	}

	private LocalTime creationLocalTimeAvecString(String str) {

		Integer heure = Integer.parseInt(str.substring(1, 3));
		Integer minute = Integer.parseInt(str.substring(4, 6));
		return LocalTime.of(heure, minute);
	}

	private List<LocalDateTime> creationListeJoursAvexChoixTousLesXJours(CreationFrequenceDto creationFrequenceDto,
			DureeDto dureeDto) {
		List<LocalDateTime> listeJours = new ArrayList<>();
		ajouterJourTousLesXJours(dureeDto, listeJours, creationFrequenceDto.getX());
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
	private List<LocalDateTime> creationListeJoursAvexChoixCertainsjours(CreationFrequenceDto creationFrequenceDto,
			DureeDto dureeDto) {

		List<LocalDateTime> listeJours = new ArrayList<>();
		List<String> listeJoursDeLaSemaine = creationListeJoursDeLaSemaine(creationFrequenceDto);

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
	 * de x </br>
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
	private List<String> creationListeJoursDeLaSemaine(CreationFrequenceDto creationFrequenceDto) {
		List<String> listeJoursDeLaSemaine = new ArrayList<>();

		if (creationFrequenceDto.getLundi() != null && creationFrequenceDto.getLundi())
			listeJoursDeLaSemaine.add("MONDAY");
		if (creationFrequenceDto.getMardi() != null && creationFrequenceDto.getMardi())
			listeJoursDeLaSemaine.add("TUESDAY");
		if (creationFrequenceDto.getMercredi() != null && creationFrequenceDto.getMercredi())
			listeJoursDeLaSemaine.add("WEDNESDAY");
		if (creationFrequenceDto.getJeudi() != null && creationFrequenceDto.getJeudi())
			listeJoursDeLaSemaine.add("THURSDAY");
		if (creationFrequenceDto.getVendredi() != null && creationFrequenceDto.getVendredi())
			listeJoursDeLaSemaine.add("FRIDAY");
		if (creationFrequenceDto.getSamedi() != null && creationFrequenceDto.getSamedi())
			listeJoursDeLaSemaine.add("SATURDAY");
		if (creationFrequenceDto.getDimanche() != null && creationFrequenceDto.getDimanche())
			listeJoursDeLaSemaine.add("SUNDAY");

		return listeJoursDeLaSemaine;
	}

}
