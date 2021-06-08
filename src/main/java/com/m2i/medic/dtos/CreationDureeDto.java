package com.m2i.medic.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreationDureeDto {

	private int nbJour;
	
	private LocalDateTime dateDebut;
	
	private LocalDateTime dateFin;
	
}
