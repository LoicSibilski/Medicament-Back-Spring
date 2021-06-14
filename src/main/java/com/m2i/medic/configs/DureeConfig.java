package com.m2i.medic.configs;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.repositories.DureeRepository;
import com.m2i.medic.services.duree.ModificationDureeService;
import com.m2i.medic.services.implementations.duree.JsonDureeDtoServiceImpl;
import com.m2i.medic.services.implementations.duree.ModificationDureeDtoServiceImpl;
import com.m2i.medic.services.implementations.duree.SimpleDureeDtoServiceImpl;

@Configuration
public class DureeConfig {
	
	@Bean
	public JsonDureeDtoServiceImpl jsonDureeDtoServiceFactory(DateTimeFormatter dateTimeFormatter,
			ModificationDureeService modifDureeService, ObjectMapper mapper) {
		return new JsonDureeDtoServiceImpl(dateTimeFormatter, modifDureeService, mapper);
	}
	
	@Bean
	public ModificationDureeDtoServiceImpl modifDureeDtoServiceFactory(DureeRepository dureeRepo,
			ObjectMapper mapper) {
		return new ModificationDureeDtoServiceImpl(dureeRepo, mapper);
	}
	
	@Bean
	public SimpleDureeDtoServiceImpl simpleDureeDtoServiceFactory(DureeRepository dureeRepo,
			ObjectMapper mapper){
		return new SimpleDureeDtoServiceImpl(dureeRepo, mapper);
	}

}
