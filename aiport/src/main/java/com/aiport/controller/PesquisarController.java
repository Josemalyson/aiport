package com.aiport.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aiport.dto.PesquisarDto;
import com.aiport.service.CidadeService;
import com.aiport.service.VooService;

@RequestMapping("/pesquisar")
@Controller
public class PesquisarController {

	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private VooService vooService;
	
	@RequestMapping( value = "/inicio", method = RequestMethod.GET)
	public ModelAndView redirecionarPaginaInicio(){
		ModelAndView modelAndView = new ModelAndView("inicio");
		modelAndView.addObject("pesquisarDto", new PesquisarDto());
		modelAndView.addObject("vooList", new ArrayList<>());
		modelAndView.addObject("cidadeList", cidadeService.listar());
		return modelAndView;
	}
	@RequestMapping( method = RequestMethod.POST)
	public ModelAndView pesquisarVoo(PesquisarDto pesquisarDto){
		ModelAndView modelAndView = new ModelAndView("inicio");
		modelAndView.addObject("vooList", vooService.findByOrigemDestino(pesquisarDto.getCidadeOrigem().getId(), pesquisarDto.getCidadeDestino().getId()));
		return modelAndView;
	}
}
