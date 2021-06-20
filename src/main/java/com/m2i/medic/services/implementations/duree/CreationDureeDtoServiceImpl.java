package com.m2i.medic.services.implementations.duree;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.duree.CreationDureeDto;
import com.m2i.medic.dtos.duree.DureeDto;
import com.m2i.medic.services.duree.CreationDureeDtoService;
import com.m2i.medic.services.duree.ModificationDureeService;

public class CreationDureeDtoServiceImpl implements CreationDureeDtoService {
	
	private ObjectMapper mapper;
	private DateTimeFormatter dateFormatter;
	private ModificationDureeService dureeDtoService;

	
	
	public CreationDureeDtoServiceImpl(ObjectMapper mapper, DateTimeFormatter dateFormatter,
			ModificationDureeService dureeDtoService) {
		this.mapper = mapper;
		this.dateFormatter = dateFormatter;
		this.dureeDtoService = dureeDtoService;
	}


	@Override
	public DureeDto convertCreationDureeDtoToDureeDto(CreationDureeDto creationDureeDto) {
		DureeDto dto = new DureeDto();

		initialisationDateDebutPourDureeDto(creationDureeDto, dto);
		initialisationDateDeFinPourDureeDto(creationDureeDto, dto);

		DureeDto dr = this.mapper.convertValue(dto, DureeDto.class);
		DureeDto dureeDto = this.mapper.convertValue(this.dureeDtoService.save(dr), DureeDto.class);
		return dureeDto;
	}

	/**
	 * La methode initialise la date de debut du dto CreationDureeDto
	 * 
	 * @param creationDureeDto : DTO contenant les informations fournis par
	 *                         l'utilisateur depuis le FRONT
	 * @param dureeDto         : Dto à initialiser.
	 */
	private void initialisationDateDebutPourDureeDto(CreationDureeDto creationDureeDto, DureeDto dureeDto) {
		LocalDate date = LocalDate.parse(creationDureeDto.getDateDebut().toString(), this.dateFormatter);
		LocalDateTime dateDebut = date.atStartOfDay();
		dureeDto.setDateDebut(dateDebut);
	}

	/**
	 * Initialise la date de fin du dureeDto en fonctions des informations de
	 * l'utilisateur.
	 * 
	 * @param creationDureeDto : DTO contenant les informations fournis par
	 *                         l'utilisateur depuis le FRONT
	 * @param dureeDto
	 */
	private void initialisationDateDeFinPourDureeDto(CreationDureeDto creationDureeDto, DureeDto dureeDto) {
		String choix = creationDureeDto.getChoixDuree();
		if (choix.equals("Pas de fin")) {
			dureeDto.setDateFin(dureeDto.getDateDebut().plusYears(1));

		} else if (choix.equals("Pendant X jours") && creationDureeDto.getNbJour() != null) {
			Integer nbJour = (Integer) creationDureeDto.getNbJour();
			dureeDto.setDateFin(dureeDto.getDateDebut().plusDays(nbJour));

		} else if (choix.equals("Jusque date") && creationDureeDto.getDateFin() != null) {
			LocalDate date = LocalDate.parse(creationDureeDto.getDateFin().toString(), this.dateFormatter);
			dureeDto.setDateFin(date.atStartOfDay());
		}
	}

}
