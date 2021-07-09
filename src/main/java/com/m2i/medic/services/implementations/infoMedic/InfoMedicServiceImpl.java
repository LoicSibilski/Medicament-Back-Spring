package com.m2i.medic.services.implementations.infoMedic;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.infoMedic.InfoMedicDto;
import com.m2i.medic.dtos.medic.MedicDto;
import com.m2i.medic.models.InfoMedic;
import com.m2i.medic.models.Medic;
import com.m2i.medic.repositories.InfoMedicRepository;
import com.m2i.medic.services.infoMedic.InfoMedicDtoService;

public class InfoMedicServiceImpl implements InfoMedicDtoService {

	private InfoMedicRepository infoMedicRepository;
	private ObjectMapper mapper;

	public InfoMedicServiceImpl(InfoMedicRepository infoMedicRepository, ObjectMapper mapper) {
		super();
		this.infoMedicRepository = infoMedicRepository;
		this.mapper = mapper;
	}

	@Override
	public List<InfoMedicDto> getAll() {
		List<InfoMedic> infoMedics = this.infoMedicRepository.findAll();
		return infoMedics.stream().map(medic -> {
			return this.mapper.convertValue(medic, InfoMedicDto.class);
		}).collect(Collectors.toList());
	}

	@Override
	public InfoMedicDto getById(String id) {
		InfoMedic medic = this.infoMedicRepository.findById(id).get();
		System.out.println("MEDICINOGETID => " + medic.getId());
		return mapper.convertValue(medic, InfoMedicDto.class);
	}

	@Override
	public void deleteByID(String id) {
		if (this.infoMedicRepository.existsById(id))
			this.infoMedicRepository.deleteById(id);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@Override
	public void deleteAll() {
		this.infoMedicRepository.deleteAll();
	}
}