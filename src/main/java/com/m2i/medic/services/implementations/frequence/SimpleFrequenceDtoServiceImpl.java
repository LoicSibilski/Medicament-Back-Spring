package com.m2i.medic.services.implementations.frequence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.frequence.SimpleFrequenceDto;
import com.m2i.medic.models.Frequence;
import com.m2i.medic.repositories.FrequenceRepository;
import com.m2i.medic.services.frequence.SimpleFrequenceDtoService;

public class SimpleFrequenceDtoServiceImpl implements SimpleFrequenceDtoService {

	private FrequenceRepository frequenceRepository;
	private ObjectMapper mapper;

	public SimpleFrequenceDtoServiceImpl(FrequenceRepository medicRepo, ObjectMapper mapper) {
		this.frequenceRepository = medicRepo;
		this.mapper = mapper;
	}

	@Override
	public List<SimpleFrequenceDto> getAll() {
		List<Frequence> medics = this.frequenceRepository.findAll();

		return medics.stream().map(medic -> {
			return this.mapper.convertValue(medic, SimpleFrequenceDto.class);
		}).collect(Collectors.toList());
	}

	@Override
	public SimpleFrequenceDto getById(String id) {
		Frequence medic = this.frequenceRepository.findById(id).get();
		return mapper.convertValue(medic, SimpleFrequenceDto.class);
	}

	@Override
	public void deleteByID(String id) {
		if (this.frequenceRepository.existsById(id))
			this.frequenceRepository.deleteById(id);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@Override
	public void deleteAll() {
		List<Frequence> liste = this.frequenceRepository.findAll();
		for (Frequence medic : liste) {
			this.deleteByID(medic.getId());
		}
	}

}
