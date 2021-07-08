package com.m2i.medic.controllers;

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
import com.m2i.medic.dtos.infoMedic.InfoMedicDto;
import com.m2i.medic.dtos.infoMedic.ModificationInfoMedicDto;
import com.m2i.medic.models.InfoMedic;
import com.m2i.medic.services.infoMedic.InfoMedicDtoService;
import com.m2i.medic.services.infoMedic.ModificationInfoMedicService;

@RestController
@RequestMapping("infoMedics")
@CrossOrigin
public class InfoMedicController {

	@Autowired
	private ModificationInfoMedicService modificationInfoMedicDtoService;

	@Autowired
	private InfoMedicDtoService infoMedicDtoService;

	@GetMapping("")
	public List<InfoMedicDto> getAll() {
		return this.infoMedicDtoService.getAll();
	}

	@GetMapping("/{id}")
	public InfoMedicDto findInfoMedicById(@PathVariable String id) {
		return this.infoMedicDtoService.getById(id);
	}

	@PutMapping()
	public void updateById(@RequestBody InfoMedicDto dto) throws JsonProcessingException, IllegalArgumentException {
		this.modificationInfoMedicDtoService.update(dto);
	}

	@DeleteMapping("/{id}")
	public void deleteByID(@PathVariable String id) {
		this.infoMedicDtoService.deleteByID(id);
	}

	@DeleteMapping()
	public void deleteAll() {
		this.infoMedicDtoService.deleteAll();
	}
}
