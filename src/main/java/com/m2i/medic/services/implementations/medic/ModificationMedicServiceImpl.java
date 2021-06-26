package com.m2i.medic.services.implementations.medic;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.medic.CreationMedicDto;
import com.m2i.medic.dtos.medic.MedicDto;
import com.m2i.medic.models.Duree;
import com.m2i.medic.models.Frequence;
import com.m2i.medic.models.Medic;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.medic.CreationMedicDtoService;
import com.m2i.medic.services.medic.ModificationMedicService;

public class ModificationMedicServiceImpl implements ModificationMedicService {

	private ObjectMapper mapper;
	private MedicRepository medicRepository;
	private CreationMedicDtoService creationMedicService;

	public ModificationMedicServiceImpl(ObjectMapper mapper, MedicRepository medicRepository,
			CreationMedicDtoService creationMedicService) {
		this.mapper = mapper;
		this.medicRepository = medicRepository;
		this.creationMedicService = creationMedicService;
	}

	@Override
	public MedicDto save(CreationMedicDto creationMedicDto) {
		MedicDto medicDto = this.creationMedicService.convertCreationMedicDtoToMedicDto(creationMedicDto);
		Medic entity = this.convertMedicFromDto(medicDto);
		Medic result = this.medicRepository.save(entity);
		return this.mapper.convertValue(result, MedicDto.class);
	}

	@Override
	public MedicDto update(CreationMedicDto creationMedicDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Medic convertMedicFromDto(MedicDto dto) {
		Medic med = new Medic();
		med.setNom(dto.getNom());
		med.setDuree(this.mapper.convertValue(dto.getDureeDto(), Duree.class));
		med.setFrequence(this.mapper.convertValue(dto.getFrequenceDto(), Frequence.class));
		return med;
	}

}
