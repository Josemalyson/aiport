package com.aiport.enums;

public enum PerfilUsuarioEnum {

	ADMIN(1L, "Admin"), PUBLIC(2L, "Publico");

	private Long id;
	private String descricao;

	private PerfilUsuarioEnum(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

}
