package br.faculdadenovaroma.tap.ecommerce.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_ORDEMPEDIDO")
public class OrdemPedido {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TB_ORDPED_COD", nullable=false)
	private long codigo;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TB_CLIENTE_ID")
	private Cliente cliente;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TB_CARRINHO_ID")
	private Carrinho carrinho;
	@Column(name="TB_ORDPED_DATACOMPRA", nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Date dataCompra;
	
	public OrdemPedido(long codigo, Cliente cliente, Carrinho carrinho, Date dataCompra) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.carrinho = carrinho;
		this.dataCompra = dataCompra;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
}
