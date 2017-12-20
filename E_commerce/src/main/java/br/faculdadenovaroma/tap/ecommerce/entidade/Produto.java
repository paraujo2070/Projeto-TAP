package br.faculdadenovaroma.tap.ecommerce.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_PRODUTO")
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TB_PROD_COD", nullable=false)
	private int codigo;
	@Column(name="TB_PROD_NOME", nullable=false)
	private String nome;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TB_DEP_COD")
	private Departamento departamento;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TB_INFOPROD_ID")
	private InformacoesProduto informacoes;
	
	@ManyToMany
	@JoinTable(
			name="TB_PROD_FORN",
			joinColumns=@JoinColumn(name="TB_PROD_COD_FK", referencedColumnName="TB_PROD_COD"),
			inverseJoinColumns=@JoinColumn(name="FORN_ID_FK", referencedColumnName="TB_FORN_ID"))
	private List<Fornecedor> fornecedor;
	
	@Column(name="TB_PROD_PRECO_VENDA", nullable=false)
	private double precoVenda;
	@Column(name="TB_PROD_QUANTIDADE", nullable=false)
	private int quantidade;
	
	@Column(name="TB_PROD_VALORUNIT", nullable=false)
	private double valorUnit;
	@Column(name="TB_PROD_QTD_ESTOQUE", nullable=false)
	private int qtdEstoque;
	
	public Produto() {}
	
	public Produto(int codigo, String nome, Departamento departamento, InformacoesProduto informacoes,
			Fornecedor fornecedor, double precoVenda, int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.departamento = departamento;
		this.informacoes = informacoes;
		this.fornecedor.add(fornecedor);
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public InformacoesProduto getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(InformacoesProduto informacoes) {
		this.informacoes = informacoes;
	}
	public List<Fornecedor> getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor.add(fornecedor);
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	
	public double getValorUnit() {
		return valorUnit;
	}
	
	public void setValorUnit(double valorUnit) {
		this.valorUnit = valorUnit;
	}
}