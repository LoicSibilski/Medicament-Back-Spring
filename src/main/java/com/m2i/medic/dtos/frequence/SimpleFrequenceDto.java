package com.m2i.medic.dtos.frequence;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleFrequenceDto {

	private String id;
	
	List<LocalDateTime> prises;
	
}
