package br.senac.rn.loja.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senac.rn.loja.model.Sexo;


public class SexoDAO {
	
	
	public void inserir (Sexo sexo) {
		ConexaoDAO conexao = new ConexaoDAO();
		String sql = "INSERT INTO tb_sexos(sex_sexos, sex_sigla) VALUE(?, ?)";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setString(1, sexo.getNome());
			statement.setString(2, sexo.getSigla());
			statement.executeUpdate();
		}catch (SQLException exception) {
			System.out.println("Erro: "+ exception.getMessage());
		}
		conexao.fecharConexao();
	}
	
	public void remover (Sexo sexo) {
		ConexaoDAO conexao = new ConexaoDAO();
		String sql = "DELETE FROM tb_sexos WHERE sex_codigo = ?";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setInt(1, sexo.getId());
			statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("Erro: " + exception.getMessage());
		}
		conexao.fecharConexao();
	}
	

	public void editar(Sexo sexo) {
		ConexaoDAO conexao = new ConexaoDAO();
		String sql = "UPDATE tb_sexos SET sex_sexos = ?, sex_sigla=? WHERE sex_codigo = ?";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setString(1, sexo.getNome());
			statement.setString(2, sexo.getSigla());
			statement.setInt(3, sexo.getId());
			statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("Erro: " + exception.getMessage());
		}
		conexao.fecharConexao();
	}
	
	public List <Sexo>buscarTodos(){
		List<Sexo> sexos = new ArrayList<Sexo>();
		ConexaoDAO conexao = new ConexaoDAO();
		String sql = "SELECT * FROM tb_sexos";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Sexo sexo = new Sexo();
				sexo.setId(result.getInt("sex_codigo"));
				sexo.setNome(result.getString("sex_sexos"));
				sexo.setSigla(result.getString("sex_sigla"));
				sexos.add(sexo);
			}
			conexao.fecharConexao();
			return sexos;
		} catch (SQLException exception) {
			System.out.println("Erro: " + exception.getMessage());
		}
		conexao.fecharConexao();
		return null;
	}
	
	public Sexo buscarPorId(Integer id) {
		ConexaoDAO conexao = new ConexaoDAO();
		String sql = "SELECT * FROM tb_sexos WHERE sex_codigo = ?";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Sexo sexo = new Sexo();
			if(result.next()) {
				sexo.setId(result.getInt("sex_codigo"));
				sexo.setNome(result.getString("sex_sexos"));
				sexo.setSigla(result.getString("sex_sigla"));
			}
			conexao.fecharConexao();
			return sexo;
		}catch (SQLException exception) {
			System.out.println("Erro: " + exception.getMessage());
		}
		conexao.fecharConexao();
		return null;
	}
	
	public Sexo buscarPorNome(String nome) {
		return null;
	}
	
	public Sexo buscarPorSigla(String sigla) {
		return null;
	}

}
