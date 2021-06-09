package com.m2i.medic.dtos;

import lombok.Data;

/**
 * Cette classe représente un DTO de création de compte
 * @author fabien
 *
 */
@Data
public class CreationNouveauCompteDTO {

	private String email;
	private String motDePasse;
	
}
