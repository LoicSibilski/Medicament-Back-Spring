package com.m2i.medic.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.m2i.medic.models.Duree;

public interface DureeRepository extends MongoRepository<Duree, String> {

}
