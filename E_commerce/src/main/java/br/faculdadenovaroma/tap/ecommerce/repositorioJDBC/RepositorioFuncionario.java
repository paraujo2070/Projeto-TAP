package br.faculdadenovaroma.tap.ecommerce.repositorioJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.entidade.Endereco;
import br.faculdadenovaroma.tap.ecommerce.entidade.Funcionario;
import br.faculdadenovaroma.tap.ecommerce.entidade.Pessoa;
import br.faculdadenovaroma.tap.ecommerce.util.JDBCUtil;

public class RepositorioFuncionario implements IRepositorioFuncionarioJDBC {


	public boolean achou(String cpf) {
		return false;
	}

	public void inserir(Funcionario novoFuncionario) throws SQLException, ClassNotFoundException {
		ResultSet result;
		int id = 0;

		Connection conn = JDBCUtil.fabrica();
		String query = "INSERT INTO TB_ENDERECO (TB_ENDERECO_RUA,TB_ENDERECO_NUMERO,TB_ENDERECO_COMPLEMENTO,"
				+ "TB_ENDERECO_CEP,TB_ENDERECO_BAIRRO,TB_ENDERECO_CIDADE,TB_ENDERECO_ESTADO,TB_ENDERECO_PAIS)"
				+ "VALUES(?,?,?,?,?,?,?,?)";

		PreparedStatement smt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		smt.setString(1, novoFuncionario.getPessoa().getEndereco().getRua());
		smt.setInt(2, novoFuncionario.getPessoa().getEndereco().getNumero());
		smt.setString(3, novoFuncionario.getPessoa().getEndereco().getComplemento());
		smt.setInt(4, novoFuncionario.getPessoa().getEndereco().getCep());
		smt.setString(5, novoFuncionario.getPessoa().getEndereco().getBairro());
		smt.setString(6, novoFuncionario.getPessoa().getEndereco().getCidade());
		smt.setString(7, novoFuncionario.getPessoa().getEndereco().getEstado());
		smt.setString(8, novoFuncionario.getPessoa().getEndereco().getPais());

		smt.executeUpdate();
		result = smt.getGeneratedKeys();

		if (result.next())
			id = result.getInt(1);

		
		query = "INSERT INTO TB_PESSOA(TB_PESSOA_NOME,TB_PESSOA_CPF,TB_ENDERECO_ID,TB_PESSOA_TELEFONE,"
				+ "TB_PESSOA_CELULAR,TB_PESSOA_EMAIL) VALUES (?,?,?,?,?,?)";
		smt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		

		smt.setString(1, novoFuncionario.getPessoa().getNome());
		smt.setString(2, novoFuncionario.getPessoa().getCpf());
		smt.setInt(3, id);
		smt.setString(4, novoFuncionario.getPessoa().getTelefone());
		smt.setString(5, novoFuncionario.getPessoa().getCelular());
		smt.setString(6, novoFuncionario.getPessoa().getEmail());

		

		smt.executeUpdate();

		result = smt.getGeneratedKeys();

		if (result.next())
			id = result.getInt(1);

		
		query = "INSERT INTO TB_FUNCIONARIO(TB_FUNCIONARIO_USUARIO,TB_FUNCIONARIO_SENHA,TB_PESSOA_ID) VALUES (?,?,?)";
		smt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		smt.setString(1, novoFuncionario.getUser());
		smt.setString(2, novoFuncionario.getPassword());
		smt.setInt(3, id);
		

		smt.executeUpdate();

		smt.close();
		conn.close();
	}

	public Funcionario consultar(String cpf) throws SQLException, ClassNotFoundException {

		int idFK = 0;
		Funcionario funcionario = new Funcionario();
		Pessoa pessoa = new Pessoa();
		Endereco endereco = new Endereco();
		
		Connection conn = JDBCUtil.fabrica();
		String query = "SELECT * FROM TB_PESSOA WHERE TB_PESSOA_CPF = "+cpf+";";
		Statement smt = conn.createStatement();
		
		ResultSet rs = smt.executeQuery(query);
		
		if(rs.next()) {
			pessoa.setNome(rs.getString("TB_PESSOA_NOME"));
			pessoa.setCpf(rs.getString("TB_PESSOA_CPF"));
			pessoa.setTelefone(rs.getString("TB_PESSOA_TELEFONE"));
			pessoa.setCelular(rs.getString("TB_PESSOA_CELULAR"));
			pessoa.setEmail(rs.getString("TB_PESSOA_EMAIL"));
			idFK = rs.getInt("TB_ENDERECO_ID");
		}
		
		query = "SELECT * FROM TB_ENDERECO WHERE TB_ENDERECO_ID = "+idFK+";";
		idFK = rs.getInt("TB_PESSOA_ID");
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
			pessoa.setEndereco(endereco);
		}
		
		query = "SELECT * FROM TB_FUNCIONARIO WHERE TB_PESSOA_ID = "+idFK+";";
		rs = smt.executeQuery(query);
		
		if(rs.next()) {
			funcionario.setUser(rs.getString("TB_FUNCIONARIO_USER"));
			funcionario.setPassword(rs.getString("TB_FUNCIONARIO_PASSWORD"));
			funcionario.setPessoa(pessoa);
		}
		
