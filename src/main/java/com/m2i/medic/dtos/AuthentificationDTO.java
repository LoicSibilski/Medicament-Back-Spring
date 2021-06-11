package com.m2i.medic.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cette classe représente un DTO d'authentification d'un compte
 * @author fabien
 *
 */
@Data
@NoArgsConstructor
public class AuthentificationDTO {

	private String email;
	private String motDePasse;

}
