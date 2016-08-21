package com.aiport.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_JET_USUARIO")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -779763040845906447L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USUARIO")
	private Long id;

	@Column(name = "DS_NOME", nullable = false)
	@NotBlank(message = "Campo nome obrigatório")
	private String nome;
	
	@Column(name = "NU_DOCUMENTO", nullable = false)
	@NotBlank(message = "Campo Numero de documento obrigatório")
	private String numeroDocumento;
	
	@Column(name = "DT_NASCIMENTO", nullable = false)
	private Date dataNascimento;

	@ManyToOne
	@JoinColumn(name = "FK_TIPO_DOCUMENTO", nullable = false)
	private TipoDocumento tipoDocumento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_CARTAO_MILHA", nullable = false)
	private CartaoMilhas cartaoMilha;
	
	@ManyToOne
	@JoinColumn(name = "FK_PERFIL", nullable = false)
	private PerfilUsuario perfil;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_LOGIN", nullable = false)
	private Login login;
	
	public Usuario() {
		this.login = new Login();
		this.perfil = new PerfilUsuario();
		this.tipoDocumento = new TipoDocumento();
		this.cartaoMilha = new CartaoMilhas();
		this.setTipoDocumento(this.tipoDocumento);
		this.setCartaoMilha(this.cartaoMilha);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public CartaoMilhas getCartaoMilha() {
		return cartaoMilha;
	}

	public void setCartaoMilha(CartaoMilhas cartaoMilha) {
		this.cartaoMilha = cartaoMilha;
	}

	public PerfilUsuario getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilUsuario perfil) {
		this.perfil = perfil;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
