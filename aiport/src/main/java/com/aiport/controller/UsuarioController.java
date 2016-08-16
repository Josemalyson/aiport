package com.aiport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@RequestMapping("/listar")
	public String redirecionar(){
		return "listarUsuario";
	}
}
