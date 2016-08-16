package com.aiport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aiport.entity.Usuario;
import com.aiport.enums.PerfilUsuarioEnum;
import com.aiport.repository.UsuarioRepository;
import com.aiport.util.MascaraUtil;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CartaoMilhasService cartaoMilhasService;

	@Autowired
	private PerfilUsuarioService perfilUsuarioService;
	
	@Autowired
	private MascaraUtil mascaraUtil;

	@Transactional
	public void save(Usuario usuario) {

		usuario.setCartaoMilha(cartaoMilhasService.getNumeroCartaoMilha());

		usuario.setPerfil(perfilUsuarioService.findOnePerfilUsuario(PerfilUsuarioEnum.PUBLIC));
		
		
		if(usuario.getNumeroDocumento() != null){
			String descricaoSemMascara = mascaraUtil.removerMascara(usuario.getNumeroDocumento());
			usuario.setNumeroDocumento(descricaoSemMascara);
		}else {
			usuario.setNumeroDocumento(null);
		}
		usuarioRepository.save(usuario);
	}

	public List<Usuario> findaAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Transactional
	public void excluir(Usuario usuario) {
		usuarioRepository.delete(usuario.getId());
	}

}
