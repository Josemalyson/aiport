package com.aiport.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_JET_AERONAVE")
public class Aeronave implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -779763040845906447L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_AERONAVE")
	private Long id;

	@Column(name = "DS_MODELO", unique=true, nullable = false)
	private String descricaoModelo;

	@Column(name = "NU_QUANTIDADE", nullable = false)
	private int qtdAssento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoModelo() {
		return descricaoModelo;
	}

	public void setDescricaoModelo(String descricaoModelo) {
		this.descricaoModelo = descricaoModelo;
	}

	public int getQtdAssento() {
		return qtdAssento;
	}

	public void setQtdAssento(int qtdAssento) {
		this.qtdAssento = qtdAssento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeronave other = (Aeronave) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
