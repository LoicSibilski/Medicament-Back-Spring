package com.m2i.medic.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.m2i.medic.dtos.AssistantOuAssisteDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Utilisateur {
	
	@Id
	private String id;
	private Object compte;
	private String nom;
	private String prenom;
	private LocalDateTime dateNaissance;
	private List<AssistantOuAssisteDTO> assistants;
	private List<AssistantOuAssisteDTO> assistes;
	
}
