package com.aiport.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiport.entity.CartaoMilhas;
import com.aiport.repository.CartaoMillhasRepository;

@Service
public class CartaoMilhasService {

	@Autowired
	private CartaoMillhasRepository cartaoMillhasRepository;
	
	public CartaoMilhas findOne(Long id){
		return cartaoMillhasRepository.findOne(id);
	}

	public CartaoMilhas getNumeroCartaoMilha() {

		CartaoMilhas cartaoMilhas = new CartaoMilhas();
		Random randomGenerator = new Random();
		cartaoMilhas.setNuCartao(randomGenerator.nextInt());
		cartaoMilhas.setQuantidadeMilha(0);
		
		return cartaoMilhas;
	}
}
