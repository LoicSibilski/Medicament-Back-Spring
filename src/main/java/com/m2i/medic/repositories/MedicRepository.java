package com.m2i.medic.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.m2i.medic.models.Medic;

public interface MedicRepository extends MongoRepository<Medic, String> {

}
