package com.m2i.medic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.medic.dtos.AssistantOuAssisteDTO;
import com.m2i.medic.models.Utilisateur;
import com.m2i.medic.services.UtilisateurService;

@CrossOrigin
@RestController
@RequestMapping("utilisateurs")
@CrossOrigin
public class UtilisateurController {

	@Autowired
	private UtilisateurService service;
	
	@GetMapping("{compteId}/utilisateurs")
	public List<Utilisateur> getAllByCompteId(@PathVariable String compteId){
		return this.service.findAllByCompteId(compteId);
	}
	
	@GetMapping("")
	public List<Utilisateur> getAllUtilisateurs(){
		return this.service.getAll();
	}
	
	@GetMapping("{utilisateurId}")
	public Utilisateur getByUtilisateurId(@PathVariable String utilisateurId) {
		return this.service.getById(utilisateurId);
	}
	
	@GetMapping("{compteId}/assistants")
	public List<AssistantOuAssisteDTO> getAllAssistantsByCompteId(@PathVariable String compteId){
		return this.service.findAllAssistantsByCompteId(compteId);
	}
	
	@GetMapping("assistants/{utilisateurId}")
	public List<AssistantOuAssisteDTO> getAllAssistantsByUtilisateurId(@PathVariable String utilisateurId){
		return this.service.findAllAssistantsByUtilisateurId(utilisateurId);
	}

	@GetMapping("{compteId}/assistes")
	public List<AssistantOuAssisteDTO> getAllAssistesByCompteId(@PathVariable String compteId){
		return this.service.findAllAssistesByCompteId(compteId);
	}
	
	@GetMapping("assistes/{utilisateurId}")
	public List<AssistantOuAssisteDTO> getAllAssistesByUtilisateurId(@PathVariable String utilisateurId){
		return this.service.findAllAssistesByUtilisateurId(utilisateurId);
	}
	
	@DeleteMapping("")
	public void deleteAllUtilisateurs() {
		this.service.deleteAll();
	}
	
	@DeleteMapping("{utilisateurId}")
	public void deleteByUtilisateurId(@PathVariable String utilisateurId) {
		this.service.deleteByID(utilisateurId);
	}
	
	@PostMapping("")
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur user) {
		return this.service.save(user);
	}
	
	@PatchMapping("")
	public Utilisateur updateUtilisateur(@RequestBody Utilisateur user) {
		return this.service.save(user);
	}
	
	
}
