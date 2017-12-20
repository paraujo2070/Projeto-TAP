package br.faculdadenovaroma.tap.ecommerce.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="TB_CLIENTE")
public class Cliente implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TB_CLIENTE_ID", nullable=false)
	private long id;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TB_PESSOA_ID")
	private Pessoa pessoa;
	@Column(name="TB_CLIENTE_USER", nullable=false)
	private String user;
	@Column(name="TB_CLIENTE_PASSWORD", nullable=false)
	private String password;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="cliente")
	private OrdemPedido ordemPedido;
	
	public Cliente() {}
	
	public Cliente(Pessoa pessoa, String user, String password) {
		// TODO Auto-generated constructor stub
		this.pessoa = pessoa;
		this.user = user;
		this.password = password;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Cliente [user=" + user + ", password=" + password + "]";
	}
}
