package com.m2i.medic.services.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.m2i.medic.dtos.CreationDureeDto;
import com.m2i.medic.dtos.CreationFrequenceDto;
import com.m2i.medic.dtos.CreationMedicDto;
import com.m2i.medic.models.Medic;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.MedicService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MedicServiceImpl implements MedicService {

	private MedicRepository medicRepository;
	private ObjectMapper mapper;
	private DateTimeFormatter dateFormatter;
	private DateTimeFormatter timeFormatter;

	public MedicServiceImpl(MedicRepository mediRepo, ObjectMapper mapperParam, DateTimeFormatter dateFormatter,
			DateTimeFormatter timeFormatter) {
		this.medicRepository = mediRepo;
		this.mapper = mapperParam;
		this.dateFormatter = dateFormatter;
		this.timeFormatter = timeFormatter;
	}

	public List<Medic> getAll() {
		return this.medicRepository.findAll();
	}

	public Medic getById(String id) {
		return this.medicRepository.findById(id).get();
	}

	public Medic save(Medic medic) {
		return this.medicRepository.save(medic);
	}

	public void save(Medic[] medic) {
		for (Medic med : medic) {
			System.out.println("save med : " + med.toString());
			this.medicRepository.save(med);
		}
	}

	public Medic updateById(Medic medic) {
		return this.medicRepository.save(medic);
	}

	public void deleteByID(String id) {
		System.out.println("HERETIQUE AU BUCHER " + getById(id).toString());
		this.medicRepository.deleteById(id);
		;
	}

	public void deleteAll() {
		List<Medic> liste = this.medicRepository.findAll();
		for (Medic medic : liste) {
			this.medicRepository.delete(medic);
		}
		// TODO Auto-generated method stub
	}

	public CreationMedicDto convertionJsonMedicVersCreationMedicDto(JsonNode medicTmp)
			throws JsonProcessingException, IllegalArgumentException, IOException {
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("'''''''''convertionJsonMedicVersCreationMedicDto''''");
		System.out.println("convertTmpToReal => " + medicTmp);
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''");

		String nom = getNom(medicTmp);
		Map<String, Object> mapDuree = getMapDuree(medicTmp);
		Map<String, Object> mapFrequence = getMapFrequence(medicTmp);
		List<LocalTime> listeHeures = getListHeures(medicTmp);

		CreationMedicDto medicDto = createMedicDtoFromMaps(nom, mapFrequence, mapDuree, listeHeures);
		System.out.println("CEST LA FIN DU VOYAGE ");
		System.out.println("Medic Dtp ====== >>>> " + medicDto);


		return medicDto;
	}

	public CreationMedicDto createMedicDtoFromMaps(String nom, Map<String, Object> mapFreq,
			Map<String, Object> mapDuree, List<LocalTime> listeHeures) {
		System.out.println("'''''''''createMedicDtoFromMaps''''");
		System.out.println("Map Duree =>" + mapDuree);
		System.out.println("Map Frequence =>" + mapFreq);

		CreationDureeDto dureeDto = createDureeDtoFromMap(mapDuree);
		CreationFrequenceDto frequenceDto = createFrequenceFromMapDateFin(mapFreq, dureeDto, listeHeures);

		CreationMedicDto medicDto = new CreationMedicDto(nom, dureeDto, frequenceDto);
		
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''");

		return medicDto;
	}

	private CreationFrequenceDto createFrequenceFromMapDateFin(Map<String, Object> mapFreq, CreationDureeDto dureeDto,
			List<LocalTime> listeHeures) {

		String choixFreq = mapFreq.get("choixFrequence").toString();
		List<LocalDateTime> listeJours = new ArrayList<>();

		if (choixFreq.equals("Chaque jours X par jours")) {
			for (LocalDateTime date = dureeDto.getDateDebut(); date
					.isBefore(dureeDto.getDateFin()); date = date.plusDays(1)) {
				listeJours.add(date);
			}
		} else if (choixFreq.equals("Chaque jours toutes les X heures")) {
			// TODO
		} else if (choixFreq.equals("Tous les X jours")) {
			// TODO
		} else if (choixFreq.equals("Certains jours")) {
			List<String> listeJoursDeLaSemaine = createlisteJoursDeLaSemaine(mapFreq);
			// TODO
		}

		List<LocalDateTime> prises = creationPrisesAvecJoursEtHeures(listeJours, listeHeures);

		CreationFrequenceDto frequenceDto = new CreationFrequenceDto();
		frequenceDto.setPrises(prises);

		return frequenceDto;
	}

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

	public List<LocalTime> convertListHeuresStringToListHeureLocalTime(List<String> listeHeures) {
		List<LocalTime> listLocalTime = new ArrayList<>();
		Integer heure;
		Integer minute;
		for (String str : listeHeures) {

			heure = Integer.parseInt(str.substring(1, 3));
			minute = Integer.parseInt(str.substring(4, 6));
			LocalTime tmp = LocalTime.of(heure, minute);
			listLocalTime.add(tmp);
		}

		return listLocalTime;
	}

	public CreationDureeDto createDureeDtoFromMap(Map<String, Object> mapDuree) {

		CreationDureeDto dureeDto = new CreationDureeDto();

		LocalDate date = LocalDate.parse(mapDuree.get("dateDebut").toString(), this.dateFormatter);
		LocalDateTime dateDebut = date.atStartOfDay();
		dureeDto.setDateDebut(dateDebut);

		if (mapDuree.get("choixDuree").equals("Pas de fin")) {
			dureeDto.setDateFin(dureeDto.getDateDebut().plusYears(1));

		} else if (mapDuree.get("choixDuree").equals("Pendant X jours") && mapDuree.get("nbJour") != null) {
			Integer nbJour = (Integer) mapDuree.get("nbJour");
			dureeDto.setNbJour(nbJour);
			dureeDto.setDateFin(dureeDto.getDateDebut().plusDays(nbJour));

		} else if (mapDuree.get("choixDuree").equals("Jusque date") && mapDuree.get("dateFin") != null) {
			date = LocalDate.parse(mapDuree.get("dateFin").toString(), this.dateFormatter);
			dureeDto.setNbJour(-1);
			dureeDto.setDateFin(date.atStartOfDay());
		}

		return dureeDto;
	}

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

	public String getNomFromMap(Map<String, Object> map) {
		String nom = (String) map.get("nom");
		return nom;
	}

	/**
	 * La methode permet de renvoye le nom du medicament indique par l'utilisateur
	 * 
	 * @param medicTmp: Le JSON envoye par l'utilisateur
	 * @return String: Nom du medicament.
	 */
	public String getNom(JsonNode medicTmp) {
		return medicTmp.get("nom").toString();
	}

	/**
	 * La methode permet de renvoye dans une map tous les choix de l'utilisateur par
	 * rapport à la duree de prise de son medicament.
	 * 
	 * @param medicTmp: Le JSON envoye par l'utilisateur
	 * @return Map<String, Object>: String = nom de la cle ("dateDebut",
	 *         "choixDuree", "dateFin" et "nbJour") Object = Valeur associe a la
	 *         cle. L'objet peut etre de type String ou Integer.
	 * @throws JsonProcessingException
	 * @throws IllegalArgumentException
	 */
	public Map<String, Object> getMapDuree(JsonNode medicTmp) throws JsonProcessingException, IllegalArgumentException {
		ArrayNode arrayNodeDureeData = (ArrayNode) medicTmp.get("dureeData");
		Iterator<JsonNode> itrDureeData = arrayNodeDureeData.elements();
		Map<String, Object> mapDureeData = this.mapper.treeToValue(itrDureeData.next(), Map.class);
		return mapDureeData;
	}

	/**
	 * La methode permet de renvoye dans une map tous les choix de l'utilisateur par
	 * rapport à la frequence de prise de son medicament.
	 * 
	 * @param medicTmp: Le JSON envoye par l'utilisateur
	 * @return Map<String, Object>: String = nom de la cle ("choixFrequence",
	 *         "rappel", "heureDebut", "lundi", "mardi" ...) Object = Valeur associe
	 *         a la cle. L'objet peut etre de type String ou Integer.
	 * @throws JsonProcessingException
	 * @throws IllegalArgumentException
	 */
	public Map<String, Object> getMapFrequence(JsonNode medicTmp)
			throws JsonProcessingException, IllegalArgumentException {
		ArrayNode arrayNode = (ArrayNode) medicTmp.get("frequenceData");
		Iterator<JsonNode> itrFrequence = arrayNode.elements();
		Map<String, Object> mapFrequence = this.mapper.treeToValue(itrFrequence.next(), Map.class);
		return mapFrequence;
	}

	/**
	 * *
	 * 
	 * @param medicTmp: Le JSON envoye par l'utilisateur
	 * @return List<String>: La liste de toutes les heures choisit par l'utilisateur
	 *         => ["10:35","23:55" ... ]
	 * @throws JsonProcessingException
	 * @throws IllegalArgumentException
	 */
	public List<LocalTime> getListHeures(JsonNode medicTmp) throws JsonProcessingException, IllegalArgumentException {

		ArrayNode arrayNode = (ArrayNode) medicTmp.get("listeHeures");
		Iterator<JsonNode> itrHeures = arrayNode.elements();
		List<String> listeHeures = new ArrayList<>();
		while (itrHeures.hasNext()) {
			listeHeures.add(itrHeures.next().get("heure").toString());
		}

		return convertListHeuresStringToListHeureLocalTime(listeHeures);
	}

}
