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
public class InscriptionCompteDTO {
	
	private String email;
	private String motDePasse; 
}
