package com.aiport.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aiport.entity.Voo;
import com.aiport.service.CidadeService;
import com.aiport.service.VooService;

@Controller
@RequestMapping("/voo")
public class VooController {

	@Autowired
	private VooService vooService;
	
	@Autowired
	private CidadeService cidadeService;


	@RequestMapping
	public ModelAndView redirecionar() {
		ModelAndView modelAndView = new ModelAndView("/paginas/voo/listarVoo");
		modelAndView.addObject("voos", vooService.listar());
		return modelAndView;
	}

	@RequestMapping("/novo")
	public ModelAndView novo(Voo voo) {
		ModelAndView modelAndView = new ModelAndView("/paginas/voo/voo");
		modelAndView.addObject("cidadeList", cidadeService.listar());
		return modelAndView;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Voo voo, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return novo(voo);
		}
		vooService.save(voo);
		attributes.addFlashAttribute("mensagem", "Voo salvo com sucesso!");
		return new ModelAndView("redirect:/voo");

	}

}
