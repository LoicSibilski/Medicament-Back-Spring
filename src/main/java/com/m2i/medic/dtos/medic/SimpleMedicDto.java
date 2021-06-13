package com.m2i.medic.dtos.medic;

import com.m2i.medic.dtos.duree.DureeDto;
import com.m2i.medic.dtos.duree.SimpleDureeDto;
import com.m2i.medic.dtos.frequence.FrequenceDto;
import com.m2i.medic.dtos.frequence.SimpleFrequenceDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleMedicDto {

	private String nom;
	
	private DureeDto dureeDto;
	
	private FrequenceDto frequenceDto;
	
}
