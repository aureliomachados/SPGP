package mvc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mvc.beans.Usuario;

public class UsuarioDAO {
	

	public static void inserir(Usuario objUsuario ){
	  	
		String sqlInsercao = "INSERT INTO usuario(cpf, nome, login, senha, perfil, dpto_usuario, situacao) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstm = null;
		Connection objCon = null;	
		
		try{
			objCon = ConexaoDAO.getConnection();
			pstm = objCon.prepareStatement(sqlInsercao); 
			pstm.setString(1,objUsuario.getCpf());
			pstm.setString(2,objUsuario.getNome());
			pstm.setString(3,objUsuario.getLogin());
			pstm.setString(4,objUsuario.getSenha());
			pstm.setString(5,objUsuario.getPerfil());
			pstm.setString(6,objUsuario.getDepartamento());
			pstm.setString(7,objUsuario.getSituacao());
			pstm.executeUpdate();
			System.out.println("Insercao Feita Com Sucesso!");
		}catch(Exception e){
			System.out.println("Erro na insercao!\nMotivo: "+e.getMessage());
			e.printStackTrace();
		}
		finally{			
			ConexaoDAO.closeConnection(objCon,pstm,null);
		} 
	}
	public void habilitar(Usuario objUsuario){
		String sqlHabilitar = "update usuario set situacao = 'Ativo' where login = ?";
		PreparedStatement pstm = null;
		Connection objCon = null;	
				
		try{
			objCon = ConexaoDAO.getConnection();
			PreparedStatement st = objCon.prepareStatement(sqlHabilitar);
			st.setString(1,objUsuario.getLogin().trim());
			st.executeUpdate();
			System.out.println("Habilitado com Sucesso!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Erro ao ativar Usuario!\nMotivo: "+e.getMessage());
		}
		finally{			
			ConexaoDAO.closeConnection(objCon,pstm,null);
		} 
	}
	
	public void desabilitar(Usuario objUsuario){
		String sqlDesabilitar = "update usuario set situacao = 'Desativado' where login = ?";
		PreparedStatement pstm = null;
		Connection objCon = null;	
		
		try{
			objCon = ConexaoDAO.getConnection();
			PreparedStatement st = objCon.prepareStatement(sqlDesabilitar);
			st.setString(1,objUsuario.getLogin().trim());
			st.executeUpdate();
			System.out.println("Desabilitado com Sucesso!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Erro ao desabilitar Usuario!\nMotivo: "+e.getMessage());
		}
		finally{			
			ConexaoDAO.closeConnection(objCon,pstm,null);
		} 
	}
	
	public void alterar(Usuario objUsuario ){		
		String sqlAtualizacao = "update usuario set nome = ?, login = ?, senha = ?, perfil = ?, dpto_usuario = ? where cpf = ?";
		PreparedStatement pstm = null;
		Connection objCon = null;
		
		try{
			objCon = ConexaoDAO.getConnection();
			pstm = objCon.prepareStatement(sqlAtualizacao);
			pstm.setString(1,objUsuario.getNome());
			pstm.setString(2,objUsuario.getLogin());
			pstm.setString(3,objUsuario.getSenha());
			pstm.setString(4,objUsuario.getPerfil());
			pstm.setString(5,objUsuario.getDepartamento());
			pstm.setString(6,objUsuario.getCpf());
			pstm.executeUpdate();
			System.out.println("Atualizacao Feita com Sucesso!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Erro na atualizacao do Usuario");
		}
		finally{			
			ConexaoDAO.closeConnection(objCon,pstm,null);
		}
		
	}	
		
	public Usuario consultaUsuario(String login ){
		Usuario objUsuario = new Usuario();
		String sqlConsulta = "select cpf, nome, login,senha, perfil, dpto_usuario, situacao from usuario where login = ?";
		PreparedStatement pstm = null;
		Connection objCon = null;
		ResultSet rs=null;
		 
		try{
			objCon = ConexaoDAO.getConnection();
			pstm = objCon.prepareStatement(sqlConsulta);
			pstm.setString(1,login);
			rs = pstm.executeQuery();
			rs.next();
			if(rs.getRow() == 0){
				objUsuario = null;
				System.out.println("Usuario não consta na base de dados!");
			}else{
				objUsuario.setCpf(rs.getString("cpf"));
				objUsuario.setNome(rs.getString("nome"));
				objUsuario.setLogin(rs.getString("login"));
				objUsuario.setSenha(rs.getString("senha"));
				objUsuario.setPerfil(rs.getString("perfil"));
				objUsuario.setDepartamento(rs.getString("dpto_usuario"));
				objUsuario.setSituacao(rs.getString("situacao"));
			}
		}catch(SQLException e){
			System.out.println("Erro na consulta do Usuario!\nMotivo: "+e.getMessage());
		}finally{			
			ConexaoDAO.closeConnection(objCon,pstm,rs);
		}		
		return objUsuario;
	}
	public Usuario consultar(String login){
		Usuario objUsuario = new Usuario();
		String sqlConsulta = "select nome, login, senha, perfil, situacao from usuario where login = ?";
		PreparedStatement pstm = null;
		Connection objCon = null;
		ResultSet rs=null;
		 
		try{
			objCon = ConexaoDAO.getConnection();
			pstm = objCon.prepareStatement(sqlConsulta);
			pstm.setString(1,login);
			rs = pstm.executeQuery();
			rs.next();
			if(rs.getRow() == 0){
				objUsuario = null;
				System.out.println("Usuario não consta na base de dados!");
			}else{
				objUsuario.setLogin(rs.getString("nome"));
				objUsuario.setLogin(rs.getString("login"));
				objUsuario.setSenha(rs.getString("senha"));
				objUsuario.setPerfil(rs.getString("perfil"));
				objUsuario.setSituacao(rs.getString("situacao"));
			}
		}catch(SQLException e){
			System.out.println("Erro na consulta do Usuario!\nMotivo: "+e.getMessage());
		}finally{			
			ConexaoDAO.closeConnection(objCon,pstm,rs);
		}		
		return objUsuario;
	}
	
	public ResultSet listarUsuario(){
		Connection objCon = null;
		ResultSet rs=null;
		
		String sqlListar = "select id, cpf, nome, login, perfil, dpto_usuario, situacao from usuario";
		try{
			objCon = ConexaoDAO.getConnection();		
			Statement st = objCon.createStatement();
			rs = st.executeQuery(sqlListar);
			
		}catch(Exception e){
			System.out.println("Erro na listagem de Usuarios");
		}
		finally{			
			ConexaoDAO.closeConnection(null,null,null);
		}
		return rs;
	}
	
	
}