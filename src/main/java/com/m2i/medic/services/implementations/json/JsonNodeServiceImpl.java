package com.m2i.medic.services.implementations.json;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.m2i.medic.services.json.JsonNodeService;

public class JsonNodeServiceImpl implements JsonNodeService {

	private ObjectMapper mapper;

	public JsonNodeServiceImpl(ObjectMapper mapperParam) {
		this.mapper = mapperParam;
	}

	public String getSingleValueFromJsonNode(JsonNode jsonNode, String key) {
		return jsonNode.get(key).toString();
	}

	public Map<String, Object> getMapFromJsonNodeWithKey(JsonNode medicTmp, String key)
			throws JsonProcessingException, IllegalArgumentException {
		ArrayNode arrayNodeDureeData = (ArrayNode) medicTmp.get(key);
		Iterator<JsonNode> itrDureeData = arrayNodeDureeData.elements();
		Map<String, Object> mapDureeData = this.mapper.treeToValue(itrDureeData.next(), Map.class);
		return mapDureeData;
	}

	public List<LocalTime> getListFromJsonNodeWithKey(JsonNode jsonNode, String key, String value)
			throws JsonProcessingException, IllegalArgumentException {

		ArrayNode arrayNode = (ArrayNode) jsonNode.get(key);
		Iterator<JsonNode> itrHeures = arrayNode.elements();
		List<String> listeHeures = new ArrayList<>();
		while (itrHeures.hasNext()) {
			listeHeures.add(itrHeures.next().get(value).toString());
		}

		return convertListHeuresStringToListHeureLocalTime(listeHeures);
	}

	
	/**
	 * La methode permet de convertir une liste de String en une liste de LocalDateTime
	 * @param listeHeures : liste des dates en String sous le format : "27:05", "14:07" ....
	 * @return la liste des dates sous format LocalDateTime.
	 */
	private List<LocalTime> convertListHeuresStringToListHeureLocalTime(List<String> listeHeures) {
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

}
