package com.m2i.medic.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.m2i.medic.models.Duree;
import com.m2i.medic.models.Frequence;
import com.m2i.medic.services.GenericService;
import com.m2i.medic.services.MedicService;
import com.m2i.medic.services.implementations.DureeServiceImpl;
import com.m2i.medic.services.implementations.FrequenceServiceImpl;
import com.m2i.medic.services.implementations.MedicServiceImpl;

@Configuration
public class ServiceConfig {

	@Bean
	public MedicService medicServiceFactory() {
		return new MedicServiceImpl();
	}
	
	@Bean
	public GenericService<Duree> dureeServiceFactory() {
		return new DureeServiceImpl();
	}
	
	@Bean
	public GenericService<Frequence> frequenceServiceFactory() {
		return new FrequenceServiceImpl();
	}
}
