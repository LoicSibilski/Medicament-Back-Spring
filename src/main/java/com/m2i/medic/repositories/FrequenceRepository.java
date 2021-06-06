package com.m2i.medic.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.m2i.medic.models.Frequence;

public interface FrequenceRepository extends MongoRepository<Frequence, String>{

}
