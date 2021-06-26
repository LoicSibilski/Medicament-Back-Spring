package com.m2i.medic.services.implementations.infoMedic;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.infoMedic.InfoMedicDto;
import com.m2i.medic.dtos.infoMedic.ModificationInfoMedicDto;
import com.m2i.medic.models.InfoMedic;
import com.m2i.medic.repositories.InfoMedicRepository;
import com.m2i.medic.services.infoMedic.ModificationInfoMedicService;

class ModificationInfoMedicServiceImplTest {

	@Mock
	private InfoMedicRepository infoMedicRepo;
	
	private DateTimeFormatter dateFormatter;
	private ObjectMapper mapper;
	
	@InjectMocks
	private ModificationInfoMedicService infoMedicService = new ModificationInfoMedicServiceImpl(mapper, infoMedicRepo);

	@Test
	void test_save_infoMedic() {
		ModificationInfoMedicDto modifInfoMedic = initInfoDto();
		InfoMedicDto infoMedic = mapper.convertValue(modifInfoMedic, InfoMedicDto.class);
		when(infoMedicService.save(any(ModificationInfoMedicDto.class))).thenReturn(infoMedic);
	    verify(infoMedicRepo, times(1)).save(any(InfoMedic.class));

	}

	private ModificationInfoMedicDto initInfoDto() {

		String nom = "Jusque_TtsXHeure";
		LocalDate dateDebut = LocalDate.parse("2021-06-20", this.dateFormatter);
		String choixDuree = "Jusque date";
		LocalDate dateFin = LocalDate.parse("2021-07-02", this.dateFormatter);
		Integer nbJour = null;
		String choixFrequence = "Chaque jours toutes les X heures";
		Integer x = null;
		LocalTime heureDebut = LocalTime.of(9, 00);
		LocalTime rappel = LocalTime.of(22,30);
		LocalTime heureFin = LocalTime.of(0,45);
		Boolean lundi = true;
		Boolean mardi = true;
		Boolean mercredi = true;
		Boolean jeudi = false;
		Boolean vendredi = true;
		Boolean samedi = false ;
		Boolean dimanche = false;
		List<String> listeHeuresData = new ArrayList<>();

		return new ModificationInfoMedicDto(nom, dateDebut, choixDuree, dateFin, nbJour,choixFrequence, x, heureDebut, rappel,
				heureFin, lundi, mardi, mercredi, jeudi, vendredi, samedi, dimanche, listeHeuresData);

	}

}
