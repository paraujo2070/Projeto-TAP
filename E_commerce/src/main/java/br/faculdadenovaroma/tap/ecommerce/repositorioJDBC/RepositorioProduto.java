package br.faculdadenovaroma.tap.ecommerce.repositorioJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.entidade.Departamento;
import br.faculdadenovaroma.tap.ecommerce.entidade.Fornecedor;
import br.faculdadenovaroma.tap.ecommerce.entidade.InformacoesProduto;
import br.faculdadenovaroma.tap.ecommerce.entidade.Produto;
import br.faculdadenovaroma.tap.ecommerce.util.JDBCUtil;

public class RepositorioProduto implements IRepositorioProdutoJDBC {

	public boolean achou(int cod) {
		return false;
	}

	public void inserir(Produto novoProduto) throws SQLException, ClassNotFoundException {
		ResultSet result;
		int idDep = 0, idFor = 0, id = 0;

		Connection conn = JDBCUtil.fabrica();

		String query = "SELECT * FROM TB_DEPARTAMENTO WHERE TB_DEP_NOME="+novoProduto.getDepartamento().getNome();
		Statement smt1 = conn.createStatement();
		
		result = smt1.executeQuery(query);
		
		if(result.next())
			idDep = result.getInt("TB_DEP_COD");
		
		
		query = "SELECT * FROM TB_INFORMACOESPRODUTO WHERE TB_INFOPROD_DESCRICAO="+novoProduto.getInformacoes().getDescricao();
		result = smt1.executeQuery(query);
		
		if(result.next())
			idFor = result.getInt("TB_FORN_ID");
		
		query = "INSERT INTO TB_PRODUTO (TB_PROD_NOME,TB_PROD_PRECO_VENDA,TB_PROD_QUANTIDADE,"
				+"TB_DEP_COD,TB_INFOPROD_ID) VALUES(?,?,?,?,?);";
		
		PreparedStatement smt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		smt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		smt.setString(1, novoProduto.getNome());
		smt.setDouble(2, novoProduto.getPrecoVenda());
		smt.setInt(3, novoProduto.getQuantidade());
		smt.setInt(4, idDep);
		smt.setInt(5, idFor);
		
		smt.executeUpdate();
		result = smt.getGeneratedKeys();
		
		if(result.next())
			id = result.getInt(1);
		
		for(Fornecedor f : novoProduto.getFornecedor()) {
			query = "INSERT INTO TB_PROD_FORN(TB_PROD_COD_FK,FORN_ID_FK) VALUES (?,?);";
			smt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			smt.setInt(0, id);
			smt.setInt(1, f.getId());
			smt.executeUpdate();
		}
		
		smt.close();
		conn.close();
	}

