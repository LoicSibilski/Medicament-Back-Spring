package com.m2i.medic.compte.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cette classe représente un DTO de modification d'un compte
 * @author fabien
 *
 */
@Data
@NoArgsConstructor
public class ModificationCompteDTO {

	private String id;
	private String email;
	private String motDePasse;
}
