package com.m2i.medic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("utilisateurs")
public class UtilisateurController {

	@Autowired
	private UtilisateurService service;
	
	@GetMapping("{id}/utilisateurs")
	public List<Utilisateur> getAllByCompteId(@PathVariable String id){
		return this.service.findAllByCompteId(id);
	}
	
	@GetMapping("")
	public List<Utilisateur> getAll(){
		return this.service.getAll();
	}
	
	@GetMapping("{id}")
	public Utilisateur getById(@PathVariable String id) {
		return this.service.getById(id);
	}
	
	@GetMapping("{id}/assistants")
	public List<AssistantOuAssisteDTO> getAllAssistants(@PathVariable String id){
		return this.service.findAllAssistantsByCompteId(id);
	}
	
	@DeleteMapping("")
	public void deleteAll() {
		this.service.deleteAll();
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable String id) {
		this.service.deleteByID(id);
	}
	
	@PostMapping("")
	public Utilisateur save(@RequestBody Utilisateur user) {
		return this.service.save(user);
	}
	
	@PatchMapping("")
	public Utilisateur update(@RequestBody Utilisateur user) {
		return this.service.save(user);
	}
	
	
}
