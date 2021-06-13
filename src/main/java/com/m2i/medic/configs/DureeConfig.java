package com.m2i.medic.configs;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.m2i.medic.services.implementations.duree.SimpleDureeDtoServiceImpl;

@Configuration
public class DureeConfig {
	
	@Bean
	public SimpleDureeDtoServiceImpl dureeDtoServiceFactory(DateTimeFormatter dateTimeFormatter) {
		return new SimpleDureeDtoServiceImpl(dateTimeFormatter);
	}

}
