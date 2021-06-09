package com.m2i.medic.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

/**
 * Classe qui représente un modèle de compte
 * @author fabien
 *
 */
@Document
@NoArgsConstructor
public class Compte {
	
	@Id
	private String id;
	private String email;
	private String motDePasse; // ajouter un chiffrement
	private Boolean etat;
	private LocalDateTime dateCreation;
	private LocalDateTime dateMisJour;
	
	/**
	 * Cette accesseur permet de récupérer l'id d'un compte
	 * @return Long
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Ce mutateur permet de modifier l'id d'un compte
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Cette accesseur permet de récupérer l'email d'un compte
	 * @return String
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Ce mutateur permet de modifier l'email d'un compte
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Cette accesseur permet de récupérer l'email d'un compte
	 * @return String
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	
	/**
	 * Ce mutateur permet de modifier le mot de passe d'un compte
	 * @param motDePasse
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	/**
	 * Cette accesseur permet de récupérer la date de création d'un compte
	 * @return LocalDateTime
	 */
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}
	
	/**
	 * Ce mutateur permet de modifier la date de création d'un compte
	 * @param dateCreation
	 */
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	/**
	 * Cette accesseur permet de récupérer la date de mise à jour d'un compte
	 * @return LocalDateTime
	 */
	public LocalDateTime getDateMisJour() {
		return dateMisJour;
	}
	
	/**
	 * Ce mutateur permet de modifier la date de mise à jour d'un compte
	 * @param dateMisJour
	 */
	public void setDateMisJour(LocalDateTime dateMisJour) {
		this.dateMisJour = dateMisJour;
	}

	/**
	 * Cette accesseur permet de récupérer l'état d'un compte
	 * @return Boolean
	 */
	public Boolean getEtat() {
		return etat;
	}

	/**
	 * Ce mutateur permet de modifier l'état d'un compte
	 * @param etat
	 */
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	

}
