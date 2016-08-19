package com.aiport.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.aiport.entity.Cidade;

public class PesquisarDto {

	@NotNull(message = "Campo data obrigatório")
	private Date data;
	
	@NotNull(message = "Campo Cidade Origem obrigatório")
	private Cidade cidadeOrigem;
	
	@NotNull(message = "Campo Cidade Destino obrigatório")
	private Cidade cidadeDestino;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cidade getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(Cidade cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public Cidade getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(Cidade cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

}
