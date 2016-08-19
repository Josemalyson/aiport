package com.aiport.dto;

import java.util.Date;

import com.aiport.entity.Cidade;

public class PesquisarDto {

	private Date data;
	
	private Cidade cidadeOrigem;
	
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
