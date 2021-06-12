package com.m2i.medic.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.services.JsonNodeService;
import com.m2i.medic.services.implementations.JsonNodeServiceImpl;

@Configuration
public class JsonConfig {

	@Bean
	public JsonNodeService jsonServiceFactory(ObjectMapper mapper) {
		return new JsonNodeServiceImpl(mapper);
	}

}
