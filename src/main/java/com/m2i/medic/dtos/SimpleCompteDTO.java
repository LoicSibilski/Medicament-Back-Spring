package com.m2i.medic.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cette classe représente un DTO d'un compte avec des attributs en moins
 * @author fabien
 *
 */
@Data
@NoArgsConstructor
public class SimpleCompteDTO {
	
	private String id;
	private String email;
	private String motDePasse;

}
