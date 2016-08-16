package com.aiport.repository;

import org.springframework.data.repository.CrudRepository;

import com.aiport.entity.Aeronave;

public interface AeronaveRepository extends CrudRepository<Aeronave, Long> {

}
