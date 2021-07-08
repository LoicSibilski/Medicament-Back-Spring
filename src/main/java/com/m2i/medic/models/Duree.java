package com.m2i.medic.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Duree {

	@Id
	private String id;

	private LocalDateTime dateDebut;

	private LocalDateTime dateFin;

}
