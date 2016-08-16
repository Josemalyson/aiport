package com.aiport.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aiport.entity.Usuario;
import com.aiport.service.TipoDocumentoService;
import com.aiport.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private TipoDocumentoService tipoDocumentoService;

	@RequestMapping
	public ModelAndView redirecionar() {
		ModelAndView modelAndView = new ModelAndView("/paginas/usuario/listarUsuario");
		modelAndView.addObject("usuarios", usuarioService.findaAll());
		return modelAndView;
	}

	@RequestMapping("/novo")
	public ModelAndView novo(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("/paginas/usuario/usuario");
		modelAndView.addObject("tipoDocumentoList", tipoDocumentoService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return novo(usuario);
		}
		usuarioService.save(usuario);
		attributes.addFlashAttribute("mensagem", "Vinho salvo com sucesso!");
		return new ModelAndView("redirect:/usuario");

	}

}
