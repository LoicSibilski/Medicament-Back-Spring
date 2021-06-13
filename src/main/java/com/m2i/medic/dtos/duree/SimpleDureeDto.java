package com.m2i.medic.dtos.duree;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleDureeDto {
	
	private String id;

	private LocalDateTime dateDebut;

	private LocalDateTime dateFin;

}
