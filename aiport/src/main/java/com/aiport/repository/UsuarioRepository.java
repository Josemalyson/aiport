package com.aiport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiport.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
