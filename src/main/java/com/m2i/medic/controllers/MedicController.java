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
	public MedicDto save(@RequestBody CreationMedicDto dto)
			throws JsonProcessingException, IllegalArgumentException {
		System.out.println(dto);
		System.out.println(dto.getNom().getClass());
		System.out.println(dto.getDureeData());
		System.out.println(dto.getFrequenceData());
		System.out.println(dto.getListeHeuresData());
		System.out.println(dto.getListeHeuresData().get(0));
		for (String iterable_element : dto.getListeHeuresData()) {
			System.out.println(iterable_element);
		}
		return null;
//		return this.modificationMedicDtoService.save(dto);

//		this.medicService.save(medics);
	}
	
//	@PostMapping("")
//	public MedicDto save(@RequestBody JsonNode jsonNode)
//			throws JsonProcessingException, IllegalArgumentException {
//
//		return this.modificationMedicDtoService.save(jsonNode);
//
////		this.medicService.save(medics);
//	}

	@PutMapping()
	public void updateById(@RequestBody JsonNode jsonNode) throws JsonProcessingException, IllegalArgumentException {
		this.modificationMedicDtoService.update(jsonNode);
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
