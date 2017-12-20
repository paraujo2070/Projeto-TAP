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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_CARRINHO")
public class Carrinho {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TB_CARRINHO_ID", nullable=false)
	private int id;
	@ManyToMany
	@JoinTable(
			name="TB_CARR_PROD",
			joinColumns=@JoinColumn(name="TB_CAR_COD_FK", referencedColumnName="TB_CARRINHO_ID"),
			inverseJoinColumns=@JoinColumn(name="TB_PROD_ID_FK", referencedColumnName="TB_PROD_COD"))
	private List<Produto> produtos;
	@Column(name="TB_CARRINHO_VALORTOTAL", nullable=false)
	private double valorTotal;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="carrinho")
	private OrdemPedido ordemPedido;
	
	public Carrinho() {}

	public Carrinho(Produto produto, int quantidade, double valorTotal) {
		super();
		this.produtos.add(produto);
		this.valorTotal = valorTotal;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(Produto produtos) {
		this.produtos.add(produtos);
	}
		
	public double getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal ;
	}
}