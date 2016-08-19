package com.aiport.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiport.entity.Voo;
import com.aiport.entity.vo.VooVO;
import com.aiport.repository.VooRepository;

@Service
public class VooService implements Serializable{

	private static final long serialVersionUID = 5492141962398500591L;
	@Autowired
	private VooRepository vooRepository;
	
	public List<Voo> findByOrigemIdAndDestinoId(Long origem, Long destino){
		return vooRepository.findByOrigemIdAndDestinoId(origem, destino);
	}
	
	public List<Voo> listar(){
		return (List<Voo>) vooRepository.findAll();
	}
	
	public void save(Voo voo){
		vooRepository.save(voo);
	}
	
	public List<VooVO> listaEmontaVooVO(){
		List<VooVO> listaVooVO = new ArrayList<VooVO>();
		List<Voo> listaVoo = listar();
		
		for (Voo voo : listaVoo) {
			VooVO vooVO = new VooVO();
			vooVO.setNumeroDoVoo(voo.getId().toString());
			vooVO.setOrigemDestino(voo.getOrigem().getDsNome()+" / "+voo.getDestino().getDsNome());
			vooVO.setHoraDoVoo(voo.getDataPartida());
			vooVO.setPrecoDoVoo("R$ "+voo.getPreco().toString());
			vooVO.setCapacidadeDoVoo(voo.getAeronave().getQtdAssento());
			listaVooVO.add(vooVO);
		}
		
		return listaVooVO;
	}
}
