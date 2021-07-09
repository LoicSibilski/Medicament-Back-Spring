package com.m2i.medic.compte.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cette classe représente un DTO pour la modification d'un mot de passe oublié sur un compte
 * @author fabien
 *
 */
@Data
@NoArgsConstructor
public class MotDePasseOublieDTO {

	private String id;
	private String motDePasse;
}
