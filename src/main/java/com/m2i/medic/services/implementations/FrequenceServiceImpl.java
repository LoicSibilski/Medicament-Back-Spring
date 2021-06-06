package com.m2i.medic.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.m2i.medic.models.Frequence;
import com.m2i.medic.repositories.FrequenceRepository;
import com.m2i.medic.services.GenericService;

public class FrequenceServiceImpl implements GenericService<Frequence>{

	@Autowired
	private FrequenceRepository frequenceRepository;
	
	public List<Frequence> getAll() {
		return this.frequenceRepository.findAll();
	}

	public Frequence getById(String id) {
		return this.frequenceRepository.findById(id).get();
	}
	
	public Frequence save (Frequence frequence) {
		return this.frequenceRepository.save(frequence);
	}
	
	public void save(Frequence[] frequence) {
		for (Frequence freq : frequence) {
			System.out.println("save freq : " + freq.toString());
			this.frequenceRepository.save(freq);
		}
	}
	
	public Frequence updateById(Frequence frequence) {
		return this.frequenceRepository.save(frequence);
	}
	
	public void deleteByID(String id) {
		System.out.println("HERETIQUE AU BUCHER " + getById(id).toString());
		this.frequenceRepository.deleteById(id);;
	}
	
	public void deleteAll() {
		List<Frequence> liste = this.frequenceRepository.findAll();
		for (Frequence frequence : liste) {
			this.frequenceRepository.delete(frequence);
		}
		// TODO Auto-generated method stub
	}

}
