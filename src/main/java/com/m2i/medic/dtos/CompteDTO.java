package com.m2i.medic.dtos;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompteDTO {

	private String id;
	private String email;
	private String motDePasse;
	private Boolean etat;
	private LocalDateTime dateCreation;
	private LocalDateTime dateMisJour;
	
}
