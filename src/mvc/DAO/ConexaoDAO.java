package mvc.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoDAO {

	public static Connection getConnection(){
		
		String url = "jdbc:postgresql://127.0.0.1:5432/db_spgp";
		Connection  conexao = null;
		try{
			
			Class.forName("org.postgresql.Driver");
			
			conexao = DriverManager.getConnection(url, "postgres", "123");
			
			System.out.println("Conexao realizada com sucesso!");
			
		}catch(ClassNotFoundException e){
			System.out.println("Driver não localizado!");
			e.printStackTrace();
		}
		catch(SQLException e){
			System.out.println("Erro ao conectar com o banco de dados!");
			e.printStackTrace();
		}
		
		
		return conexao;
	}
	
	public static void closeConnection(
        Connection conn,
        PreparedStatement stmt,
        ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            }
        }        
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }
	public static void closeConnection(
	        Connection conn,
	        Statement stmt,
	        ResultSet rs,
	        PreparedStatement pstm) {
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	            }
	        }
	        if (stmt != null) {
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	            }
	        }
	        if (pstm != null) {
	            try {
	                pstm.close();
	            } catch (SQLException e) {
	            }
	        }
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	            }
	        }
	    }
      
 
}