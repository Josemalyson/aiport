package com.aiport.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aiport.dto.PesquisarDto;
import com.aiport.entity.Voo;
import com.aiport.service.CidadeService;
import com.aiport.service.VooService;

@RequestMapping("/pesquisar")
@Controller
public class PesquisarController {

	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private VooService vooService;
	
	private	ModelAndView modelAndView;
	
	@RequestMapping( value = "/inicio", method = RequestMethod.GET)
	public ModelAndView redirecionarPaginaInicio(){
		setComponenteEstadoInicial();
		this.modelAndView.addObject("vooList", new ArrayList<>());
		this.modelAndView.addObject("flTabela", false);
		return modelAndView;
	}

	private void setComponenteEstadoInicial() {
		this.modelAndView = new ModelAndView("inicio");
		modelAndView.addObject("pesquisarDto", new PesquisarDto());
		modelAndView.addObject("cidadeList", cidadeService.listar());
	}
	
	@RequestMapping( method = RequestMethod.POST)
	public ModelAndView pesquisarVoo(@Valid PesquisarDto pesquisarDto , BindingResult result){
		
		if (result.hasErrors()){
			this.modelAndView = new ModelAndView("/inicio");
			modelAndView.addObject("cidadeList", cidadeService.listar());
		}else {
			setComponenteEstadoInicial();
			this.modelAndView.addObject("flTabela", true);
			verificarSeNaoFoiEncontradoNenhumVoo(pesquisarDto, result);
		}
		
		return this.modelAndView;
	}

	private void verificarSeNaoFoiEncontradoNenhumVoo(PesquisarDto pesquisarDto, BindingResult result) {
		List<Voo> voolist = vooService.findByOrigemIdAndDestinoId(pesquisarDto.getCidadeOrigem().getId(), pesquisarDto.getCidadeDestino().getId());
		this.modelAndView.addObject("vooList", voolist);
		
		if (voolist.isEmpty()) {
			result.addError(new FieldError("pesquisarDto", "", "Nenhum voo encontrado!"));
			this.modelAndView = new ModelAndView("/inicio");
			modelAndView.addObject("cidadeList", cidadeService.listar());
		}
	}

	public ModelAndView getModelAndView() {
		return modelAndView;
	}

	public void setModelAndView(ModelAndView modelAndView) {
		this.modelAndView = modelAndView;
	}
}
