//package com.m2i.medic.services.implementations.infoMedic;
//
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.stubbing.OngoingStubbing;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import com.m2i.medic.dtos.duree.CreationDureeDto;
//import com.m2i.medic.dtos.frequence.CreationFrequenceDto;
//import com.m2i.medic.dtos.infoMedic.InfoMedicDto;
//import com.m2i.medic.dtos.infoMedic.ModificationInfoMedicDto;
//import com.m2i.medic.dtos.medic.CreationMedicDto;
//import com.m2i.medic.models.InfoMedic;
//import com.m2i.medic.repositories.InfoMedicRepository;
//import com.m2i.medic.services.infoMedic.ModificationInfoMedicService;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class ModificationInfoMedicServiceImplTest {
//
//	private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//	private ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule())
//			.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
//			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
//			.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
//
//	@Autowired
//	MockMvc mockMvc;
//
//	@Mock
//	private InfoMedicRepository infoMedicRepo;
//
//	@InjectMocks
//	private ModificationInfoMedicService infoMedicService = new ModificationInfoMedicServiceImpl(mapper, infoMedicRepo);
//
//	@Test
//	@DisplayName("Test de la sauvegarde dans la base de données des information du medic")
//	void test_save_infoMedic() throws Exception {
//		// GIVEN
//		ModificationInfoMedicDto modifInfoMedic = initInfoDto();
//		InfoMedicDto test = new InfoMedicDto();
////		InfoMedicDto infoMedic = mapper.convertValue(modifInfoMedic, InfoMedicDto.class);		
//	    when(infoMedicService.save(modifInfoMedic)).thenReturn(test);
//	    InfoMedicDto medic = infoMedicService.save(modifInfoMedic);
//	    verify(infoMedicService, times(1)).save(Mockito.any(ModificationInfoMedicDto.class));
//		
//
//	}
//
//	private ModificationInfoMedicDto initInfoDto() {
//		String nom = "Jusque_TtsXHeure";
//		LocalDate dateDebut = LocalDate.parse("2021-06-20", this.dateFormatter);
//		String choixDuree = "Jusque date";
//		LocalDate dateFin = LocalDate.parse("2021-07-02", this.dateFormatter);
//		Integer nbJour = null;
//		String choixFrequence = "Chaque jours toutes les X heures";
//		Integer x = null;
//		LocalTime heureDebut = LocalTime.of(9, 00);
//		LocalTime rappel = LocalTime.of(22, 30);
//		LocalTime heureFin = LocalTime.of(0, 45);
//		Boolean lundi = true;
//		Boolean mardi = true;
//		Boolean mercredi = true;
//		Boolean jeudi = false;
//		Boolean vendredi = true;
//		Boolean samedi = false;
//		Boolean dimanche = false;
//		List<String> listeHeuresData = new ArrayList<>();
//
//		return new ModificationInfoMedicDto(nom, dateDebut, choixDuree, dateFin, nbJour, choixFrequence, x, heureDebut,
//				rappel, heureFin, lundi, mardi, mercredi, jeudi, vendredi, samedi, dimanche, listeHeuresData);
//
//	}
//
//}
