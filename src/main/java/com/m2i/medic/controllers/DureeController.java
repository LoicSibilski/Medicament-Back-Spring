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

import com.m2i.medic.dtos.duree.DureeDto;
import com.m2i.medic.services.duree.ModificationDureeService;
import com.m2i.medic.services.duree.DureeDtoService;

@RestController
@CrossOrigin
@RequestMapping("durees")
public class DureeController {

	@Autowired
	private ModificationDureeService modifDureeService;

	@Autowired
	private DureeDtoService simpleDureeService;
	
	@GetMapping("")
	public List<DureeDto> getAll() {
		return this.simpleDureeService.getAll();
	}

	@GetMapping("/{id}")
	public DureeDto getDureeById(@PathVariable String id) {
		return this.simpleDureeService.getById(id);
	}

	@PostMapping("")
	public void save(@RequestBody DureeDto duree) {
		this.modifDureeService.updateById(duree);
	}
	
	@PutMapping("")
	public void updateById(@RequestBody DureeDto duree) {
		this.modifDureeService.updateById(duree);
	}

	@DeleteMapping("/{id}")
	public void deleteByID(@PathVariable String id) {
		this.simpleDureeService.deleteByID(id);
	}

	@DeleteMapping()
	public void deleteAll() {
		this.simpleDureeService.deleteAll();
	}
}
