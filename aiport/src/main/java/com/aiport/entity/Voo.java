package com.aiport.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_JET_VOO")
public class Voo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -779763040845906447L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_VOO")
	private Long id;

	@Column(name = "NU_QUILOMETRAGEM", nullable = false)
	private Integer quilometragem;
	
	@Column(name = "NU_MINUTOS_DURACAO", nullable = false)
	private Integer minutosDuracao;
	
	@Column(name = "NU_PRECO", nullable = false)
	private BigDecimal preco;
	
	@Column(name = "DT_HORA_PARTIDA", nullable = false)
	private Date dataPartida;

	@ManyToOne
	@JoinColumn(name = "FK_AERONAVE", nullable = false)
	private Aeronave aeronave;
	
	@ManyToOne
	@JoinColumn(name = "FK_CIDADE_DESTINO", nullable = false)
	private Cidade destino;
	
	@ManyToOne
	@JoinColumn(name = "FK_CIDADE_ORIGEM", nullable = false)
	private Cidade origem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Integer getMinutosDuracao() {
		return minutosDuracao;
	}

	public void setMinutosDuracao(Integer minutosDuracao) {
		this.minutosDuracao = minutosDuracao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Date getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}

	public Aeronave getAeronave() {
		return aeronave;
	}

	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}

	public Cidade getDestino() {
		return destino;
	}

	public void setDestino(Cidade destino) {
		this.destino = destino;
	}

	public Cidade getOrigem() {
		return origem;
	}

	public void setOrigem(Cidade origem) {
		this.origem = origem;
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
		Voo other = (Voo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
