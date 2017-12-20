package br.faculdadenovaroma.tap.ecommerce.repositorioJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.faculdadenovaroma.tap.ecommerce.entidade.Carrinho;

import br.faculdadenovaroma.tap.ecommerce.entidade.Departamento;
import br.faculdadenovaroma.tap.ecommerce.entidade.InformacoesProduto;

import br.faculdadenovaroma.tap.ecommerce.entidade.Produto;
import br.faculdadenovaroma.tap.ecommerce.util.JDBCUtil;

public class RepositorioCarrinho implements IRepositorioCarrinhoJDBC {
	public boolean achou(String cpf) {
		return false;
	}

	public void inserir(Produto produto) throws SQLException, ClassNotFoundException {
		int idCarrinho = 0;
		Carrinho car = new Carrinho();
		car.setProdutos(produto);
		
		Connection conn = JDBCUtil.fabrica();
		String query = "INSERT INTO TB_CARRINHO (TB_CARRINHO_VALORTOTAL) VALUES(?)";
		
		double valor = produto.getPrecoVenda() * produto.getQuantidade();

		PreparedStatement smt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		smt.setDouble(1, valor);
		
		smt.executeUpdate();
		
		ResultSet rs = smt.getGeneratedKeys();
		
		if(rs.next())
			idCarrinho = rs.getInt("TB_CARRINHO_ID");
		
		List<Produto> produtos = car.getProdutos();
		
		for(Produto prod : produtos) {
			int idProd = 0;
			query = "SELECT * FROM TB_PRODUTO WHERE TB_PROD_COD="+prod.getCodigo()+";";
			Statement smt2 = conn.createStatement();
			rs = smt2.executeQuery(query);
			
			if(rs.next()) {
				idProd = rs.getInt("TB_PROD_COD");
			}
			
			query = "INSERT INTO TB_CARR_PROD(TB_CAR_COD_FK,TB_PROD_ID_FK) VALUES (?,?);";
			smt = conn.prepareStatement(query);
			
			smt.setInt(1, idCarrinho);
			smt.setInt(2, idProd);
			
			smt.executeUpdate();
		}
		
		smt.close();
		conn.close();
	}

	public Carrinho listar() throws ClassNotFoundException, SQLException {
		Carrinho car = new Carrinho();
		
		Connection conn = JDBCUtil.fabrica();
		String query = "SELECT * FROM TB_PRODUTO";
		Statement smt = conn.createStatement();
		
		ResultSet rs = smt.executeQuery(query);
		
		while(rs.next()) {
			Produto produto = new Produto();
			Departamento departamento = new Departamento();
			InformacoesProduto informacoesFornecedor = new InformacoesProduto();
			
			query = "SELECT * FROM TB_DEPARTAMENTO WHERE TB_DEP_COD="+rs.getInt("TB_DEP_COD");
			ResultSet rs2 = smt.executeQuery(query);
			
			if(rs2.next()) {
				departamento.setCodigo(rs2.getInt("TB_DEP_COD"));
				departamento.setNome("TB_DEP_NOME");
			}
			
			query = "SELECT * FROM TB_FORNECEDOR WHERE TB_DEP_COD="+rs.getInt("TB_INFOPROD_ID");
			rs2 = smt.executeQuery(query);
			
			if(rs2.next()) {
				informacoesFornecedor.setId(rs2.getInt("TB_INFOPROD_ID"));
				informacoesFornecedor.setArmazenamento(rs2.getString("TB_INFOPROD_ARMAZENAMENTO"));
				informacoesFornecedor.setDescricao(rs2.getString("TB_INFOPROD_DESCRICAO"));
				informacoesFornecedor.setMarca(rs2.getString("TB_INFOPROD_MARCA"));
				informacoesFornecedor.setMegaPixels(rs2.getString("TB_INFOPROD_MEGAPIXELS"));
				informacoesFornecedor.setMemoria(rs2.getString("TB_INFOPROD_MEMORIA"));
				informacoesFornecedor.setPlacaGrafica(rs2.getString("TB_INFOPROD_PLACAGRAFICA"));
				informacoesFornecedor.setPotencia(rs2.getString("TB_INFOPROD_POTENCIA"));
				informacoesFornecedor.setProcessador(rs2.getString("TB_INFOPROD_PROCESSADOR"));
				informacoesFornecedor.setTamanho(rs2.getString("TB_INFOPROD_TAMANHO"));
				informacoesFornecedor.setTela(rs2.getString("TB_INFOPROD_TELA"));
				informacoesFornecedor.setTipo(rs2.getString("TB_INFOPROD_TIPO"));
				informacoesFornecedor.setVelocidade(rs2.getString("TB_INFOPROD_VELOCIDADE"));
			}
			
			produto.setCodigo(rs.getInt("TB_PROD_COD"));
			produto.setNome(rs.getString("TB_PROD_NOME"));
			produto.setPrecoVenda(rs.getDouble("TB_PROD_PRECO_VENDA"));
			produto.setQtdEstoque(rs.getInt("TB_PROD_QTD_ESTOQUE"));
			produto.setQuantidade(rs.getInt("TB_PROD_QUANTIDADE"));
			produto.setValorUnit(rs.getDouble("TB_PROD_VALORUNIT"));
			produto.setDepartamento(departamento);
			produto.setInformacoes(informacoesFornecedor);
			
			car.setProdutos(produto);;
		}
		
		smt.close();
		conn.close();
		
		return car;
	}

	public void alterar(Produto produto, int qtd) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.fabrica();
		String query = "UPDATE TB_PRODUTO SET TB_PROD_QUANTIDADE="+qtd
				+" TB_PROD_COD="+produto.getCodigo()+";";
		
		Statement smt = conn.createStatement();
		smt.executeQuery(query);
		
		smt.close();
		conn.close();
	}
	
	public void excluir(Produto produto) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.fabrica();
		String query = "DELETE FROM TB_CARR_PROD WHERE TB_PROD_ID_FK = "+produto.getCodigo()+";";
		Statement smt = conn.createStatement();
		
		smt.executeQuery(query);
					
		smt.close();
		conn.close();
	}

    
    public Carrinho consultar(String nome) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
