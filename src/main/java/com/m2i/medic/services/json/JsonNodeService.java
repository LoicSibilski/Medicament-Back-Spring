package com.m2i.medic.services.json;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public interface JsonNodeService {
	
	/**
	 * methode permettant de recuperer une valuer d'un objet json avec sa clé.
	 * @param jsonNode :jsonNode: Le JSON envoye par l'utilisateur
	 * @param key : String = Cle de la valeur voulant etre retournee
	 * @return La valeur contenue dans le l'objet json "jsonNode" avec la cle "key" 
	 */
	public String getSingleValueFromJsonNode(JsonNode jsonNode, String key);

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
	public Map<String, Object> getMapFromJsonNodeWithKey(JsonNode medicTmp, String key)
			throws JsonProcessingException, IllegalArgumentException ;
	
	/**
	 * La methode permet de renvoye une liste à partir d'un objet JSON.
	 *
	 *	{ "listeHeures":{"heure":"13:05", "heure":"45.63" }}
	 *	jsonNode = { "key": "value":"13.05 ....}}
	 * @param key : cle a partir de laquelle on va recuperer toutes les valeurs
	 * @param value : 
	 * @param jsonNode: Le JSON envoye par l'utilisateur
	 * @return List<String>: La liste de toutes les valeurs contenue dans le jsonNode
	 *         => ["13:05","13:05" ... ]
	 * @throws JsonProcessingException
	 * @throws IllegalArgumentException
	 */
	public List<LocalTime> getListFromJsonNodeWithKey(JsonNode jsonNode, String key, String value)
			throws JsonProcessingException, IllegalArgumentException;
	
}
