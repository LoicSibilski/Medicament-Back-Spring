package com.m2i.medic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.medic.models.Duree;
import com.m2i.medic.services.GenericCRUDService;

@RestController
@RequestMapping("durees")
public class DureeController {

//	@Autowired
//	private GenericCRUDService<Duree> dureeService;
//
//	@GetMapping()
//	public List<Duree> getAll() {
//		return this.dureeService.getAll();
//	}
//
//	@GetMapping("/{id}")
//	public Duree getDureeById(@PathVariable String id) {
//		return this.dureeService.getById(id);
//	}
//
//	@PutMapping()
//	public void updateById(@RequestBody Duree duree) {
//		this.dureeService.updateById(duree);
//	}
//
//	@DeleteMapping("/{id}")
//	public void deleteByID(@PathVariable String id) {
//		this.dureeService.deleteByID(id);
//	}
//
//	@DeleteMapping()
//	public void deleteAll() {
//		this.dureeService.deleteAll();
//	}
}
