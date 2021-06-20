//package com.m2i.medic.services.implementations.duree;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Map;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.m2i.medic.dtos.duree.DureeDto;
//import com.m2i.medic.services.duree.JsonDureeDtoService;
//import com.m2i.medic.services.duree.ModificationDureeService;
//
//public class JsonDureeDtoServiceImpl implements JsonDureeDtoService{
//
//	private DateTimeFormatter dateFormatter;
//	private ModificationDureeService dureeDtoService;
//	private ObjectMapper mapper;
//	
//	public JsonDureeDtoServiceImpl(DateTimeFormatter dateFormatter, ModificationDureeService dureeDtoService,
//			ObjectMapper mapper) {
//		this.dureeDtoService = dureeDtoService;
//		this.dateFormatter = dateFormatter;
//		this.mapper = mapper;
//	}
//
//	public DureeDto createDureeDtoFromMap(Map<String, Object> mapDuree) {
//
//		DureeDto dto = getDureeWithDateDebutFromMap(mapDuree);
//		String choix = mapDuree.get("choixDuree").toString();
//		
//		setDureeDtoFromMap(mapDuree, dto, choix);
//		DureeDto dr = this.mapper.convertValue(dto, DureeDto.class);
//		DureeDto dureeDto = this.mapper.convertValue(this.dureeDtoService.save(dr), DureeDto.class);
//		return dureeDto;
//	}
//
//	/**
//	 * 
//	 * @param mapDuree : Map contenant toutes les informations concernant la duree dans le Json envoye par l'utilisateur
//	 * @param dureeDto: CreationDureeDto = Object dto contenant la date de debut.
//	 * @param choix :String = option que l'utilisateur a choisit ("Pas de fin", "Pendant X jours" ...).
//	 */
//	private void setDureeDtoFromMap(Map<String, Object> mapDuree, DureeDto dureeDto, String choix) {
//		if (choix.equals("Pas de fin")) {
//			dureeDto.setDateFin(dureeDto.getDateDebut().plusYears(1));
//
//		} else if (choix.equals("Pendant X jours") && mapDuree.get("nbJour") != null) {
//			Integer nbJour = (Integer) mapDuree.get("nbJour");
//			dureeDto.setDateFin(dureeDto.getDateDebut().plusDays(nbJour));
//
//		} else if (choix.equals("Jusque date") && mapDuree.get("dateFin") != null) {
//			LocalDate date = LocalDate.parse(mapDuree.get("dateFin").toString(), this.dateFormatter);
//			dureeDto.setDateFin(date.atStartOfDay());
//		}
//	}
//
//	/**
//	 * La methode initialise la date de debut du dto CreationDureeDto
//	 * @param mapDuree : Map contenant toutes les informations concernant la duree dans le Json envoye par l'utilisateur
//	 * @return CreationDureeDto 
//	 */
//	private DureeDto getDureeWithDateDebutFromMap(Map<String, Object> mapDuree) {
//		DureeDto dureeDto = new DureeDto();
//
//		LocalDate date = LocalDate.parse(mapDuree.get("dateDebut").toString(), this.dateFormatter);
//		LocalDateTime dateDebut = date.atStartOfDay();
//		dureeDto.setDateDebut(dateDebut);
//		return dureeDto;
//	}
//}
