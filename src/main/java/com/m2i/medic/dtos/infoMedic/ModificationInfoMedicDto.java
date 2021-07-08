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
public class ModificationInfoMedicDto {
		
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

	public ModificationInfoMedicDto(CreationMedicDto creationMedicDto) {
		this.nom = creationMedicDto.getNom();
		this.dateDebut = creationMedicDto.getDureeData().getDateDebut();
		this.choixDuree = creationMedicDto.getDureeData().getChoixDuree();
		this.dateFin = creationMedicDto.getDureeData().getDateFin();
		this.nbJour = creationMedicDto.getDureeData().getNbJour();
		this.choixFrequence = creationMedicDto.getFrequenceData().getChoixFrequence();
		this.x = creationMedicDto.getFrequenceData().getX();
		this.heureDebut = creationMedicDto.getFrequenceData().getHeureDebut();
		this.rappel = creationMedicDto.getFrequenceData().getRappel();
		this.heureFin = creationMedicDto.getFrequenceData().getHeureFin();
		this.lundi = creationMedicDto.getFrequenceData().getLundi();
		this.mardi = creationMedicDto.getFrequenceData().getMardi();
		this.mercredi = creationMedicDto.getFrequenceData().getMercredi();
		this.jeudi = creationMedicDto.getFrequenceData().getJeudi();
		this.vendredi = creationMedicDto.getFrequenceData().getVendredi();
		this.samedi = creationMedicDto.getFrequenceData().getSamedi();
		this.dimanche = creationMedicDto.getFrequenceData().getDimanche();
		this.listeHeuresData = creationMedicDto.getListeHeuresData();
	}
	
	public ModificationInfoMedicDto (InfoMedicDto infoMedicDto) {
		this.nom = infoMedicDto.getNom();
		this.dateDebut = infoMedicDto.getDateDebut();
		this.choixDuree = infoMedicDto.getChoixDuree();
		this.dateFin = infoMedicDto.getDateFin();
		this.nbJour = infoMedicDto.getNbJour();
		this.choixFrequence =infoMedicDto.getChoixFrequence();
		this.x = infoMedicDto.getX();
		this.heureDebut = infoMedicDto.getHeureDebut();
		this.rappel = infoMedicDto.getRappel();
		this.heureFin = infoMedicDto.getHeureFin();
		this.lundi = infoMedicDto.getLundi();
		this.mardi = infoMedicDto.getMardi();
		this.mercredi = infoMedicDto.getMercredi();
		this.jeudi = infoMedicDto.getJeudi();
		this.vendredi = infoMedicDto.getVendredi();
		this.samedi = infoMedicDto.getSamedi();
		this.dimanche = infoMedicDto.getDimanche();
		this.listeHeuresData = infoMedicDto.getListeHeuresData();
	}

}