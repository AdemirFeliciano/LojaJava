package br.senac.rn.loja.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senac.rn.loja.model.Departamento;

public class DepartamentoDAO {
	
	
	public void inserir(Departamento departamento) {
		ConexaoDAO conexao = new ConexaoDAO();
		String sql = "INSERT INTO tb_departamentos (dep_departamento, dep_desconto) VALUES (?, ?)";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setString(1, departamento.getNome());
			statement.setFloat(2, departamento.getDesconto());
			statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("Erro: " + exception);
		}
		conexao.fecharConexao();
	}
	
	public void editar (Departamento departamento) {
		ConexaoDAO conexao = new ConexaoDAO();
		String sql = "UPDATE tb_departamentos SET dep_departamento = ? , dep_desconto = ? WHERE dep_codigo = ?";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setString(1, departamento.getNome());
			statement.setFloat(2, departamento.getDesconto());
			statement.setInt(3, departamento.getId());
			statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("Erro: " + exception);
		}
		conexao.fecharConexao();
	}
	
	public void remover (Departamento departamento) {
		ConexaoDAO conexao = new ConexaoDAO();
		String sql = "DELETE FROM tb_departamentos WHERE dep_codigo = ?";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setInt(1, departamento.getId());
			statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("Erro: " + exception);
		}
		conexao.fecharConexao();
	}
	
	public List<Departamento> buscarTodos(){
		ConexaoDAO conexao = new ConexaoDAO();
		List<Departamento> departamentos = new ArrayList<Departamento>();
		String sql = "SELECT * FROM tb_departamentos";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Departamento departamento = new Departamento();
				departamento.setId(result.getInt("dep_codigo"));
				departamento.setNome(result.getString("dep_departamento"));
				departamento.setDesconto(result.getFloat("dep_desconto"));
				departamentos.add(departamento);
			}
			conexao.fecharConexao();
			return departamentos;
		} catch (SQLException exception) {
			System.out.println("Erro: " + exception);
		}
		conexao.fecharConexao();
		return null;
	}
	
	public Departamento buscarPorId(Integer id) {
		ConexaoDAO conexao = new ConexaoDAO();
		String sql = "SELECT * FROM tb_departamentos WHERE dep_codigo = ?";
		try {
			PreparedStatement statement = new ConexaoDAO().getConexao().prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				Departamento departamento = new Departamento();
				departamento.setId(result.getInt("dep_codigo"));
				departamento.setNome(result.getString("dep_departamento"));
				departamento.setDesconto(result.getFloat("dep_desconto"));
				conexao.fecharConexao();
				return departamento;
			}
		} catch (SQLException exception) {
			System.out.println("Erro: " + exception.getMessage());
		}
		conexao.fecharConexao();
		return null;
	}

}
