package com.m2i.medic.services.implementations.duree;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.duree.SimpleDureeDto;
import com.m2i.medic.models.Duree;
import com.m2i.medic.repositories.DureeRepository;
import com.m2i.medic.services.duree.SimpleDureeDtoService;

public class SimpleDureeDtoServiceImpl implements SimpleDureeDtoService {

	private ObjectMapper mapper;
	private DureeRepository dureeRepo;

	public SimpleDureeDtoServiceImpl(DureeRepository dureeRepo, ObjectMapper mapper) {
		this.dureeRepo = dureeRepo;
		this.mapper = mapper;
	}
	
	@Override
	public List<SimpleDureeDto> getAll() {
		List<Duree> durees = this.dureeRepo.findAll();

		return durees.stream().map(duree -> {
			return this.mapper.convertValue(duree, SimpleDureeDto.class);
		}).collect(Collectors.toList());
	}

	@Override
	public SimpleDureeDto getById(String id) {
		Duree duree = this.dureeRepo.findById(id).get();
		return mapper.convertValue(duree, SimpleDureeDto.class);
	}
	@Override
	public void deleteByID(String id) {
		if (this.dureeRepo.existsById(id))
			this.dureeRepo.deleteById(id);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@Override
	public void deleteAll() {
		List<Duree> liste = this.dureeRepo.findAll();
		for (Duree duree : liste) {
			this.deleteByID(duree.getId());
		}
	}
}
