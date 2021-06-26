package com.m2i.medic.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class InfoMedic {
	
	@Id
	private String id;
	
	private String nom;
	
	//Data de la duree
	private LocalDate dateDebut;
	
	private String choixDuree;
	
	private LocalDate dateFin;
	
	private Integer nbJour;
	
	//Data de la frequence
	private Integer x;
	
	private LocalTime heureDebut;
	
	private LocalTime rappel;
	
	private LocalTime heureFin;
	
	private Boolean lundi;

	private Boolean mardi;

	private Boolean mercredi;

	private Boolean jeudi;

	private Boolean vendredi;

	private Boolean samedi;

	private Boolean dimanche;

	//Data de la liste d'heures
	
	private List<String> listeHeuresData;

	
}
