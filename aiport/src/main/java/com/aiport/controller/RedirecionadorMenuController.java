package com.aiport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redireciona")
public class RedirecionadorMenuController {

	@RequestMapping("/usuarioInicial")
	public String redirecionarPaginaUsuario() {
		return "usuarioInicial";
	}
	
	@RequestMapping("/adminInicial")
	public String redirecionarPaginaAdmin(){
		return "adminInicial";
	}

	@RequestMapping("/usuario/novo")
	public String redirecionarPaginaNovoUsuario(){
		return "redirect:/usuario/novo";
	}
}
