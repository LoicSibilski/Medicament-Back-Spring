package com.m2i.medic.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.m2i.medic.models.Medic;
import com.m2i.medic.services.GenericService;
import com.m2i.medic.services.implementations.MedicServiceImpl;

@Configuration
public class ServiceConfig {

	@Bean
	public GenericService<Medic> medicServiceFactory() {
		return new MedicServiceImpl();
	}
	
}
