package com.m2i.medic.dtos.infoMedic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.m2i.medic.dtos.duree.CreationDureeDto;
import com.m2i.medic.dtos.frequence.CreationFrequenceDto;
import com.m2i.medic.dtos.medic.CreationMedicDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoMedicDto {
	
	private String id;
	
	private String nom;
	
	//Data de la duree
	private LocalDate dateDebut;
	
	private String choixDuree;
	
	private LocalDate dateFin;
	
	private Integer nbJour;
	
	//Data de la frequence
	
	private String choixFrequence;
	
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
