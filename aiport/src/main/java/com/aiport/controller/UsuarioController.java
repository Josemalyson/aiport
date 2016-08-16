package com.aiport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aiport.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping
	public ModelAndView redirecionar() {
		ModelAndView modelAndView = new ModelAndView("/paginas/usuario/listarUsuario");
		modelAndView.addObject("usuarios", usuarioService.findaAll());
		return modelAndView;
	}
}
