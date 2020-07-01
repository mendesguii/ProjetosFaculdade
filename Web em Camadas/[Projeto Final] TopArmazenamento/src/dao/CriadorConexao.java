package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class CriadorConexao {

	private Connection conexao;
	
	public Connection fazerConexao() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			this.conexao = DriverManager.getConnection(
					"jdbc:mysql://remotemysql.com:3306/fPLiB2SXVt?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo&useSSL=false",
					"fPLiB2SXVt",
					"b1GVgh6G9N"
					);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.conexao;
	}
	
	public void fecharConexao() {
		
		try {
			
			this.conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}