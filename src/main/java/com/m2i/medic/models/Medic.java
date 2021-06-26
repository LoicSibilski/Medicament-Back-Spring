package com.m2i.medic.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Medic {

	@Id
	private String id;
	
	private String nom;
	
	@DBRef
	private Duree duree;
	
	@DBRef
	private Frequence frequence;
	
	@DBRef
	private InfoMedic infoMedic;
	
	
}
