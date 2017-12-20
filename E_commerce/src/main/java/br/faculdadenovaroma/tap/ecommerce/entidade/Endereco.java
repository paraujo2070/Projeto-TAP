package br.faculdadenovaroma.tap.ecommerce.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "TB_ENDERECO")
public class Endereco {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TB_ENDERECO_ID", nullable=false)
	private int id;
	@Column(name="TB_ENDERECO_RUA", nullable=false)
	private String rua;
	@Column(name="TB_ENDERECO_NUMERO", nullable=false)
	private int numero;
	@Column(name="TB_ENDERECO_COMPLEMENTO", nullable=false)
	private String complemento;
	@Column(name="TB_ENDERECO_CEP", nullable=false)
	private int cep;
	@Column(name="TB_ENDERECO_BAIRRO", nullable=false)
	private String bairro;
	@Column(name="TB_ENDERECO_CIDADE", nullable=false)
	private String cidade;
	@Column(name="TB_ENDERECO_ESTADO", nullable=false)
	private String estado;
	@Column(name="TB_ENDERECO_PAIS", nullable=false)
	private String pais;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="endereco")
	private Pessoa pessoa;
	@OneToOne(fetch=FetchType.LAZY, mappedBy="endereco")
	private Fornecedor fornecedor;
	
	public Endereco() {}
	
	public Endereco(String rua, int numero, String complemento, int cep, String bairro, String cidade, String estado,
			String pais) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais + "]";
	}
}
