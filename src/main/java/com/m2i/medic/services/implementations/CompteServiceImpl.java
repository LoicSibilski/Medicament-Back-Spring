package com.m2i.medic.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.CompteDTO;
import com.m2i.medic.models.Compte;
import com.m2i.medic.repositories.CompteRepository;
import com.m2i.medic.services.CompteService;

/**
 * Cette classe représente l'implémentation du service d'un compte
 * @author fabien
 *
 */
public class CompteServiceImpl implements CompteService {
	
	private ObjectMapper mapper;
	
	private CompteRepository repository;
	
	/**
	 * Constructeur
	 * @param repository
	 * @param mapperParam
	 */
	public CompteServiceImpl(CompteRepository repository, ObjectMapper mapperParam) {
		this.repository = repository;
		this.mapper = mapperParam;
	}


	@Override
	public List<CompteDTO> recupererTousLesComptes() {
		List<Compte> listeComptes = this.repository.findAll();
		List<CompteDTO> nouvelleListeComptes = new ArrayList<>();
		for (Compte compte : listeComptes) {
			nouvelleListeComptes.add(this.mapper.convertValue(compte, CompteDTO.class));
		}
		return nouvelleListeComptes;
	}

	@Override
	public CompteDTO recupererUnCompte(String id) {
		Compte compte = this.repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Le compte n'existe pas"));
		return mapper.convertValue(compte, CompteDTO.class);
	}


		
}
