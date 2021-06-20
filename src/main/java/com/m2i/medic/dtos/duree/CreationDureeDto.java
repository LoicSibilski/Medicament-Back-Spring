package com.m2i.medic.dtos.duree;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreationDureeDto {
	
	private LocalDate dateDebut;
	
	private String choixDuree;
	
	private LocalDate dateFin;
	
	private Integer nbJour;

}
