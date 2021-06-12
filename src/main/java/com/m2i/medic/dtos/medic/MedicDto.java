package com.m2i.medic.dtos.medic;

import com.m2i.medic.dtos.duree.CreationDureeDto;
import com.m2i.medic.dtos.frequence.CreationFrequenceDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicDto {
	
	private String id;
	
	private String nom;
	
	private CreationDureeDto dureeDto;
	
	private CreationFrequenceDto frequenceDto;

}
