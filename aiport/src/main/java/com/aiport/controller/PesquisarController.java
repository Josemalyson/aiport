package com.aiport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aiport.service.CidadeService;

@RequestMapping("/pesquisar")
@Controller
public class PesquisarController {

	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping("/inicio")
	public ModelAndView redirecionarPaginaInicio(){
		ModelAndView modelAndView = new ModelAndView("inicio");
		modelAndView.addObject("cidadeList", cidadeService.listar());
		return modelAndView;
	}
}
