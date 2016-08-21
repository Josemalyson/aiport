package com.aiport.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aiport.entity.TipoDocumento;
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
	
	private ModelAndView modelAndView;

	@RequestMapping
	public ModelAndView redirecionar() {
		modelAndView = new ModelAndView("/paginas/usuario/listarUsuario");
		modelAndView.addObject("usuarios", usuarioService.findaAll());
		return modelAndView;
	}

	@RequestMapping("/novo")
	public ModelAndView novo(Usuario usuario) {
		modelAndView = new ModelAndView("/paginas/usuario/usuario");
		listarTipoDeDocumento(modelAndView);
		return modelAndView;
	}

	private void listarTipoDeDocumento(ModelAndView modelAndView) {
		modelAndView.addObject("tipoDocumentoList", tipoDocumentoService.findAll());
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {

		validandoData(usuario, result);
		
		if (result.hasErrors()) {
			return novo(usuario);
		}
	
		
		try {
			usuarioService.save(usuario);
		} catch (ConstraintViolationException e) {
			result.addError(new FieldError("usuario","login.nomeUsuario",e.getMessage()));
			return novo(usuario);
		}
		
		return new ModelAndView("redirect:/usuario");

	}

	private void validandoData(Usuario usuario, BindingResult result) {
		if (usuario.getDataNascimento() != null ) {
			LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(usuario.getDataNascimento()));
			Period period = Period.between(localDate, LocalDate.now());
			
			if (period.getYears() < 18) {
				usuario.setDataNascimento(null);
				result.addError(new FieldError("usuario","dataNascimento","Menor de Idade"));
			}
		}else{
			usuario.setDataNascimento(null);
			result.addError(new FieldError("usuario","dataNascimento","Campo Data de nascimento obrigatório"));
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Usuario usuario){
		modelAndView = new ModelAndView("/paginas/usuario/usuario");
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

	@RequestMapping(value = "/renderizar/{codigo}", method = RequestMethod.GET)
	public String renderizarCPFoutRG(@PathVariable("codigo") TipoDocumento tipoDocumento){
		
		if(tipoDocumento.getId() == 1){
			modelAndView = new ModelAndView("/paginas/usuario/usuario");
			modelAndView.addObject("label", "CPF");
		}else {
			modelAndView.addObject("label", "RG");
		}
		
		return "/paginas/usuario/usuario :: #idDocumento";
	}
}
