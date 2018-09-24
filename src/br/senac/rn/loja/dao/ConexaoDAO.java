package br.senac.rn.loja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
	
	//MariaDB -> org.mariadb.jdbc.Driver
	//MySQL -> com.myql.cj.jdcb.Driver
	//PostgreSQL -> org.postgresql.Driver
	//MSSQL -> com.microsoft.sqlserver.jdbc.SQLServerDriver


	private final String DRIVER = "org.mariadb.jdbc.Driver";
	private final String BANCO = "db_loja";
	private final String URL = "jdbc:mariadb://localhost:3306/" + BANCO;
	private final String USUARIO = "root";
	private final String SENHA= "";
	
	private Connection connection;
	
	public ConexaoDAO() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			
		}catch (ClassNotFoundException | SQLException exception) {
			System.out.println("Problema com a Conexão ou Drive não encontrado!!!");
			this.connection = null;
		}
		
	}
	
	public Connection getConexao() {
		return this.connection;
	}
	
	public void fecharConexao() {
		try {
			this.connection.close();
		} catch (SQLException exception) {
			System.out.println("Erro: " + exception.getMessage());
		}
	}
}
