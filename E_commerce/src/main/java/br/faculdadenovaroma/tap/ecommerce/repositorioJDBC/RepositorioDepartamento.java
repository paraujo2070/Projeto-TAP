package br.faculdadenovaroma.tap.ecommerce.repositorioJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.entidade.Departamento;
import br.faculdadenovaroma.tap.ecommerce.util.JDBCUtil;

public class RepositorioDepartamento implements IRepositorioDepartamentoJDBC {
	public boolean achou(String nome) {
		return false;
	}

	public void inserir(Departamento novoDepartamento) throws SQLException, ClassNotFoundException {
		Connection conn = JDBCUtil.fabrica();

		String query = "INSERT INTO TB_DEPARTAMENTO (TB_DEP_NOME) VALUES(?)";

		PreparedStatement smt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		smt.setString(1, novoDepartamento.getNome());
		
		smt.executeUpdate();

		smt.close();
		conn.close();
	}

	public Departamento consultar(String nome) throws SQLException, ClassNotFoundException {
		Departamento departamento = new Departamento();
		
		Connection conn = JDBCUtil.fabrica();
		String query = "SELECT * FROM TB_DEPARTAMENTO WHERE TB_DEP_NOME = "+nome+";";
		Statement smt = conn.createStatement();
		
		ResultSet rs = smt.executeQuery(query);
		
		if(rs.next()) {
			departamento.setNome(rs.getString("TB_DEP_NOME"));
		}
		
		smt.close();
		conn.close();
		
		return departamento;
	}

	public ArrayList<Departamento> listar() throws ClassNotFoundException, SQLException {
		ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
		
		Connection conn = JDBCUtil.fabrica();
		String query = "SELECT * FROM TB_DEPARTAMENTO";
		Statement smt = conn.createStatement();
		
		ResultSet rs = smt.executeQuery(query);
		
		while(rs.next()) {
			Departamento departamento = new Departamento();
			
			departamento.setNome(rs.getString("TB_DEP_NOME"));
			
			departamentos.add(departamento);
		}
		
		smt.close();
		conn.close();
		
		return departamentos;
	}

	public void alterar(Departamento departamento) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.fabrica();
		String query = "UPDATE TB_DEPARTAMENTO SET TB_DEP_NOME="+departamento.getNome()
				+" TB_DEP_COD="+departamento.getNome()+";";
		
		Statement smt = conn.createStatement();
		smt.executeQuery(query);
		
		smt.close();
		conn.close();
	}
	
	public void excluir(String nome) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.fabrica();
		String query = "DELETE FROM TB_DEPARTAMENTO WHERE TB_DEP_NOME = "+nome+";";
		Statement smt = conn.createStatement();
		
		smt.executeQuery(query);
					
		smt.close();
		conn.close();		
	}
}
