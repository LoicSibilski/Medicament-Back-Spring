package com.m2i.medic.dtos.medic;

import com.m2i.medic.dtos.duree.DureeDto;
import com.m2i.medic.dtos.frequence.FrequenceDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicDto {
	
	private String id;
	
	private String nom;
	
	private DureeDto dureeDto;
	
	private FrequenceDto frequenceDto;

}
