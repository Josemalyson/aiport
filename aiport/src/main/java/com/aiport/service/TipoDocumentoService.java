package com.aiport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiport.entity.TipoDocumento;
import com.aiport.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	public List<TipoDocumento> findAll(){
		return (List<TipoDocumento>) tipoDocumentoRepository.findAll();
	}

}
