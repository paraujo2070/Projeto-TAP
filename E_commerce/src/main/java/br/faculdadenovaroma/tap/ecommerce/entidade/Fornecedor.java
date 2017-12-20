package br.faculdadenovaroma.tap.ecommerce.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "TB_FORNECEDOR")
public class Fornecedor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TB_FORN_ID", nullable=false)
	private int id;
	@Column(name="TB_FORN_NOME", nullable=false)
	private String nome;
	@Column(name="TB_FORN_SIGLA", nullable=false)
	private String sigla;
	@Column(name="TB_FORN_CNPJ", nullable=false)
	private String cnpj;
	@Column(name="TB_FORN_NOMEREPRESENTANTE", nullable=false)
	private String nomeRepresentante;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TB_ENDERECO_ID")
	private Endereco endereco;
	@Column(name="TB_FORN_TELEFONE", nullable=false)
	private String telefone;
	@Column(name="TB_FORN_EMAIL", nullable=false)
	private String email;
	
	public Fornecedor() {}
	
	public Fornecedor(String nome, String sigla, String cnpj, String nomeRepresentante, Endereco endereco, String telefone,
			String email) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.cnpj = cnpj;
		this.nomeRepresentante = nomeRepresentante;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeRepresentante() {
		return nomeRepresentante;
	}

	public void setNomeRepresentante(String nomeRepresentante) {
		this.nomeRepresentante = nomeRepresentante;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Fornecedor [nome=" + nome + ", cnpj=" + cnpj + ", nomeRepresentante=" + nomeRepresentante
				+ ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + "]";
	}
}
