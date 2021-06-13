package com.m2i.medic.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.implementations.medic.JsonMedicDtoServiceImpl;
import com.m2i.medic.services.implementations.medic.ModificationMedicServiceImpl;
import com.m2i.medic.services.implementations.medic.SimpleMedicDtoServiceImpl;
import com.m2i.medic.services.json.JsonNodeService;
import com.m2i.medic.services.duree.JsonDureeDtoService;
import com.m2i.medic.services.frequence.JsonFrequenceDtoService;
import com.m2i.medic.services.medic.JsonMedicDtoService;

@Configuration
public class MedicConfig {

	@Bean
	public JsonMedicDtoServiceImpl jsonMedicDtoServiceFactory(JsonNodeService jsonNodeService,
			JsonFrequenceDtoService jsonFrequenceService, JsonDureeDtoService jsonDureeService) {
		return new JsonMedicDtoServiceImpl(jsonNodeService, jsonFrequenceService, jsonDureeService);
	}

	@Bean
	public ModificationMedicServiceImpl modifMedicDtoServiceFactory(ObjectMapper mapper, MedicRepository medicRepo,
			JsonMedicDtoService jsonMedicService) {
		return new ModificationMedicServiceImpl(mapper, medicRepo, jsonMedicService);
	}

	@Bean
	public SimpleMedicDtoServiceImpl simpleMedicDtoServiceFactory(ObjectMapper mapper, MedicRepository medicRepo) {
		return new SimpleMedicDtoServiceImpl(medicRepo, mapper);
	}

}
