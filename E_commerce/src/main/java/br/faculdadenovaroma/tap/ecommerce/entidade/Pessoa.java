package br.faculdadenovaroma.tap.ecommerce.entidade;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@MappedSuperclass
@Entity
@Table(name="TB_PESSOA")
public class Pessoa {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TB_PESSOA_ID", nullable=false)	
	private int id;
	@Column(name="TB_PESSOA_NOME", nullable=false)
	private String nome;
	@Column(name="TB_PESSOA_CPF", nullable=false)
	private String cpf;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TB_ENDERECO_ID")
	private Endereco endereco;
	@Column(name="TB_PESSOA_TELEFONE", nullable=false)
	private String telefone;
	@Column(name="TB_PESSOA_CELULAR", nullable=true)
	private String celular;
	@Column(name="TB_PESSOA_EMAIL", nullable=false)
	private String email;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="pessoa")
	private Cliente cliente;
	@OneToOne(fetch=FetchType.LAZY, mappedBy="pessoa")
	private Funcionario funcionario;
	
	public Pessoa() {}
	
	public Pessoa(String nome, String cpf, Endereco endereco, String telefone, String celular, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
