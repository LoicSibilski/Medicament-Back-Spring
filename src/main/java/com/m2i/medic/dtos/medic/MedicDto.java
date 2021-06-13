package com.m2i.medic.dtos.medic;

import com.m2i.medic.dtos.duree.SimpleDureeDto;
import com.m2i.medic.dtos.frequence.SimpleFrequenceDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicDto {
	
	private String id;
	
	private String nom;
	
	private SimpleDureeDto dureeDto;
	
	private SimpleFrequenceDto frequenceDto;

}
