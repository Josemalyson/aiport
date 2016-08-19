package com.aiport.entity.vo;

import java.util.Date;

public class VooVO {
	
	private String numeroDoVoo;
	private String origemDestino;
	private Date horaDoVoo;
	private String precoDoVoo;
	private int capacidadeDoVoo;
	
	
	public String getNumeroDoVoo() {
		return numeroDoVoo;
	}
	public void setNumeroDoVoo(String numeroDoVoo) {
		this.numeroDoVoo = numeroDoVoo;
	}
	public String getOrigemDestino() {
		return origemDestino;
	}
	public void setOrigemDestino(String origemDestino) {
		this.origemDestino = origemDestino;
	}
	public Date getHoraDoVoo() {
		return horaDoVoo;
	}
	public void setHoraDoVoo(Date horaDoVoo) {
		this.horaDoVoo = horaDoVoo;
	}
	public String getPrecoDoVoo() {
		return precoDoVoo;
	}
	public void setPrecoDoVoo(String precoDoVoo) {
		this.precoDoVoo = precoDoVoo;
	}
	public int getCapacidadeDoVoo() {
		return capacidadeDoVoo;
	}
	public void setCapacidadeDoVoo(int capacidadeDoVoo) {
		this.capacidadeDoVoo = capacidadeDoVoo;
	}
	
	

}
