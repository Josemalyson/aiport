package com.aiport.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class SecutityController {

	@RequestMapping("/entrar")
	public String login(@AuthenticationPrincipal User user) {

		if (user != null) {
			
			for (GrantedAuthority grantedAuthority : user.getAuthorities()) {
				if (grantedAuthority.getAuthority().contains("ROLE_ADMIN")) {
					return "redirect:/redireciona/adminInicial";
				}
			}
		}
		
		return "redirect:/redireciona/usuarioInicial";

	}
}
