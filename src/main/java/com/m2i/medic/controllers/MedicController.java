package com.m2i.medic.controllers;

import java.io.IOException;
import java.util.List;

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
import com.m2i.medic.dtos.medic.SimpleMedicDto;
import com.m2i.medic.dtos.medic.MedicDto;
import com.m2i.medic.models.Medic;
import com.m2i.medic.services.medic.MedicDtoService;


@RestController
@RequestMapping("medics")
@CrossOrigin
public class MedicController {

	@Autowired
	private MedicDtoService medicDtoService;

	@GetMapping()
	public List<MedicDto> getAll() {
		return this.medicDtoService.getAll();
	}

	@GetMapping("medic/{id}")
	public MedicDto getMedicById(@PathVariable String id) {
		return this.medicDtoService.getById(id);
	}

	@PostMapping()
	public SimpleMedicDto save(@RequestBody JsonNode jsonNode) {
		System.out.println(jsonNode);
		try {
			this.medicDtoService.save(jsonNode);
			System.out.println("tous marche c'est termine");
		} catch (IllegalArgumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
//		this.medicService.save(medics);
	}

	@PutMapping()
	public void updateById( @RequestBody MedicDto medicDto) {
		this.medicDtoService.updateById(medicDto);
	}

	@DeleteMapping("/{id}")
	public void deleteByID(@PathVariable String id) {
		this.medicDtoService.deleteByID(id);
	}
	
	@DeleteMapping()
	public void deleteAll() {
		this.medicDtoService.deleteAll();
	}
}
