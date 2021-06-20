package com.m2i.medic.dtos.frequence;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreationFrequenceDto {

	private String choixFrequence;
	
	private Integer x;
	
	private LocalTime heureDebut;
	
	private LocalTime rappel;
	
	private LocalTime heureFin;
	
	private Boolean lundi;

	private Boolean mardi;

	private Boolean mercredi;

	private Boolean jeudi;

	private Boolean vendredi;

	private Boolean samedi;

	private Boolean dimanche;

	
}
