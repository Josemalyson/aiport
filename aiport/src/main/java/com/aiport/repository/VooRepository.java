package com.aiport.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aiport.entity.Voo;

@Repository
public interface VooRepository extends CrudRepository<Voo, Long> {

	public List<Voo> findByOrigemIdAndDestinoId(Long origem, Long destino);

}
