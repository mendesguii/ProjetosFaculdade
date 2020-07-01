package com.poo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

/*
			
	private static final String DRIVE = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost/javabanco"; 
	private static final String USER = "postgres"; 
	private static final String SENHA = "lasalle"; 
*/
	
	private static final String DRIVE = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://remotemysql.com:3306/jwrrWpsA7f?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo"; 
	private static final String USER = "jwrrWpsA7f"; 
	private static final String SENHA = "cAv6llIFA9"; 

	public static Connection getConnection() {
        try {
        	
        	// Class.forName(DRIVER); opcional dependendo da versao
        	
            return DriverManager.getConnection(
            		URL, USER, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conex�o com o Banco de Dados!",e);
        }
    }
		

	public static void closeConnection(Connection con)
	{
		if(con != null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(Connection con, PreparedStatement stmt)
	{
		closeConnection(con);
		
		if(stmt != null)
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs)
	{
		closeConnection(con, stmt);
		
		if(rs != null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
			
}
	
