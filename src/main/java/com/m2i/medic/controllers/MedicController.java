package com.m2i.medic.controllers;

import java.util.Iterator;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.m2i.medic.dtos.medic.CreationMedicDto;
import com.m2i.medic.dtos.medic.MedicDto;
import com.m2i.medic.dtos.medic.SimpleMedicDto;
import com.m2i.medic.services.medic.ModificationMedicService;
import com.m2i.medic.services.medic.SimpleMedicDtoService;

@RestController
@RequestMapping("medics")
@CrossOrigin
public class MedicController {

	@Autowired
	private ModificationMedicService modificationMedicDtoService;

	@Autowired
	private SimpleMedicDtoService simpleMedicDtoService;

	@GetMapping("")
	public List<SimpleMedicDto> getAll() {
		return this.simpleMedicDtoService.getAll();
	}

	@GetMapping("/{id}")
	public SimpleMedicDto findSimpleMedicById(@PathVariable String id) {
		return this.simpleMedicDtoService.getById(id);
	}

	@PostMapping("")
	public MedicDto save(@RequestBody CreationMedicDto dto) {
		return this.modificationMedicDtoService.save(dto);
	}

	@PutMapping()
	public void updateById(@RequestBody CreationMedicDto dto) throws JsonProcessingException, IllegalArgumentException {
		this.modificationMedicDtoService.update(dto);
	}

	@DeleteMapping("/{id}")
	public void deleteByID(@PathVariable String id) {
		this.simpleMedicDtoService.deleteByID(id);
	}

	@DeleteMapping()
	public void deleteAll() {
		this.simpleMedicDtoService.deleteAll();
	}
}
