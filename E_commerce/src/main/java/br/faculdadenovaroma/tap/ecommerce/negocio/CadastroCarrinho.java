package br.faculdadenovaroma.tap.ecommerce.negocio;

import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.repositorioJDBC.IRepositorioCarrinhoJDBC;

public class CadastroCarrinho {
	private IRepositorioCarrinhoJDBC repCarrinho;
	
/*	public CadastroCarrinho(IRepositorioCarrinhoJDBC repCarrinho) {
		if (repCarrinho == null)
			System.out.println("Error...");
		else
			this.repCarrinho = repCarrinho;
	}
	
	public void inserir(Carrinho novoCarrinho) {
		if(!this.repCarrinho.achou(novoCarrinho.getCpf())) {
			this.repCarrinho.inserir(novoCliente);
		}else
			System.out.println("Error");
			//throw new EncontradoException("Usuário "+usuario.getNome()+" já cadastrado!");
	}
	
	public Cliente consultar(String cpf) {
		Cliente cliente = null;

		if(this.repCarrinho.achou(cpf)) {
			cliente = this.repCarrinho.consultar(cpf);
		}else
			System.out.println("Error");
			//throw new UsuarioNaoEncontradoException("Usuário "+userName+" não está cadastrado!");

		return cliente;
	}
	
	public ArrayList<Cliente> listar() {
		return this.repCarrinho.listar();
	}
	
	public void alterar(Cliente cliente, String cpf) {
		if(this.repCarrinho.achou(cpf)) {
			this.repCarrinho.alterar(cliente);
		}else
			System.out.println("Error");
			//throw new NaoEncontradoException("Usuário "+usuario.getNome()+" não está cadastrado!");		
	}
	
	public void excluir(Cliente cliente, String cpf) {
		if(this.repCarrinho.achou(cpf)) {
			this.repCarrinho.excluir(cliente);
		}else
			System.out.println("Error");
			//throw new NaoEncontradoException("Usuário "+usuario.getNome()+" não está cadastrado!");
	}*/
}