	public Produto consultar(String nomeProd) throws SQLException, ClassNotFoundException {
		int idDep = 0, idInf = 0;
		Produto produto = new Produto();
		Departamento departamento = new Departamento();
		InformacoesProduto informacoesProduto = new InformacoesProduto();
		
		Connection conn = JDBCUtil.fabrica();
		String query = "SELECT * FROM TB_PRODUTO WHERE TB_PROD_NOME = "+nomeProd+";";
		Statement smt = conn.createStatement();
		
		ResultSet rs = smt.executeQuery(query);
		
		if(rs.next()) {
			produto.setNome(rs.getString("TB_PROD_NOME"));
			produto.setPrecoVenda(rs.getDouble("TB_PROD_PRECO_VENDA"));
			produto.setQuantidade(rs.getInt("TB_PROD_QUANTIDADE"));
			idDep = rs.getInt("TB_DEP_COD");
			idInf = rs.getInt("TB_INFOPROD_ID");
		}
		
		query = "SELECT * FROM TB_DEPARTAMENTO WHERE TB_DEP_COD = "+idDep+";";
		rs = smt.executeQuery(query);
		
		if(rs.next()) {
			departamento.setNome(rs.getString("TB_DEP_NOME"));
			produto.setDepartamento(departamento);
		}
		
		query = "SELECT * FROM TB_INFORMACOESPRODUTO WHERE TB_INFOPROD_ID = "+idInf+";";
		rs = smt.executeQuery(query);
		
		if(rs.next()) {
			informacoesProduto.setDescricao(rs.getString("TB_INFOPROD_DESCRICAO"));
			informacoesProduto.setTipo(rs.getString("TB_INFOPROD_TIPO"));
			informacoesProduto.setProcessador(rs.getString("TB_INFOPROD_PROCESSADOR"));
			informacoesProduto.setTamanho(rs.getString("TB_INFOPROD_TAMANHO"));
			informacoesProduto.setTela(rs.getString("TB_INFOPROD_TELA"));
			informacoesProduto.setMegaPixels(rs.getString("TB_INFOPROD_MEGAPIXELS"));
			informacoesProduto.setMemoria(rs.getString("TB_INFOPROD_MEMORIA"));
			informacoesProduto.setPlacaGrafica(rs.getString("TB_INFOPROD_PLACAGRAFICA"));
			informacoesProduto.setArmazenamento(rs.getString("TB_INFOPROD_ARMAZENAMENTO"));
			informacoesProduto.setVelocidade(rs.getString("TB_INFOPROD_VELOCIDADE"));
			informacoesProduto.setPotencia(rs.getString("TB_INFOPROD_POTENCIA"));
			informacoesProduto.setMarca(rs.getString("TB_INFOPROD_MARCA"));
			
			produto.setInformacoes(informacoesProduto);
		}
		
		smt.close();
		conn.close();
		
		return produto;
	}

	public ArrayList<Produto> listar() throws ClassNotFoundException, SQLException {
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		Connection conn = JDBCUtil.fabrica();
		String query = "SELECT * FROM TB_PRODUTO;";
		Statement smt = conn.createStatement();
		
		ResultSet rs = smt.executeQuery(query);
		
		while(rs.next()) {
			int idDep = 0, idInf = 0;
			Produto produto = new Produto();
			Departamento departamento = new Departamento();
			InformacoesProduto informacoesProduto = new InformacoesProduto();
			
			idDep = rs.getInt("TB_DEP_COD");
			idInf = rs.getInt("TB_INFOPROD_ID");
			
			query = "SELECT * FROM TB_DEPARTAMENTO WHERE TB_DEP_COD="+idDep+";";
			ResultSet rs2 = smt.executeQuery(query);
			
			if(rs2.next()) {
				departamento.setNome(rs2.getString(""));
			}
			
			query = "SELECT * FROM TB_INFORMACOESPRODUTO WHERE TB_INFOPROD_ID = "+idInf+";";
			rs2 = smt.executeQuery(query);
			
			if(rs.next()) {
				informacoesProduto.setDescricao(rs.getString("TB_INFOPROD_DESCRICAO"));
				informacoesProduto.setTipo(rs.getString("TB_INFOPROD_TIPO"));
				informacoesProduto.setProcessador(rs.getString("TB_INFOPROD_PROCESSADOR"));
				informacoesProduto.setTamanho(rs.getString("TB_INFOPROD_TAMANHO"));
				informacoesProduto.setTela(rs.getString("TB_INFOPROD_TELA"));
				informacoesProduto.setMegaPixels(rs.getString("TB_INFOPROD_MEGAPIXELS"));
				informacoesProduto.setMemoria(rs.getString("TB_INFOPROD_MEMORIA"));
				informacoesProduto.setPlacaGrafica(rs.getString("TB_INFOPROD_PLACAGRAFICA"));
				informacoesProduto.setArmazenamento(rs.getString("TB_INFOPROD_ARMAZENAMENTO"));
				informacoesProduto.setVelocidade(rs.getString("TB_INFOPROD_VELOCIDADE"));
				informacoesProduto.setPotencia(rs.getString("TB_INFOPROD_POTENCIA"));
				informacoesProduto.setMarca(rs.getString("TB_INFOPROD_MARCA"));
			}
			
			produto.setNome(rs.getString("TB_PROD_NOME"));
			produto.setPrecoVenda(rs.getDouble("TB_PROD_PRECO_VENDA"));
			produto.setQuantidade(rs.getInt("TB_PROD_QUANTIDADE"));
			produto.setDepartamento(departamento);
			produto.setInformacoes(informacoesProduto);
			
			produtos.add(produto);
		}
		
		smt.close();
		conn.close();
		
		return produtos;
	}

