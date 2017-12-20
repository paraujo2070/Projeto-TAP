package br.faculdadenovaroma.tap.ecommerce.repositorioJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.entidade.Endereco;
import br.faculdadenovaroma.tap.ecommerce.entidade.Fornecedor;
import br.faculdadenovaroma.tap.ecommerce.util.JDBCUtil;

public class RepositorioFornecedor implements IRepositorioFornecedorJDBC {

	public boolean achou(String cpf) {
		return false;
	}


	public void inserir(Fornecedor novoFornecedor) throws SQLException, ClassNotFoundException {
		ResultSet result;
		int id = 0;
		
		Connection conn = JDBCUtil.fabrica();

		String query = "INSERT INTO TB_ENDERECO (TB_ENDERECO_RUA,TB_ENDERECO_NUMERO,TB_ENDERECO_COMPLEMENTO,"
				+ "TB_ENDERECO_CEP,TB_ENDERECO_BAIRRO,TB_ENDERECO_CIDADE,TB_ENDERECO_ESTADO,TB_ENDERECO_PAIS)"
				+ "VALUES(?,?,?,?,?,?,?,?)";


		PreparedStatement smt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		smt.setString(1, novoFornecedor.getEndereco().getRua());
		smt.setInt(2, novoFornecedor.getEndereco().getNumero());
		smt.setString(3, novoFornecedor.getEndereco().getComplemento());
		smt.setInt(4, novoFornecedor.getEndereco().getCep());
		smt.setString(5, novoFornecedor.getEndereco().getBairro());
		smt.setString(6, novoFornecedor.getEndereco().getCidade());
		smt.setString(7, novoFornecedor.getEndereco().getEstado());
		smt.setString(8, novoFornecedor.getEndereco().getPais());

		

		smt.executeUpdate();
		result = smt.getGeneratedKeys();
		
		if(result.next())
			id = result.getInt(1);

		
		query = "INSERT INTO TB_FORNECEDOR(TB_FORN_CNPJ,TB_FORN_EMAIL,TB_FORN_NOME,"
				+ "TB_FORN_NOMEREPRESENTANTE,TB_FORN_SIGLA,TB_FORN_TELEFONE,TB_ENDERECO_ID)"
				+ "VALUES (?,?,?,?,?,?,?);";
		smt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		smt.setString(1, novoFornecedor.getCnpj());
		smt.setString(2, novoFornecedor.getEmail());
		smt.setString(3, novoFornecedor.getNome());

		smt.setString(4, novoFornecedor.getNomeRepresentante());
		smt.setString(5, novoFornecedor.getSigla());
		smt.setString(6, novoFornecedor.getTelefone());

		smt.setInt(7, id);

		smt.executeUpdate();

		smt.close();
		conn.close();
	}

	public Fornecedor consultar(String cnpj) throws SQLException, ClassNotFoundException {

		int idFK = 0;
		Fornecedor fornecedor = new Fornecedor();
		Endereco endereco = new Endereco();

		Connection conn = JDBCUtil.fabrica();
		String query = "SELECT * FROM TB_FORNECEDOR WHERE TB_FORN_CNPJ = "+cnpj+";";
		Statement smt = conn.createStatement();
		
		ResultSet rs = smt.executeQuery(query);
		
		if(rs.next()) {
			fornecedor.setCnpj(rs.getString("TB_FORN_CNPJ"));
			fornecedor.setEmail(rs.getString("TB_FORN_EMAIL"));
			fornecedor.setNome(rs.getString("TB_FORN_NOME"));
			fornecedor.setNomeRepresentante(rs.getString("TB_FORN_NOMEREPRESENTANTE"));
			fornecedor.setSigla(rs.getString("TB_FORN_SIGLA"));
			fornecedor.setTelefone(rs.getString("TB_FORN_TELEFONE"));
			idFK = rs.getInt("TB_ENDERECO_ID");
		}
		
		query = "SELECT * FROM TB_ENDERECO WHERE TB_ENDERECO_ID = "+idFK+";";
		rs = smt.executeQuery(query);
		
		if(rs.next()) {
			endereco.setRua(rs.getString("TB_ENDERECO_RUA"));
			endereco.setComplemento(rs.getString("TB_ENDERECO_COMPLEMENTO"));
			endereco.setNumero(rs.getInt("TB_ENDERECO_NUMERO"));
			endereco.setCep(rs.getInt("TB_ENDERECO_CEP"));
			endereco.setBairro(rs.getString("TB_ENDERECO_BAIRRO"));
			endereco.setCidade(rs.getString("TB_ENDERECO_CIDADE"));
			endereco.setEstado(rs.getString("TB_ENDERECO_ESTADO"));
			endereco.setPais(rs.getString("TB_ENDERECO_PAIS"));
			fornecedor.setEndereco(endereco);
		}
		
		smt.close();
		conn.close();
		
		return fornecedor;
	}

