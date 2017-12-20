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
@Table(name="TB_INFORMACOESPRODUTO")
public class InformacoesProduto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TB_INFOPROD_ID", nullable=false)
	private int id;
	
	@Column(name="TB_INFOPROD_DESCRICAO", nullable=true)
	private String descricao;
	@Column(name="TB_INFOPROD_TIPO", nullable=true)
	private String tipo;
	@Column(name="TB_INFOPROD_PROCESSADOR", nullable=true)
	private String processador;
	@Column(name="TB_INFOPROD_TAMANHO", nullable=true)
	private String tamanho;
	@Column(name="TB_INFOPROD_TELA", nullable=true)
	private String tela;
	@Column(name="TB_INFOPROD_MEGAPIXELS", nullable=true)
	private String megaPixels;
	@Column(name="TB_INFOPROD_MEMORIA", nullable=true)
	private String memoria;
	@Column(name="TB_INFOPROD_PLACAGRAFICA", nullable=true)
	private String placaGrafica;
	@Column(name="TB_INFOPROD_ARMAZENAMENTO", nullable=true)
	private String armazenamento;
	@Column(name="TB_INFOPROD_VELOCIDADE", nullable=true)
	private String velocidade;
	@Column(name="TB_INFOPROD_POTENCIA", nullable=true)
	private String potencia;
	@Column(name="TB_INFOPROD_MARCA", nullable=true)
	private String marca;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="informacoes")
	private Produto produto;
	
	public InformacoesProduto() {}
	
	public InformacoesProduto(String descricao, String tipo, String processador, String tamanho, String tela,
			String megaPixels, String memoria, String placaGrafica, String armazenamento, String velocidade,
			String potencia, String marca) {
		super();
		this.descricao = descricao;
		this.tipo = tipo;
		this.processador = processador;
		this.tamanho = tamanho;
		this.tela = tela;
		this.megaPixels = megaPixels;
		this.memoria = memoria;
		this.placaGrafica = placaGrafica;
		this.armazenamento = armazenamento;
		this.velocidade = velocidade;
		this.potencia = potencia;
		this.marca = marca;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getTela() {
		return tela;
	}

	public void setTela(String tela) {
		this.tela = tela;
	}

	public String getMegaPixels() {
		return megaPixels;
	}

	public void setMegaPixels(String megaPixels) {
		this.megaPixels = megaPixels;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getPlacaGrafica() {
		return placaGrafica;
	}

	public void setPlacaGrafica(String placaGrafica) {
		this.placaGrafica = placaGrafica;
	}

	public String getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(String armazenamento) {
		this.armazenamento = armazenamento;
	}

	public String getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(String velocidade) {
		this.velocidade = velocidade;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