	public void alterar(Produto produto) throws ClassNotFoundException, SQLException {
		int id = 0;
		
		Connection conn = JDBCUtil.fabrica();
		String query = "UPDATE TB_PRODUTO SET TB_PROD_PRECO_VENDA="+produto.getPrecoVenda()
				+",TB_PROD_QUANTIDADE="+produto.getQuantidade()
				+" WHERE TB_PROD_NOME="+produto.getNome()+";";
		
		PreparedStatement smt = conn.prepareStatement(query);
		smt.executeUpdate();
		
		query = "SELECT * FROM TB_PRODUTO WHERE TB_PROD_NOME="+produto.getNome()+";";
		ResultSet rs = smt.executeQuery(query);
		
		if(rs.next())
			id = rs.getInt("TB_INFOPROD_ID");
		
		query = "UPDATE TB_INFORMACOESPRODUTO SET TB_INFOPROD_DESCRICAO="+produto.getInformacoes().getDescricao()
				+",TB_INFOPROD_TIPO="+produto.getInformacoes().getTipo()
				+",TB_INFOPROD_PROCESSADOR="+produto.getInformacoes().getProcessador()
				+",TB_INFOPROD_TAMANHO="+produto.getInformacoes().getTamanho()
				+",TB_INFOPROD_TELA="+produto.getInformacoes().getTela()
				+",TB_INFOPROD_MEGAPIXELS="+produto.getInformacoes().getMegaPixels()
				+",TB_INFOPROD_MEMORIA="+produto.getInformacoes().getMemoria()
				+",TB_INFOPROD_PLACAGRAFICA="+produto.getInformacoes().getPlacaGrafica()
				+",TB_INFOPROD_ARMAZENAMENTO="+produto.getInformacoes().getArmazenamento()
				+",TB_INFOPROD_VELOCIDADE="+produto.getInformacoes().getVelocidade()
				+",TB_INFOPROD_POTENCIA="+produto.getInformacoes().getPotencia()
				+",TB_INFOPROD_MARCA="+produto.getInformacoes().getMarca()
				+" WHERE TB_INFOPROD_ID="+id+";";
		
		smt.executeQuery(query);
		
		smt.close();
		conn.close();
	}
	
	public void excluir(String nome) throws ClassNotFoundException, SQLException {
		int idDep = 0, idInf = 0, idProd = 0;
		Connection conn = JDBCUtil.fabrica();
		String query = "SELECT * FROM TB_PRODUTO WHERE TB_PROD_NOME = "+nome+";";
		Statement smt = conn.createStatement();
		
		ResultSet rs = smt.executeQuery(query);
		
		if(rs.next()) {
			idProd = rs.getInt("TB_PROD_COD");
			idDep = rs.getInt("TB_DEP_COD");
			idInf = rs.getInt("TB_INFOPROD_ID");
		}
		
		query = "DELETE FROM TB_DEPARTAMENTO WHERE TB_DEP_COD = "+idDep+";";
		smt.executeQuery(query);
		query = "DELETE FROM TB_INFORMACOESPRODUTO WHERE TB_INFOPROD_ID = "+idInf+";";
		smt.executeQuery(query);
		query = "DELETE FROM TB_PROD_FORN WHERE TB_PROD_ID = "+idProd+";";
		smt.executeQuery(query);
	
		smt.close();
		conn.close();		
	}
}

