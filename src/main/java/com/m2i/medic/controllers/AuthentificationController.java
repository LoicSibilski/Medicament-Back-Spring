package com.m2i.medic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.medic.dtos.AuthentificationDTO;
import com.m2i.medic.services.AuthentificationService;



@RestController
@RequestMapping("auth")
public class AuthentificationController {

	@Autowired
	private AuthentificationService authService;
	
	@PostMapping("connexion")
	public String connexion(@RequestBody AuthentificationDTO dto) {
		return this.authService.connexion(dto);
	}
	
}
