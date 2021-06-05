package com.m2i.medic.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.m2i.medic.models.Medic;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.GenericService;



public class MedicServiceImpl implements GenericService<Medic>{

	@Autowired
	private MedicRepository medicRepository;
	
	public List<Medic> getAll() {
		return this.medicRepository.findAll();
	}

	public Medic getById(String id) {
		return this.medicRepository.findById(id).get();
	}
	
	public Medic save (Medic medic) {
		return this.medicRepository.save(medic);
	}
	
	public void save(Medic[] medic) {
		for (Medic med : medic) {
			System.out.println("save med : " + med.toString());
			this.medicRepository.save(med);
		}
	}
	
	public Medic updateById(Medic medic) {
		return this.medicRepository.save(medic);
	}
	
	public void deleteByID(String id) {
		System.out.println("HERETIQUE AU BUCHER " + getById(id).toString());
		this.medicRepository.deleteById(id);;
	}
	
	public void deleteAll() {
		List<Medic> liste = this.medicRepository.findAll();
		for (Medic medic : liste) {
			this.medicRepository.delete(medic);
		}
		// TODO Auto-generated method stub
	}
}
