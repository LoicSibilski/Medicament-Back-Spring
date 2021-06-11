package com.m2i.medic.dtos;

import lombok.Data;

/**
 * Cette classe représente un DTO d'authentification d'un compte
 * @author fabien
 *
 */
@Data
public class AuthentificationDTO {

	private String email;
	private String motDePasse;

}
