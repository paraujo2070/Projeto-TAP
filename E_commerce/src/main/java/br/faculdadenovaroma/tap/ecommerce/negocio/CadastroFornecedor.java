package br.faculdadenovaroma.tap.ecommerce.negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.entidade.Fornecedor;
import br.faculdadenovaroma.tap.ecommerce.repositorioJDBC.IRepositorioFornecedorJDBC;

public class CadastroFornecedor {
	private IRepositorioFornecedorJDBC repFornecedor;
	
	public CadastroFornecedor(IRepositorioFornecedorJDBC repFornecedor) {
		if (repFornecedor == null)
			System.out.println("Error...");
		else
			this.repFornecedor = repFornecedor;
	}
	
	public void inserir(Fornecedor novoFornecedor) throws SQLException, ClassNotFoundException {
		if(!this.repFornecedor.achou(novoFornecedor.getCnpj())) {
			this.repFornecedor.inserir(novoFornecedor);
		}else
			System.out.println("Error");
			//throw new EncontradoException("Usuário "+usuario.getNome()+" já cadastrado!");
	}
	
	public Fornecedor consultar(String cnpj) throws SQLException, ClassNotFoundException {
		Fornecedor fornecedor = null;

		if(this.repFornecedor.achou(cnpj)) {
			fornecedor = this.repFornecedor.consultar(cnpj);
		}else
			System.out.println("Error");
			//throw new UsuarioNaoEncontradoException("Usuário "+userName+" não está cadastrado!");

		return fornecedor;
	}
	
	public ArrayList<Fornecedor> listar() throws SQLException, ClassNotFoundException {
		return this.repFornecedor.listar();
	}
	
	public void alterar(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
		if(this.repFornecedor.achou(fornecedor.getCnpj())) {
			this.repFornecedor.alterar(fornecedor);
		}else
			System.out.println("Error");
			//throw new NaoEncontradoException("Usuário "+usuario.getNome()+" não está cadastrado!");		
	}
	
	public void excluir(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
		if(this.repFornecedor.achou(fornecedor.getCnpj())) {
			this.repFornecedor.excluir(fornecedor.getCnpj());
		}else
			System.out.println("Error");
			//throw new NaoEncontradoException("Usuário "+usuario.getNome()+" não está cadastrado!");
	}
}