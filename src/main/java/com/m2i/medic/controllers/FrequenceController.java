package com.m2i.medic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.medic.models.Frequence;
import com.m2i.medic.services.GenericCRUDService;

@RestController
@RequestMapping("frequences")
public class FrequenceController {

//	@Autowired
//	private GenericCRUDService<Frequence> frequenceService;
//
//	@GetMapping()
//	public List<Frequence> getAll() {
//		return this.frequenceService.getAll();
//	}
//
//	@GetMapping("/{id}")
//	public Frequence getFrequenceById(@PathVariable String id) {
//		return this.frequenceService.getById(id);
//	}
//
//	@PutMapping()
//	public void updateById(@RequestBody Frequence frequence) {
//		this.frequenceService.updateById(frequence);
//	}
//
//	@DeleteMapping("/{id}")
//	public void deleteByID(@PathVariable String id) {
//		this.frequenceService.deleteByID(id);
//	}
//
//	@DeleteMapping()
//	public void deleteAll() {
//		this.frequenceService.deleteAll();
//	}
}
