package com.m2i.medic.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.m2i.medic.services.implementations.frequence.SimpleFrequenceDtoServiceImpl;

@Configuration
public class FrequenceConfig {

	
	@Bean
	public SimpleFrequenceDtoServiceImpl frequenceDtoServiceFactory() {
		return new SimpleFrequenceDtoServiceImpl();
	}
}
