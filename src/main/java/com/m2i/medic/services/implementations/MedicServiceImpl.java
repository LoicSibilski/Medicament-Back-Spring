package com.m2i.medic.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.m2i.medic.models.Frequence;
import com.m2i.medic.models.Medic;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.MedicService;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MedicServiceImpl implements MedicService {

	@Autowired
	private MedicRepository medicRepository;

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

	public Medic convertTmpToReal(JsonNode medicTmp)
			throws JsonProcessingException, IllegalArgumentException, IOException {

		System.out.println("njnj => " + medicTmp);

		Medic medic = new Medic();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

		Map<String, String> mapNom = getMapNom(mapper, medicTmp);
		Map<String, String> mapDuree = getMapDuree(mapper, medicTmp);
		Map<String, String> mapFrequence = getMapFrequence(mapper, medicTmp);

		return medic;
	}

	public Frequence createFrequenceFromMap(Map<String, String> map) {
		return null;
	}

	public Map<String, String> getMapNom(ObjectMapper mapper, JsonNode medicTmp)
			throws JsonProcessingException, IllegalArgumentException {
		Map<String, String> mapNom = mapper.treeToValue(medicTmp.get("nom"), Map.class);
		System.out.println("maaaaap nom => + " + mapNom.values());
		return mapNom;
	}

	public Map<String, String> getMapDuree(ObjectMapper mapper, JsonNode medicTmp)
			throws JsonProcessingException, IllegalArgumentException {
		ArrayNode arrayNodeDureeData = (ArrayNode) medicTmp.get("dureeData");
		Iterator<JsonNode> itrDureeData = arrayNodeDureeData.elements();
		Map<String, String> mapDureeData = mapper.treeToValue(itrDureeData.next(), Map.class);
		System.out.println("maaaaap duree=> + " + mapDureeData.values());
		return mapDureeData;
	}

	public Map<String, String> getMapFrequence(ObjectMapper mapper, JsonNode medicTmp)
			throws JsonProcessingException, IllegalArgumentException {
		ArrayNode arrayNode = (ArrayNode) medicTmp.get("frequenceData");
		Iterator<JsonNode> itr = arrayNode.elements();
		Map<String, String> map = mapper.treeToValue(itr.next(), Map.class);
		System.out.println("maaaaap frequence=> + " + map);
		return map;
	}

}
