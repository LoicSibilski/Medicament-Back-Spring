package com.m2i.medic.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.m2i.medic.models.InfoMedic;

public interface InfoMedicRepository extends MongoRepository<InfoMedic, String>{

}
