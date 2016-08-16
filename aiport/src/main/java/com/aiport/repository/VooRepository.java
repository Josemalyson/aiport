package com.aiport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aiport.entity.Voo;

@Repository
public interface VooRepository extends CrudRepository<Voo, Long> {

	  @Query(value="SELECT * FROM TB_JET_VOO WHERE fk_cidade_destino = :destino and fk_cidade_origem = :origem ", nativeQuery = true)
	  public List<Voo> findByOrigemDestino(@Param("origem") Long origem, @Param("destino") Long destino);
	
}
