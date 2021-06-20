package com.m2i.medic.services.medic;

import com.m2i.medic.dtos.medic.CreationMedicDto;
import com.m2i.medic.dtos.medic.MedicDto;

public interface ModificationMedicService {
	
	public MedicDto save(CreationMedicDto creationMedicDto);

	public MedicDto update(CreationMedicDto creationMedicDto);

	
}
