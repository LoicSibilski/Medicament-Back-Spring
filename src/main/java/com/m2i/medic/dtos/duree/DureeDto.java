package com.m2i.medic.dtos.duree;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DureeDto {

	private String id;

	private LocalDateTime dateDebut;
	
	private LocalDateTime dateFin;
}
