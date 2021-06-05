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

import com.m2i.medic.models.Medic;
import com.m2i.medic.services.GenericService;


@RestController
@RequestMapping("medics")
public class MedicController {

	@Autowired
	private GenericService<Medic> medicService;

	@GetMapping()
	public List<Medic> getAll() {
		return this.medicService.getAll();
	}

	@GetMapping("medic/{id}")
	public Medic getMedicById(@PathVariable String id) {
		return this.medicService.getById(id);
	}

	@PostMapping()
	public void save(@RequestBody Medic[] medics) {
		this.medicService.save(medics);
	}

	@PutMapping("/medic")
	public void updateById( @RequestBody Medic medic) {
		this.medicService.updateById(medic);
	}

	@DeleteMapping("/medic/{id}")
	public void deleteByID(@PathVariable String id) {
		this.medicService.deleteByID(id);
	}
	
	@DeleteMapping("")
	public void deleteAll() {
		this.medicService.deleteAll();
	}
}
