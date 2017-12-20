package br.faculdadenovaroma.tap.ecommerce.repositorioJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



//import com.mysql.jdbc.CallableStatement;

import br.faculdadenovaroma.tap.ecommerce.entidade.Cliente;
import br.faculdadenovaroma.tap.ecommerce.entidade.Endereco;
import br.faculdadenovaroma.tap.ecommerce.entidade.Pessoa;
import br.faculdadenovaroma.tap.ecommerce.util.JDBCUtil;

public class RepositorioCliente implements IRepositorioClienteJDBC {
	public boolean achou(String cpf) {
		return false;
	}

	public void inserir(Cliente novoCliente) throws SQLException, ClassNotFoundException {
		ResultSet result;
		int id = 0;

		Connection conn = JDBCUtil.fabrica();
		String query = "INSERT INTO TB_ENDERECO (TB_ENDERECO_RUA,TB_ENDERECO_NUMERO,TB_ENDERECO_COMPLEMENTO,"
				+ "TB_ENDERECO_CEP,TB_ENDERECO_BAIRRO,TB_ENDERECO_CIDADE,TB_ENDERECO_ESTADO,TB_ENDERECO_PAIS)"
				+ "VALUES(?,?,?,?,?,?,?,?)";

		PreparedStatement smt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		smt.setString(1, novoCliente.getPessoa().getEndereco().getRua());
		smt.setInt(2, novoCliente.getPessoa().getEndereco().getNumero());
		smt.setString(3, novoCliente.getPessoa().getEndereco().getComplemento());
		smt.setInt(4, novoCliente.getPessoa().getEndereco().getCep());
		smt.setString(5, novoCliente.getPessoa().getEndereco().getBairro());
		smt.setString(6, novoCliente.getPessoa().getEndereco().getCidade());
		smt.setString(7, novoCliente.getPessoa().getEndereco().getEstado());
		smt.setString(8, novoCliente.getPessoa().getEndereco().getPais());
		
		smt.executeUpdate();
		result = smt.getGeneratedKeys();

		if (result.next())
			id = result.getInt(1);

		
		query = "INSERT INTO TB_PESSOA(TB_PESSOA_NOME,TB_PESSOA_CPF,TB_ENDERECO_ID,TB_PESSOA_TELEFONE,"
				+ "TB_PESSOA_CELULAR,TB_PESSOA_EMAIL) VALUES (?,?,?,?,?,?)";
		smt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		

		smt.setString(1, novoCliente.getPessoa().getNome());
		smt.setString(2, novoCliente.getPessoa().getCpf());
		smt.setInt(3, id);
		smt.setString(4, novoCliente.getPessoa().getTelefone());
		smt.setString(5, novoCliente.getPessoa().getCelular());
		smt.setString(6, novoCliente.getPessoa().getEmail());

		

		smt.executeUpdate();

		result = smt.getGeneratedKeys();

		if (result.next())
			id = result.getInt(1);

		
		query = "INSERT INTO TB_CLIENTE(TB_CLIENTE_USUARIO,TB_CLIENTE_SENHA,TB_PESSOA_ID) VALUES (?,?,?)";
		smt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		smt.setString(1, novoCliente.getUser());
		smt.setString(2, novoCliente.getPassword());
		smt.setInt(3, id);
		

		smt.executeUpdate();

		smt.close();
		conn.close();


	}

	public Cliente consultar(String cpf) throws SQLException, ClassNotFoundException {
		int idFK = 0;
		Cliente cliente = new Cliente();
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
		
		query = "SELECT * FROM TB_CLIENTE WHERE TB_PESSOA_ID = "+idFK+";";
		rs = smt.executeQuery(query);
		
		if(rs.next()) {
			cliente.setUser(rs.getString("TB_CLIENTE_USER"));
			cliente.setPassword(rs.getString("TB_CLIENTE_PASSWORD"));
			cliente.setPessoa(pessoa);
		}
		
		smt.close();
		conn.close();
		
		return cliente;
	}

