package com.aiport.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aiport.entity.Voo;
import com.aiport.entity.vo.VooVO;
import com.aiport.service.AeronaveService;
import com.aiport.service.CidadeService;
import com.aiport.service.VooService;

@Controller
@RequestMapping("/voo")
public class VooController {

	@Autowired
	private VooService vooService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private AeronaveService aeronaveService;


	@RequestMapping
	public ModelAndView redirecionar() {
		ModelAndView modelAndView = new ModelAndView("/paginas/voo/listarVoo");
		modelAndView.addObject("voos", vooService.listaEmontaVooVO());
		modelAndView.addObject("cidadeList", cidadeService.listar());
		modelAndView.addObject("aeronaveList", aeronaveService.listar());
		modelAndView.addObject("voo", new Voo());
		return modelAndView;
	}


	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Voo voo, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return redirecionar();
		}
		vooService.save(voo);
		attributes.addFlashAttribute("mensagem", "Voo salvo com sucesso!");
		return new ModelAndView("redirect:/voo");

	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
	public ModelAndView ecluir(@ModelAttribute("command")  VooVO vooVO){
		vooService.excluir(vooVO);
		return new ModelAndView("redirect:/voo");
	}

}
