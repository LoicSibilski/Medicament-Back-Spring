package com.m2i.medic.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicTmp {
	
	@JsonProperty("nom")
	private JsonNode nom;
	
	@JsonProperty("dureeData")
	private JsonNode dureeData;
	
	@JsonProperty("frequenceData")
	private JsonNode frequenceData;
}