	public ArrayList<Cliente> listar() throws ClassNotFoundException, SQLException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		Connection conn = JDBCUtil.fabrica();
		String query = "SELECT * FROM TB_PESSOA";
		Statement smt = conn.createStatement();
		
		ResultSet rs = smt.executeQuery(query);
		
		while(rs.next()) {
			Cliente cliente = new Cliente();
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
			
			query = "SELECT * FROM TB_CLIENTE WHERE TB_PESSOA_ID = "+idFK+";";
			rs2 = smt.executeQuery(query);
			
			if(rs2.next()) {
				cliente.setUser(rs.getString("TB_CLIENTE_USER"));
				cliente.setPassword(rs.getString("TB_CLIENTE_PASSWORD"));
				cliente.setPessoa(pessoa);
			}
			
			clientes.add(cliente);
		}
		
		smt.close();
		conn.close();
		
		return clientes;
	}

	public void alterar(Cliente cliente) throws ClassNotFoundException, SQLException {
		int id = 0;
		
		Connection conn = JDBCUtil.fabrica();
		String query = "UPDATE TB_PESSOA SET TB_PESSOA_NOME="+cliente.getPessoa().getNome()
				+",TB_PESSOA_TELEFONE="+cliente.getPessoa().getTelefone()
				+",TB_PESSOA_CELULAR="+cliente.getPessoa().getCelular()
				+",TB_PESSOA_EMAIL="+cliente.getPessoa().getEmail()
				+" WHERE TB_PESSOA_CPF="+cliente.getPessoa().getCpf()+";";
		
		Statement smt = conn.createStatement();
		smt.executeQuery(query);
		
		query = "SELECT * FROM TB_PESSOA WHERE TB_PESSOA_CPF="+cliente.getPessoa().getCpf()+";";
		ResultSet rs = smt.executeQuery(query);
		
		if(rs.next())
			id = rs.getInt("TB_ENDERECO_ID");
		
		query = "UPDATE TB_ENDERECO SET TB_ENDERECO_RUA="+cliente.getPessoa().getEndereco().getRua()
				+",TB_ENDERECO_NUMERO="+cliente.getPessoa().getEndereco().getNumero()
				+ ",TB_ENDERECO_COMPLEMENTO="+cliente.getPessoa().getEndereco().getComplemento()
				+",TB_ENDERECO_CEP="+cliente.getPessoa().getEndereco().getCep()
				+",TB_ENDERECO_BAIRRO="+cliente.getPessoa().getEndereco().getBairro()
				+",TB_ENDERECO_CIDADE="+cliente.getPessoa().getEndereco().getCidade()
				+",TB_ENDERECO_ESTADO="+cliente.getPessoa().getEndereco().getCidade()
				+",TB_ENDERECO_PAIS="+cliente.getPessoa().getEndereco().getPais()
				+" WHERE TB_ENDERECO_ID="+id+";";
		
		smt.executeQuery(query);
		
		smt.close();
		conn.close();
	}
	
	public void alterarUsuario(String user, String pass) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.fabrica();
		String query = "UPDATE TB_CLIENTE SET TB_CLIENTE_USER="+user
				+",TB_CLIENTE_PASSWORD="+pass
				+" WHERE TB_CLIENTE_USER="+user+";";
		
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
		
		query = "DELETE FROM TB_CLIENTE WHERE TB_PESSOA_ID = "+id+";";
		smt.executeQuery(query);
		query = "DELETE FROM TB_ENDERECO WHERE TB_ENDERECO_ID = "+idFK+";";
		smt.executeQuery(query);
		query = "DELETE FROM TB_PESSOA WHERE TB_PESSOA_ID = "+id+";";
		smt.executeQuery(query);
	
		smt.close();
		conn.close();		
	}

	public Cliente logar(String user, String password) {
		return null;
	}
}
