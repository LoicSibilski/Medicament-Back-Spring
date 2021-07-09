package com.m2i.medic.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.m2i.medic.compte.entities.Compte;
import com.m2i.medic.dtos.AssistantOuAssisteDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document
public class Utilisateur {
	@Id
	private String id;
	private String compteId;
	private String nom;
	private String prenom;
	private LocalDateTime dateNaissance;
	private List<AssistantOuAssisteDTO> assistants;
}
