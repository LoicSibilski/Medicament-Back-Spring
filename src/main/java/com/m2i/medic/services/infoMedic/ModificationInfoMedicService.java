package com.m2i.medic.services.infoMedic;

import com.m2i.medic.dtos.infoMedic.InfoMedicDto;
import com.m2i.medic.dtos.infoMedic.ModificationInfoMedicDto;

public interface ModificationInfoMedicService {
	
	public InfoMedicDto save(ModificationInfoMedicDto modificationInfoMedicDto);

	public InfoMedicDto update(InfoMedicDto InfoMedicDto);

	
}
