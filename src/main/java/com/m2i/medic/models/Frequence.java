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
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Frequence {
	
	@Id
	private String id;
	
	private List<LocalDate> jours;
	
	private List<LocalTime> horaires;

}
