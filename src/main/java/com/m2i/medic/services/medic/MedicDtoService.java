package com.m2i.medic.services.medic;

import java.util.List;

import com.m2i.medic.dtos.infoMedic.InfoMedicDto;
import com.m2i.medic.dtos.medic.MedicDto;
import com.m2i.medic.services.generic.GenericSimpleCRUDService;

public interface MedicDtoService extends GenericSimpleCRUDService<MedicDto>{

	/**
	 * La méthode permet de récuperer touts les informations d'un medicament.
	 * @param id
	 * @return
	 */
	public InfoMedicDto getInformationById(String id);

}
