package com.m2i.medic.services.medic;

import com.m2i.medic.dtos.medic.CreationMedicDto;
import com.m2i.medic.dtos.medic.MedicDto;

public interface CreationMedicDtoService {
	
	/**
	 * La methode permet de creer un MedicDto à partir du CréationMedicDto fournis par le FRONT
	 * 
	 * @param creationMedicDto : DTO contenant les informations fournis par l'utilisateur depuis le FRONT
	 * 
	 * @return MedicDto : DTO contenant les informations après le traitement par le BACK 
	 */
	public MedicDto convertCreationMedicDtoToMedicDto(CreationMedicDto creationMedicDto);
	
}
