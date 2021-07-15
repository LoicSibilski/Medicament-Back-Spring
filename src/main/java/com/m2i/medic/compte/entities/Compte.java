package com.m2i.medic.compte.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe qui représente un modèle de compte
 * @author fabien
 *
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {
	
	@Id
	private String id;
	private String email;
	private String motDePasse;
	private boolean etat;
	private LocalDateTime dateCreation;
	private LocalDateTime dateConnexion;	
	private LocalDateTime dateMisJour;
}
