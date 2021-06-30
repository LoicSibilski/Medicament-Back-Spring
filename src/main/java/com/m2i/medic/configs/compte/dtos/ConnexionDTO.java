package com.m2i.medic.configs.compte.dtos;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cette classe représente un DTO d'une connexion à un compte
 * @author fabien
 *
 */
@Data
@NoArgsConstructor
public class ConnexionDTO {

	private String pseudoOrEmail;
	private String motDePasse;
	
}