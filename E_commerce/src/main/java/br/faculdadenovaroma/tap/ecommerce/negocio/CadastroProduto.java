package br.faculdadenovaroma.tap.ecommerce.negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.entidade.Produto;
import br.faculdadenovaroma.tap.ecommerce.repositorioJDBC.IRepositorioProdutoJDBC;

public class CadastroProduto {
	private IRepositorioProdutoJDBC repProduto;
	
	public CadastroProduto(IRepositorioProdutoJDBC repProduto) {
		if (repProduto == null)
			System.out.println("Error...");
		else
			this.repProduto = repProduto;
	}
	
	public void inserir(Produto novoProduto) throws SQLException, ClassNotFoundException {
		if(!this.repProduto.achou(novoProduto.getCodigo())) {
			this.repProduto.inserir(novoProduto);
		}else
			System.out.println("Error");
			//throw new EncontradoException("Usuário "+usuario.getNome()+" já cadastrado!");
	}
	
	public Produto consultar(String nome, int codigo) throws SQLException, ClassNotFoundException {
		Produto produto = null;

		if(this.repProduto.achou(codigo)) {
			produto = this.repProduto.consultar(nome);
		}else
			System.out.println("Error");
			//throw new UsuarioNaoEncontradoException("Usuário "+userName+" não está cadastrado!");

		return produto;
	}
	
	public ArrayList<Produto> listar() throws SQLException, ClassNotFoundException {
		return this.repProduto.listar();
	}
	
	public void alterar(Produto produto, int codigo) throws SQLException, ClassNotFoundException {
		if(this.repProduto.achou(produto.getCodigo())) {
			this.repProduto.alterar(produto);
		}else
			System.out.println("Error");
			//throw new NaoEncontradoException("Usuário "+usuario.getNome()+" não está cadastrado!");		
	}
	
	public void excluir(Produto produto) throws SQLException, ClassNotFoundException {
		if(this.repProduto.achou(produto.getCodigo())) {
			this.repProduto.excluir(produto.getNome());
		}else
			System.out.println("Error");
			//throw new NaoEncontradoException("Usuário "+usuario.getNome()+" não está cadastrado!");
	}
}