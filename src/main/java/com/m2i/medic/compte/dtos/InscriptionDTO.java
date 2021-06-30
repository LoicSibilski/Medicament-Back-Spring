package com.m2i.medic.compte.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cette classe représente un DTO d'inscription à un compte
 * @author fabien
 *
 */
@Data
@NoArgsConstructor
public class InscriptionDTO {
	
	private String email;
	private String pseudo;
	private String motDePasse; 
	private Character type;
}
