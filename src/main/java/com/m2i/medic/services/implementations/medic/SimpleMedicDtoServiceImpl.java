package com.m2i.medic.services.implementations.medic;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.medic.SimpleMedicDto;
import com.m2i.medic.models.Medic;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.medic.SimpleMedicDtoService;

public class SimpleMedicDtoServiceImpl implements SimpleMedicDtoService {

	private MedicRepository medicRepository;
	private ObjectMapper mapper;

	public SimpleMedicDtoServiceImpl(MedicRepository medicRepo, ObjectMapper mapper) {
		this.medicRepository = medicRepo;
		this.mapper = mapper;
	}

	@Override
	public List<SimpleMedicDto> getAll() {
		List<Medic> medics = this.medicRepository.findAll();

		return medics.stream().map(medic -> {
			return this.mapper.convertValue(medic, SimpleMedicDto.class);
		}).collect(Collectors.toList());
	}

	@Override
	public SimpleMedicDto getById(String id) {
		Medic medic = this.medicRepository.findById(id).get();
		return mapper.convertValue(medic, SimpleMedicDto.class);
	}

	@Override
	public void deleteByID(String id) {
		if (this.medicRepository.existsById(id))
			this.medicRepository.deleteById(id);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@Override
	public void deleteAll() {
		List<Medic> liste = this.medicRepository.findAll();
		for (Medic medic : liste) {
			this.deleteByID(medic.getId());
		}
	}

}