package com.m2i.medic.services.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.m2i.medic.dtos.CreationDureeDto;
import com.m2i.medic.dtos.CreationFrequenceDto;
import com.m2i.medic.dtos.CreationMedicDto;
import com.m2i.medic.models.Duree;
import com.m2i.medic.models.Frequence;
import com.m2i.medic.models.Medic;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.MedicService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MedicServiceImpl implements MedicService {

	private MedicRepository medicRepository;
	private ObjectMapper mapper;

	public MedicServiceImpl(MedicRepository mediRepo, ObjectMapper mapperParam) {
		this.medicRepository = mediRepo;
		this.mapper = mapperParam;
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
		System.out.println(
				"__________________________convertionJsonMedicVersCreationMedicDto____________________________________________");
		System.out.println("convertTmpToReal => " + medicTmp);

		Map<String, String> mapNom = getMapNom(medicTmp);
		Map<String, String> mapDuree = getMapDuree(medicTmp);
		Map<String, String> mapFrequence = getMapFrequence(medicTmp);

//		CreationDureeDto dureeDto = createDureeDtoFromMap(mapDuree);
//		CreationFrequenceDto frequenceDto = createFrequenceDtoFromMap(mapFrequence);
		CreationMedicDto medicDto = createMedicDtoFromMaps(mapFrequence, mapDuree);

//		medicDto.setFrequenceDto(frequenceDto);
		// medicDto.setNom(getNomFromMap(mapNom));
//		medicDto.setDureeDto(dureeDto);

		return medicDto;
	}

	public String getNomFromMap(Map<String, String> map) {
		String nom = map.get("nom");
		return nom;
	}

	public CreationMedicDto createMedicDtoFromMaps(Map<String, String> mapFreq, Map<String, String> mapDuree) {
		System.out.println(
				"\n" + "__________________________createMedicDtoFromMaps____________________________________________");
		System.out.println("Map Duree =>" + mapDuree);
		System.out.println("Map Frequence =>" + mapFreq);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");
		CreationDureeDto dureeDto = createDureeDtoFromMap(mapDuree, formatter);
		LocalDateTime dateFin;

		if (mapDuree.get("dateFin") != null) {
			dateFin = LocalDateTime.parse(mapDuree.get("dateFin"), formatter);
		} else if (mapDuree.get("nbJour") != null) {
			Object str = mapDuree.get("nbJour");
			Integer i = (Integer) str;
			dateFin = dureeDto.getDateDebut().plusDays(i);
		} else {
			dateFin = dureeDto.getDateDebut().plusYears(1);
		}

		CreationFrequenceDto frequenceDto = createFrequenceFromMapDateFin(mapFreq, dateFin, dureeDto.getDateDebut());

		return null;
	}

	private CreationFrequenceDto createFrequenceFromMapDateFin(Map<String, String> mapFreq, LocalDateTime dateFin,
			LocalDateTime dateDebut) {
		System.out.println("\n"
				+ "_______________________createFrequenceFromMapDateFin____________________________________________");

		if (mapFreq.get("choixFrequence").equals("Certains jours")) {
			List<String> listeJoursDeLaSemaine = createlisteJoursDeLaSemaine(mapFreq);
			
		}
		return null;
	}

	private List<String> createlisteJoursDeLaSemaine(Map<String, String> mapFreq) {
		List<String> listeJoursDeLaSemaine = new ArrayList<>();
		Set<String> keyset = mapFreq.keySet();
		for (int i = 5; i < mapFreq.keySet().size(); i++) {
			Object obj = mapFreq.get(mapFreq.keySet().toArray()[i]);
			Boolean bool = (Boolean) obj;
			if (bool) {
				listeJoursDeLaSemaine.add((String) mapFreq.keySet().toArray()[i]);
			}
		}
		return listeJoursDeLaSemaine;
	}

	public CreationDureeDto createDureeDtoFromMap(Map<String, String> mapDuree, DateTimeFormatter formatter) {
		System.out.println("\n" + "__________________________createDureeDtoFromMap_______________________________");

		CreationDureeDto dureeDto = new CreationDureeDto();
		LocalDateTime dateDebut = LocalDateTime.parse(mapDuree.get("dateDebut"), formatter);

		if (mapDuree.get("nbJour") != null) {
			Object str = mapDuree.get("nbJour");
			Integer i = (Integer) str;
			dureeDto.setNbJour(i);
		}
		dureeDto.setDateDebut(dateDebut);
		System.out.println("Dureeeeee DTO ---- > " + dureeDto);
		return dureeDto;
	}

	public Map<String, String> getMapNom(JsonNode medicTmp) throws JsonProcessingException, IllegalArgumentException {
		Map<String, String> mapNom = this.mapper.treeToValue(medicTmp.get("nom"), Map.class);
		return mapNom;
	}

	public Map<String, String> getMapDuree(JsonNode medicTmp) throws JsonProcessingException, IllegalArgumentException {
		ArrayNode arrayNodeDureeData = (ArrayNode) medicTmp.get("dureeData");
		Iterator<JsonNode> itrDureeData = arrayNodeDureeData.elements();
		Map<String, String> mapDureeData = this.mapper.treeToValue(itrDureeData.next(), Map.class);
		return mapDureeData;
	}

	public Map<String, String> getMapFrequence(JsonNode medicTmp)
			throws JsonProcessingException, IllegalArgumentException {
		ArrayNode arrayNode = (ArrayNode) medicTmp.get("frequenceData");
		Iterator<JsonNode> itrFrequence = arrayNode.elements();
		Map<String, String> mapFrequence = this.mapper.treeToValue(itrFrequence.next(), Map.class);
		return mapFrequence;
	}

}
