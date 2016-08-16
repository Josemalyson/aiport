package com.aiport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aiport.service.TipoDocumentoService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private TipoDocumentoService tp; 
	
	@RequestMapping("/listar")
	public String redirecionar(){
		tp.findAll();
		return "listarUsuario";
	}
}
