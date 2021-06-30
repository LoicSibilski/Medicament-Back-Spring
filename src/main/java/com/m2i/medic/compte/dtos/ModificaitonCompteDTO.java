package com.m2i.medic.compte.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cette classe représente un DTO de modificaiton d'un compte
 * @author fabien
 *
 */
@Data
@NoArgsConstructor
public class ModificaitonCompteDTO {

	private String id;
	private String email;
	private String pseudo;
	private String motDePasse;
	private Character type;
}
