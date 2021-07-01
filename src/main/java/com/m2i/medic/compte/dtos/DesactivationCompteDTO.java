package com.m2i.medic.compte.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cette classe représente un DTO de la desactivation d'un compte
 * @author fabien
 *
 */
@Data
@NoArgsConstructor
public class DesactivationCompteDTO {

	private String id;
	private boolean etat;
}
