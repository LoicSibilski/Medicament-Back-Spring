package com.m2i.medic.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.m2i.medic.models.Duree;
import com.m2i.medic.repositories.DureeRepository;
import com.m2i.medic.services.GenericService;

public class DureeServiceImpl implements GenericService<Duree>{

	@Autowired
	private DureeRepository dureeRepository;
	
	public List<Duree> getAll() {
		return this.dureeRepository.findAll();
	}

	public Duree getById(String id) {
		return this.dureeRepository.findById(id).get();
	}
	
	public Duree save (Duree duree) {
		return this.dureeRepository.save(duree);
	}
	
	public void save(Duree[] duree) {
		for (Duree dur : duree) {
			System.out.println("save dur : " + dur.toString());
			this.dureeRepository.save(dur);
		}
	}
	
	public Duree updateById(Duree duree) {
		return this.dureeRepository.save(duree);
	}
	
	public void deleteByID(String id) {
		System.out.println("HERETIQUE AU BUCHER " + getById(id).toString());
		this.dureeRepository.deleteById(id);;
	}
	
	public void deleteAll() {
		List<Duree> liste = this.dureeRepository.findAll();
		for (Duree duree : liste) {
			this.dureeRepository.delete(duree);
		}
		// TODO Auto-generated method stub
	}


}
