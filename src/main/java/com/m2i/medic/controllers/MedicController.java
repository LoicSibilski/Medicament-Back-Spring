package com.m2i.medic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.m2i.medic.dtos.infoMedic.InfoMedicDto;
import com.m2i.medic.dtos.medic.CreationMedicDto;
import com.m2i.medic.dtos.medic.MedicDto;
import com.m2i.medic.services.medic.ModificationMedicService;
import com.m2i.medic.services.medic.MedicDtoService;

@RestController
@RequestMapping("medics")
@CrossOrigin
public class MedicController {

	@Autowired
	private ModificationMedicService modificationMedicDtoService;

	@Autowired
	private MedicDtoService medicDtoService;

	@GetMapping("")
	public List<MedicDto> getAll() {
		return this.medicDtoService.getAll();
	}

	@GetMapping("/{id}")
	public MedicDto findMedicById(@PathVariable String id) {
		return this.medicDtoService.getById(id);
	}
	
	@GetMapping("/informations/{id}")
	public InfoMedicDto findInfoMedicById(@PathVariable String id) {
		return this.medicDtoService.getInformationById(id);
	}

	@PostMapping("")
	public MedicDto save(@RequestBody CreationMedicDto dto) {
		return this.modificationMedicDtoService.save(dto);
	}

	@PatchMapping()
	public void updateById(@RequestBody MedicDto dto) throws JsonProcessingException, IllegalArgumentException {
		this.modificationMedicDtoService.update(dto);
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
