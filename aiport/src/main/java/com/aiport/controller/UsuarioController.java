package com.aiport.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
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
		listarTipoDeDocumento(modelAndView);
		modelAndView.addObject("exibir", false);
		return modelAndView;
	}

	private void listarTipoDeDocumento(ModelAndView modelAndView) {
		modelAndView.addObject("tipoDocumentoList", tipoDocumentoService.findAll());
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {

		if (usuario.getDataNascimento() != null ) {
			LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(usuario.getDataNascimento()));
			Period period = Period.between(localDate, LocalDate.now());
			
			if (period.getYears() < 18) {
				usuario.setDataNascimento(null);
				result.addError(new FieldError("usuario","dataNascimento","Menor de Idade"));
			}
		}
		
		if (result.hasErrors()) {
			return novo(usuario);
		}
	
		usuarioService.save(usuario);
		
		return new ModelAndView("redirect:/usuario");

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Usuario usuario){
		ModelAndView modelAndView = new ModelAndView("/paginas/usuario/usuario");
		modelAndView.addObject("usuario", usuario);
		modelAndView.addObject("exibir", true);
		listarTipoDeDocumento(modelAndView);
		return modelAndView;
	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
	public ModelAndView ecluir(@PathVariable("id") Usuario usuario){
		usuarioService.excluir(usuario);
		return new ModelAndView("redirect:/usuario");
	}

}
