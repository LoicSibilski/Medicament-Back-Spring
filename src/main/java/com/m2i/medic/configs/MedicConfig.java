package com.m2i.medic.configs;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.duree.SimpleDureeDto;
import com.m2i.medic.dtos.frequence.SimpleFrequenceDto;
import com.m2i.medic.models.Duree;
import com.m2i.medic.models.Frequence;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.GenericCRUDService;
import com.m2i.medic.services.JsonNodeService;
import com.m2i.medic.services.duree.SimpleDureeDtoService;
import com.m2i.medic.services.frequence.SimpleFrequenceDtoService;
import com.m2i.medic.services.implementations.medic.SimpleMedicDtoServiceImpl;
import com.m2i.medic.services.implementations.duree.SimpleDureeDtoServiceImpl;
import com.m2i.medic.services.implementations.frequence.SimpleFrequenceDtoServiceImpl;
import com.m2i.medic.services.implementations.medic.MedicDtoServiceImpl;
import com.m2i.medic.services.medic.SimpleMedicDtoService;
import com.m2i.medic.services.medic.MedicDtoService;

@Configuration
public class MedicConfig {

	@Bean
	public MedicDtoService medicServiceFactory(MedicRepository medicRepo, SimpleMedicDtoService medicDtoService,
			ObjectMapper mapper) {
		return new MedicDtoServiceImpl(medicRepo, medicDtoService, mapper);
	}

	@Bean
	public SimpleMedicDtoService medicDtoServiceFactory(JsonNodeService jsonNode, SimpleFrequenceDtoService frequenceDto,
			SimpleDureeDtoService dureeDto) {
		return new SimpleMedicDtoServiceImpl(jsonNode, frequenceDto, dureeDto);
	}

	@Bean
	public SimpleDureeDtoServiceImpl dureeDtoServiceFactory(DateTimeFormatter dateTimeFormatter) {
		return new SimpleDureeDtoServiceImpl(dateTimeFormatter);
	}

	@Bean
	public SimpleFrequenceDtoServiceImpl frequenceDtoServiceFactory() {
		return new SimpleFrequenceDtoServiceImpl();
	}

}
