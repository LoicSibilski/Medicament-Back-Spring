package com.m2i.medic.dtos.frequence;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrequenceDto {
	
	private String id;

	private List<LocalDateTime> prises;


}