		smt.close();
		conn.close();
		
		return funcionario;
	}

	public ArrayList<Funcionario> listar() throws ClassNotFoundException, SQLException {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		Connection conn = JDBCUtil.fabrica();
		String query = "SELECT * FROM TB_PESSOA";
		Statement smt = conn.createStatement();
		
		ResultSet rs = smt.executeQuery(query);
		
		while(rs.next()) {
			Funcionario funcionario = new Funcionario();
			Pessoa pessoa = new Pessoa();
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
				pessoa.setEndereco(endereco);				
			}
			
			pessoa.setNome(rs.getString("TB_PESSOA_NOME"));
			pessoa.setCpf(rs.getString("TB_PESSOA_CPF"));
			pessoa.setTelefone(rs.getString("TB_PESSOA_TELEFONE"));
			pessoa.setCelular(rs.getString("TB_PESSOA_CELULAR"));
			pessoa.setEmail(rs.getString("TB_PESSOA_EMAIL"));
			
			idFK = rs2.getInt("TB_PESSOA_ID");
			
			query = "SELECT * FROM TB_FUNCIONARIO WHERE TB_PESSOA_ID = "+idFK+";";
			rs2 = smt.executeQuery(query);
			
			if(rs2.next()) {
				funcionario.setUser(rs.getString("TB_FUNCIONARIO_USER"));
				funcionario.setPassword(rs.getString("TB_FUNCIONARIO_PASSWORD"));
				funcionario.setPessoa(pessoa);
			}
			
			funcionarios.add(funcionario);
		}
		
		smt.close();
		conn.close();
		
		return funcionarios;
	}

	public void alterar(Funcionario funcionario) throws ClassNotFoundException, SQLException {
		int id = 0;
		
		Connection conn = JDBCUtil.fabrica();
		String query = "UPDATE TB_PESSOA SET TB_PESSOA_NOME="+funcionario.getPessoa().getNome()
				+",TB_PESSOA_TELEFONE="+funcionario.getPessoa().getTelefone()
				+",TB_PESSOA_CELULAR="+funcionario.getPessoa().getCelular()
				+",TB_PESSOA_EMAIL="+funcionario.getPessoa().getEmail()
				+" WHERE TB_PESSOA_CPF="+funcionario.getPessoa().getCpf()+";";
		
		Statement smt = conn.createStatement();
		smt.executeQuery(query);
		
		query = "SELECT * FROM TB_PESSOA WHERE TB_PESSOA_CPF="+funcionario.getPessoa().getCpf()+";";
		ResultSet rs = smt.executeQuery(query);
		
		if(rs.next())
			id = rs.getInt("TB_ENDERECO_ID");
		
		query = "UPDATE TB_ENDERECO SET TB_ENDERECO_RUA="+funcionario.getPessoa().getEndereco().getRua()
				+",TB_ENDERECO_NUMERO="+funcionario.getPessoa().getEndereco().getNumero()
				+ ",TB_ENDERECO_COMPLEMENTO="+funcionario.getPessoa().getEndereco().getComplemento()
				+",TB_ENDERECO_CEP="+funcionario.getPessoa().getEndereco().getCep()
				+",TB_ENDERECO_BAIRRO="+funcionario.getPessoa().getEndereco().getBairro()
				+",TB_ENDERECO_CIDADE="+funcionario.getPessoa().getEndereco().getCidade()
				+",TB_ENDERECO_ESTADO="+funcionario.getPessoa().getEndereco().getCidade()
				+",TB_ENDERECO_PAIS="+funcionario.getPessoa().getEndereco().getPais()
				+" WHERE TB_ENDERECO_ID="+id+";";
		
		smt.executeQuery(query);
		
		smt.close();
		conn.close();
	}
	
	public void alterarUsuario(String user, String pass) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.fabrica();
		String query = "UPDATE TB_FUNCIONARIO SET TB_FUNCIONARIO_USER="+user
				+",TB_FUNCIONARIO_PASSWORD="+pass
				+" WHERE TB_FUNCIONARIO_USER="+user+";";
		
		Statement smt = conn.createStatement();
		smt.executeQuery(query);
		
		smt.close();
		conn.close();		
	}

	public void excluir(String cpf) throws ClassNotFoundException, SQLException {
		int id = 0, idFK = 0;
		Connection conn = JDBCUtil.fabrica();
		String query = "SELECT * FROM TB_PESSOA WHERE TB_PESSOA_CPF = "+cpf+";";
		Statement smt = conn.createStatement();
		
		ResultSet rs = smt.executeQuery(query);
		
		if(rs.next()) {
			id = rs.getInt("TB_PESSOA_ID");
			idFK = rs.getInt("TB_ENDERECO_ID");
		}
		
		query = "DELETE FROM TB_FUNCIONARIO WHERE TB_PESSOA_ID = "+id+";";
		smt.executeQuery(query);
		query = "DELETE FROM TB_ENDERECO WHERE TB_ENDERECO_ID = "+idFK+";";
		smt.executeQuery(query);
		query = "DELETE FROM TB_PESSOA WHERE TB_PESSOA_ID = "+id+";";
		smt.executeQuery(query);
	
		smt.close();
		conn.close();		
	}

	public Funcionario logar(String user, String password) {
		return null;
	}
}
