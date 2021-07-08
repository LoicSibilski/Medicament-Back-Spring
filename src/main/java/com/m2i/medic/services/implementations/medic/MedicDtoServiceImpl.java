package com.m2i.medic.services.implementations.medic;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.duree.DureeDto;
import com.m2i.medic.dtos.frequence.FrequenceDto;
import com.m2i.medic.dtos.medic.MedicDto;
import com.m2i.medic.models.Medic;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.medic.MedicDtoService;

public class MedicDtoServiceImpl implements MedicDtoService {

	private MedicRepository medicRepository;
	private ObjectMapper mapper;

	public MedicDtoServiceImpl(MedicRepository medicRepo, ObjectMapper mapper) {
		this.medicRepository = medicRepo;
		this.mapper = mapper;
	}

	@Override
	public List<MedicDto> getAll() {
		List<Medic> medics = this.medicRepository.findAll();
		System.out.println("mes couilles => " + medics);
		return medics.stream().map(medic -> {
			return convertMedicToDto(medic);
		}).collect(Collectors.toList());
	}

	@Override
	public MedicDto getById(String id) {
		Medic medic = this.medicRepository.findById(id).get();
		System.out.println("MEDIC => " + medic);
		return mapper.convertValue(medic, MedicDto.class);
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
	
	/**
	 * Convertis un objet Medic en un MedicDto.
	 * 
	 * @param medic : Frais comme un gardon, tous juste sortie de la base de données
	 * @return MedicDto
	 */
	private MedicDto convertMedicToDto(Medic medic) {
		MedicDto medicDto = new MedicDto();
		medicDto.setId(medic.getId());
		medicDto.setNom(medic.getNom());
		medicDto.setDureeDto(this.mapper.convertValue(medic.getDuree(), DureeDto.class));
		medicDto.setFrequenceDto(this.mapper.convertValue(medic.getFrequence(), FrequenceDto.class));
		
		return medicDto;
	}

}
