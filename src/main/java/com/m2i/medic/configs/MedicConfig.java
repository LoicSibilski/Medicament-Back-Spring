package com.m2i.medic.configs;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.duree.CreationDureeDto;
import com.m2i.medic.dtos.frequence.CreationFrequenceDto;
import com.m2i.medic.models.Duree;
import com.m2i.medic.models.Frequence;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.GenericCRUDService;
import com.m2i.medic.services.JsonNodeService;
import com.m2i.medic.services.implementations.medic.CreationDureeDtoServiceImpl;
import com.m2i.medic.services.implementations.medic.CreationFrequenceDtoServiceImpl;
import com.m2i.medic.services.implementations.medic.CreationMedicDtoServiceImpl;
import com.m2i.medic.services.implementations.medic.MedicDtoServiceImpl;
import com.m2i.medic.services.medic.CreationDureeDtoService;
import com.m2i.medic.services.medic.CreationFrequenceDtoService;
import com.m2i.medic.services.medic.CreationMedicDtoService;
import com.m2i.medic.services.medic.MedicDtoService;

@Configuration
public class MedicConfig {

	@Bean
	public MedicDtoService medicServiceFactory(MedicRepository medicRepo, CreationMedicDtoService medicDtoService,
			ObjectMapper mapper) {
		return new MedicDtoServiceImpl(medicRepo, medicDtoService, mapper);
	}

	@Bean
	public CreationMedicDtoService medicDtoServiceFactory(JsonNodeService jsonNode, CreationFrequenceDtoService frequenceDto,
			CreationDureeDtoService dureeDto) {
		return new CreationMedicDtoServiceImpl(jsonNode, frequenceDto, dureeDto);
	}

	@Bean
	public CreationDureeDtoServiceImpl dureeDtoServiceFactory(DateTimeFormatter dateTimeFormatter) {
		return new CreationDureeDtoServiceImpl(dateTimeFormatter);
	}

	@Bean
	public CreationFrequenceDtoServiceImpl frequenceDtoServiceFactory() {
		return new CreationFrequenceDtoServiceImpl();
	}

}