	public ArrayList<Fornecedor> listar() throws ClassNotFoundException, SQLException {
		ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		
		Connection conn = JDBCUtil.fabrica();
		String query = "SELECT * FROM TB_FORNECEDOR";
		Statement smt = conn.createStatement();
		
		ResultSet rs = smt.executeQuery(query);
		
		while(rs.next()) {
			Fornecedor fornecedor = new Fornecedor();
			Endereco endereco = new Endereco();
			
			int idFK = rs.getInt("TB_ENDERECO_ID");
			query = "SELECT * FROM TB_ENDERECO WHERE TB_ENDERECO_ID = "+idFK+";";
			ResultSet rs2 = smt.executeQuery(query);
			
			if(rs2.next()) {
				endereco.setRua(rs.getString("TB_ENDERECO_RUA"));
				endereco.setComplemento(rs.getString("TB_ENDERECO_COMPLEMENTO"));
				endereco.setNumero(rs.getInt("TB_ENDERECO_NUMERO"));
				endereco.setCep(rs.getInt("TB_ENDERECO_CEP"));
				endereco.setBairro(rs.getString("TB_ENDERECO_BAIRRO"));
				endereco.setCidade(rs.getString("TB_ENDERECO_CIDADE"));
				endereco.setEstado(rs.getString("TB_ENDERECO_ESTADO"));
				endereco.setPais(rs.getString("TB_ENDERECO_PAIS"));
				fornecedor.setEndereco(endereco);				
			}
			
			fornecedor.setCnpj(rs.getString("TB_FORN_CNPJ"));
			fornecedor.setEmail(rs.getString("TB_FORN_EMAIL"));
			fornecedor.setNome(rs.getString("TB_FORN_NOME"));
			fornecedor.setNomeRepresentante(rs.getString("TB_FORN_NOMEREPRESENTANTE"));
			fornecedor.setSigla(rs.getString("TB_FORN_SIGLA"));
			fornecedor.setTelefone(rs.getString("TB_FORN_TELEFONE"));
			
			fornecedores.add(fornecedor);
		}
		
		smt.close();
		conn.close();
		
		return fornecedores;
	}

	public void alterar(Fornecedor fornecedor) throws ClassNotFoundException, SQLException {
		int id = 0;
		
		Connection conn = JDBCUtil.fabrica();
		String query = "UPDATE TB_FORNECEDOR SET TB_FORN_CNPJ="+fornecedor.getCnpj()
				+",TB_FORN_EMAIL="+fornecedor.getEmail()
				+",TB_FORN_NOME="+fornecedor.getNome()
				+",TB_FORN_NOMEREPRESENTANTE="+fornecedor.getNomeRepresentante()
				+",TB_FORN_SIGLA="+fornecedor.getSigla()
				+",TB_FORN_TELEFONE="+fornecedor.getTelefone()
				+" WHERE TB_FORN_CNPJ="+fornecedor.getCnpj()+";";
		
		Statement smt = conn.createStatement();
		smt.executeQuery(query);
		
		query = "SELECT * FROM TB_FORNECEDOR WHERE TB_FORNECEDOR_CNPJ="+fornecedor.getCnpj()+";";
		ResultSet rs = smt.executeQuery(query);
		
		if(rs.next())
			id = rs.getInt("TB_ENDERECO_ID");
		
		query = "UPDATE TB_ENDERECO SET TB_ENDERECO_RUA="+fornecedor.getEndereco().getRua()
				+",TB_ENDERECO_NUMERO="+fornecedor.getEndereco().getNumero()
				+ ",TB_ENDERECO_COMPLEMENTO="+fornecedor.getEndereco().getComplemento()
				+",TB_ENDERECO_CEP="+fornecedor.getEndereco().getCep()
				+",TB_ENDERECO_BAIRRO="+fornecedor.getEndereco().getBairro()
				+",TB_ENDERECO_CIDADE="+fornecedor.getEndereco().getCidade()
				+",TB_ENDERECO_ESTADO="+fornecedor.getEndereco().getCidade()
				+",TB_ENDERECO_PAIS="+fornecedor.getEndereco().getPais()
				+" WHERE TB_ENDERECO_ID="+id+";";
		
		smt.executeQuery(query);
		
		smt.close();
		conn.close();
	}
	
	public void excluir(String cnpj) throws ClassNotFoundException, SQLException {
		int id = 0, idFK = 0;
		Connection conn = JDBCUtil.fabrica();
		String query = "SELECT * FROM TB_FORNECEDOR WHERE TB_FORNECEDOR_CNPJ = "+cnpj+";";
		Statement smt = conn.createStatement();
		
		ResultSet rs = smt.executeQuery(query);
		
		if(rs.next()) {
			id = rs.getInt("TB_FORNECEDOR_ID");
			idFK = rs.getInt("TB_ENDERECO_ID");
		}
		
		query = "DELETE FROM TB_ENDERECO WHERE TB_ENDERECO_ID = "+idFK+";";
		smt.executeQuery(query);
		query = "DELETE FROM TB_FORNECEDOR WHERE TB_PESSOA_ID = "+id+";";
		smt.executeQuery(query);
	
		smt.close();
		conn.close();		
	}
}