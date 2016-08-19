package com.aiport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiport.entity.Aeronave;
import com.aiport.repository.AeronaveRepository;

@Service
public class AeronaveService {

	@Autowired
	private AeronaveRepository aeronaveRepository;
	
	
	public List<Aeronave> listar(){
		return (List<Aeronave>) aeronaveRepository.findAll();
	}
	
	public void save(Aeronave aeronave){
		aeronaveRepository.save(aeronave);
	}
	
}
