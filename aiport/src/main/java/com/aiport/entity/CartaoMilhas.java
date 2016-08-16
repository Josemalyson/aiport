package com.aiport.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_JET_CARTAO_MILHAS")
public class CartaoMilhas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -779763040845906447L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CARTAO_MILHA")
	private Long id;

	@Column(name = "NU_CARTAO", unique = true, nullable = false)
	private int nuCartao;

	@Column(name = "QT_MILHA", nullable = false)
	private int quantidadeMilha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNuCartao() {
		return nuCartao;
	}

	public void setNuCartao(int nuCartao) {
		this.nuCartao = nuCartao;
	}

	public int getQuantidadeMilha() {
		return quantidadeMilha;
	}

	public void setQuantidadeMilha(int quantidadeMilha) {
		this.quantidadeMilha = quantidadeMilha;
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
		CartaoMilhas other = (CartaoMilhas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
