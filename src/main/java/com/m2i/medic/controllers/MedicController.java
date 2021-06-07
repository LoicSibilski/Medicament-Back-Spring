package com.m2i.medic.controllers;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.m2i.medic.models.Medic;
import com.m2i.medic.models.MedicTmp;
import com.m2i.medic.services.GenericService;
import com.m2i.medic.services.MedicService;


@RestController
@RequestMapping("medics")
@CrossOrigin
public class MedicController {

	@Autowired
	private MedicService medicService;

	@GetMapping()
	public List<Medic> getAll() {
		return this.medicService.getAll();
	}

	@GetMapping("medic/{id}")
	public Medic getMedicById(@PathVariable String id) {
		return this.medicService.getById(id);
	}

	@PostMapping()
	public void save(@RequestBody JsonNode medicTmp) {
		System.out.println(medicTmp);
		try {
			this.medicService.convertTmpToReal(medicTmp);
		} catch (IllegalArgumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		this.medicService.save(medics);
	}

	@PutMapping()
	public void updateById( @RequestBody Medic medic) {
		this.medicService.updateById(medic);
	}

	@DeleteMapping("/{id}")
	public void deleteByID(@PathVariable String id) {
		this.medicService.deleteByID(id);
	}
	
	@DeleteMapping()
	public void deleteAll() {
		this.medicService.deleteAll();
	}
}
