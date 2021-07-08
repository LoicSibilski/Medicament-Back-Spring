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

import com.m2i.medic.dtos.frequence.FrequenceDto;
import com.m2i.medic.services.frequence.ModificationFrequenceDtoService;
import com.m2i.medic.services.frequence.FrequenceDtoService;


@RestController
@CrossOrigin
@RequestMapping("frequences")
public class FrequenceController {

	@Autowired
	private ModificationFrequenceDtoService modifFrequenceService;

	@Autowired
	private FrequenceDtoService simpleFrequenceService;
	
	@GetMapping("")
	public List<FrequenceDto> getAll() {
		return this.simpleFrequenceService.getAll();
	}

	@GetMapping("/{id}")
	public FrequenceDto getFrequenceById(@PathVariable String id) {
		return this.simpleFrequenceService.getById(id);
	}

	@PostMapping("")
	public void save(@RequestBody FrequenceDto duree) {
		this.modifFrequenceService.updateById(duree);
	}
	
	@PutMapping("")
	public void updateById(@RequestBody FrequenceDto duree) {
		this.modifFrequenceService.updateById(duree);
	}

	@DeleteMapping("/{id}")
	public void deleteByID(@PathVariable String id) {
		this.simpleFrequenceService.deleteByID(id);
	}

	@DeleteMapping()
	public void deleteAll() {
		this.simpleFrequenceService.deleteAll();
	}
}
