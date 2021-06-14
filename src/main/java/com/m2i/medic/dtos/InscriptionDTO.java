package com.m2i.medic.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cette classe représente un DTO de création de compte
 * @author fabien
 *
 */
@Data
@NoArgsConstructor
public class InscriptionDTO {

	private String email;
	private String motDePasse;

}
