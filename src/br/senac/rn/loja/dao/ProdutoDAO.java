package br.senac.rn.loja.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.senac.rn.loja.model.Produto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {

	public void inserir(Produto produto) {
		ConexaoDAO conexao = new ConexaoDAO();
		String sql = "INSERT INTO tb_produtos (pro_nome, pro_descricao, pro_valor, pro_dep_codigo, pro_qnt_estoque) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getDescricao());
			statement.setFloat(3, produto.getPreco());
			statement.setInt(4, produto.getDepartamento().getId());
			statement.setInt(5, produto.getQntEstoque());
			statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("Erro: " + exception.getMessage());
		}
		conexao.fecharConexao();
	}
	
	public void remover(Produto produto) {
		ConexaoDAO conexao = new ConexaoDAO();
		String sql = "DELETE FROM tb_produtos WHERE pro_codigo = ?";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setInt(1, produto.getId());
			statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("Erro: " + exception.getMessage());
		}
		conexao.fecharConexao();
	}
	
	public void editar(Produto produto) {
		ConexaoDAO conexao = new ConexaoDAO();
		String sql = "UPDATE tb_produtos SET pro_nome = ?, pro_descricao= ?, pro_valor=?, pro_dep_codigo= ?, pro_qnt_estoque= ? WHERE pro_codigo = ?";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getDescricao());
			statement.setFloat(3, produto.getPreco());
			statement.setInt(4, produto.getDepartamento().getId());
			statement.setInt(5, produto.getQntEstoque());
			statement.setInt(6, produto.getId());
			statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("Erro: " + exception.getMessage());
		}
		conexao.fecharConexao();
	}
	
	public List<Produto> buscarTodos(){
            List<Produto> produtos = new ArrayList<>();
            ConexaoDAO conexao = new ConexaoDAO();
            String sql = "SELECT * FROM tb_produtos LEFT JOIN tb_departamentos ON dep_codigo = pro_dep_codigo";
            try {
                PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
                ResultSet result = statement.executeQuery();
                while (result.next()){
                    Produto produto = new Produto();
                    produto.setId(result.getInt("pro_codigo"));
                    produto.setNome(result.getString("pro_nome"));
                    produto.setDescricao(result.getString("pro_descricao"));
                    produto.setPreco(result.getFloat("pro_valor"));
                    produto.setQntEstoque(result.getInt("pro_qnt_estoque"));
                    produto.setQntMinima(result.getInt("pro_qnt_minima"));
                    produto.getDepartamento().setId(result.getInt("dep_codigo"));
                    produto.getDepartamento().setNome(result.getString("dep_departamento"));
                    produto.getDepartamento().setDesconto(result.getFloat("dep_desconto"));
                    produtos.add(produto);
                }
                    conexao.fecharConexao();
                    return produtos;
            } catch (SQLException exception) {
                System.out.println("Erro: " + exception.getMessage());
            }
            conexao.fecharConexao();
		return null;
	}
        
        public Produto buscarPorId(int id){
            ConexaoDAO conexao = new ConexaoDAO();
            String sql = "SELECT * FROM tb_produtos LEFT JOIN tb_departamentos on dep_codigo = pro_dep_codigo WHERE pro_codigo = ?";
            try {
                PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
                statement.setInt(1, id);
                ResultSet result = statement.executeQuery();
                Produto produto = new Produto();
                if (result.next()){
                    produto.setId(result.getInt("pro_codigo"));
                    produto.setNome(result.getString("pro_nome"));
                    produto.setDescricao(result.getString("pro_descricao"));
                    produto.setPreco(result.getFloat("pro_valor"));
                    produto.setQntEstoque(result.getInt("pro_qnt_estoque"));
                    produto.setQntMinima(result.getInt("pro_qnt_minima"));
                    produto.getDepartamento().setId(result.getInt("dep_codigo"));
                    produto.getDepartamento().setNome(result.getString("dep_departamento"));
                    produto.getDepartamento().setDesconto(result.getFloat("dep_desconto"));
                }
                conexao.fecharConexao();
                return produto;
            } catch (SQLException exception) {
                System.out.println("Erro: " + exception.getMessage());
            }
            conexao.fecharConexao();
            return null;
        }
}
