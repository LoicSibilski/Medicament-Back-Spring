package com.m2i.medic.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreationMedicDto {

	private String nom;
	
	private CreationDureeDto dureeDto;
	
	private CreationFrequenceDto frequenceDto;
	
}
