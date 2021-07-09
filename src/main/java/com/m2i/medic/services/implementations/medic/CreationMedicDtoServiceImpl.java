package com.m2i.medic.services.implementations.medic;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.m2i.medic.dtos.duree.DureeDto;
import com.m2i.medic.dtos.frequence.FrequenceDto;
import com.m2i.medic.dtos.infoMedic.InfoMedicDto;
import com.m2i.medic.dtos.infoMedic.ModificationInfoMedicDto;
import com.m2i.medic.dtos.medic.CreationMedicDto;
import com.m2i.medic.dtos.medic.MedicDto;
import com.m2i.medic.services.duree.CreationDureeDtoService;
import com.m2i.medic.services.frequence.CreationFrequenceDtoService;
import com.m2i.medic.services.infoMedic.ModificationInfoMedicService;
import com.m2i.medic.services.medic.CreationMedicDtoService;

public class CreationMedicDtoServiceImpl implements CreationMedicDtoService {

	private CreationDureeDtoService creationDureeDtoService;
	private CreationFrequenceDtoService creationFrequenceDtoService;
	private ModificationInfoMedicService modificationInfoMedicService;

	public CreationMedicDtoServiceImpl(CreationDureeDtoService creationDureeDtoService,
			CreationFrequenceDtoService creationFrequenceDtoService,
			ModificationInfoMedicService modificationInfoMedicService) {
		super();
		this.creationDureeDtoService = creationDureeDtoService;
		this.creationFrequenceDtoService = creationFrequenceDtoService;
		this.modificationInfoMedicService = modificationInfoMedicService;
	}

	@Override
	public MedicDto convertCreationMedicDtoToMedicDto(CreationMedicDto creationMedicDto) {
		System.out.println("'''''''''createMedicDtoFromMaps''''");
		System.out.println("CreationDureeDTo =>" + creationMedicDto.getDureeData());
		System.out.println("CreationDureeDTo =>" + creationMedicDto.getFrequenceData());

		DureeDto dureeDto = this.creationDureeDtoService
				.convertCreationDureeDtoToDureeDto(creationMedicDto.getDureeData());

		List<LocalTime> listeHeures = convertListHeuresStringToListHeureLocalTime(
				creationMedicDto.getListeHeuresData());

		FrequenceDto frequenceDto = this.creationFrequenceDtoService
				.convertCreationFrequenceDtoToFrequenceDto(creationMedicDto.getFrequenceData(), dureeDto, listeHeures);

		ModificationInfoMedicDto modifInfoMedicDto = new ModificationInfoMedicDto(creationMedicDto);

		InfoMedicDto infoMedicDto =  this.modificationInfoMedicService.save(modifInfoMedicDto);
		System.out.println("infoMedicDtp => " + infoMedicDto);
		MedicDto medicDto = new MedicDto();
		medicDto.setNom(creationMedicDto.getNom());
		medicDto.setDureeDto(dureeDto);
		medicDto.setFrequenceDto(frequenceDto);
		medicDto.setInfoMedicDto(infoMedicDto);
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''");

		return medicDto;
	}

	/**
	 * La methode permet de convertir une liste de String en une liste de
	 * LocalDateTime
	 * 
	 * @param listeHeures : liste des dates en String sous le format : 2021-07-09T10:51:41.385+02:00
	 *                    ....
	 * @return la liste des dates sous format LocalDateTime.
	 */
	private List<LocalTime> convertListHeuresStringToListHeureLocalTime(List<String> listeHeures) {
		if (listeHeures == null)
			return null;
		else {
			List<LocalTime> listLocalTime = new ArrayList<>();
			Integer heure;
			Integer minute;
			for (String str : listeHeures) {
				System.out.println(" str => " + str);
				System.out.println(" str => " + str.substring(0,2));
				System.out.println(" str => " + str.substring(3,5));
				heure = Integer.parseInt(str.substring(0,2));
				minute = Integer.parseInt(str.substring(3,5));
				LocalTime tmp = LocalTime.of(heure, minute);
				listLocalTime.add(tmp);
			}

			return listLocalTime;
		}

	}

}
