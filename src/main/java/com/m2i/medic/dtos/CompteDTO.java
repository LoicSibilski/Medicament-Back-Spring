package com.m2i.medic.dtos;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cette classe représente un DTO d'un compte
 * @author fabien
 *
 */
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
