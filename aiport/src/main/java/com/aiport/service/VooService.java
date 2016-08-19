package com.aiport.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiport.entity.Voo;
import com.aiport.repository.VooRepository;

@Service
public class VooService implements Serializable{

	private static final long serialVersionUID = 5492141962398500591L;
	@Autowired
	private VooRepository vooRepository;
	
	public List<Voo> findByOrigemDestino(Long origem, Long destino){
		return vooRepository.findByOrigemDestino(origem, destino);
	}
	
	public List<Voo> listar(){
		return (List<Voo>) vooRepository.findAll();
	}
	
	public void save(Voo voo){
		vooRepository.save(voo);
	}
}
