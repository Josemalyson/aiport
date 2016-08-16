package com.aiport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiport.entity.PerfilUsuario;
import com.aiport.enums.PerfilUsuarioEnum;
import com.aiport.repository.PerfilUsuarioRepository;

@Service
public class PerfilUsuarioService {

	@Autowired
	private PerfilUsuarioRepository perfilUsuarioRepository;
	
	public PerfilUsuario findOnePerfilUsuario(PerfilUsuarioEnum perfilUsuarioEnum){
		return perfilUsuarioRepository.findOne(perfilUsuarioEnum.getId());
	}
}
