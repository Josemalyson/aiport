package com.aiport.repository;

import org.springframework.data.repository.CrudRepository;

import com.aiport.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
