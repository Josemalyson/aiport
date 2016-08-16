package com.aiport.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiport.entity.Cidade;
import com.aiport.repository.CidadeRepository;

@Service
public class CidadeService implements Serializable{

	private static final long serialVersionUID = -7391851270295621774L;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> listar(){
		List<Cidade> retorno = new ArrayList<>();
		for(Cidade c: cidadeRepository.findAll()) {
			retorno.add(c);
		}
		return retorno;
	}
}
