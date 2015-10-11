package mvc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mvc.beans.Departamento;

public class DepartamentoDAO {
		
		public static void inserirDepartamento(Departamento objDepartamento ){
		  	
			String sqlInsercao = "insert into departamento (nome_dpto) values (?)";
			PreparedStatement pstm = null;
			Connection objCon = null;	
			
			try{
				objCon = ConexaoDAO.getConnection();
				pstm = objCon.prepareStatement(sqlInsercao); 
				pstm.setString(1,objDepartamento.getNome());
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

		public void excluirDepartamento(String nome){
			String sqlExclusao = "delete from departamento where nome_dpto = ?";
			PreparedStatement pstm = null;
			Connection objCon = null;	
			
			try{
				objCon = ConexaoDAO.getConnection();
				PreparedStatement st = objCon.prepareStatement(sqlExclusao);
				st.setString(1,nome);
				st.executeUpdate();
				System.out.println("Exclusao Feita com Sucesso!");
			}catch(Exception e){
				System.out.println("Erro na exclusao do UDepartamento!\nMotivo: "+e.getMessage());
			}
			finally{			
				ConexaoDAO.closeConnection(objCon,pstm,null);
			} 
		}
		
		public void alterarDepartamento(Departamento objDepartamento ){		
			String sqlAtualizacao = "update departamento set nome_dpto = ? where cod_dpto = ?";
			PreparedStatement pstm = null;
			Connection objCon = null;
			
			try{
				objCon = ConexaoDAO.getConnection();
				pstm = objCon.prepareStatement(sqlAtualizacao);
				pstm.setString(1,objDepartamento.getNome());
				pstm.setInt(2,objDepartamento.getCodDpto());
				pstm.executeUpdate();
				System.out.println("Atualizacao Feita com Sucesso!");
			}catch(Exception e){
				System.out.println("Erro na atualizacao do Usuario");
			}
			finally{			
				ConexaoDAO.closeConnection(objCon,pstm,null);
			}
			
		}	
		public Departamento consultarDepartamento(String nome){
			Departamento objDepartamento = new Departamento();
			String sqlConsulta = "select cod_dpto, nome_dpto from departamento where nome_dpto = ?";
			PreparedStatement pstm = null;
			Connection objCon = null;
			ResultSet rs=null;
			 
			try{
				objCon = ConexaoDAO.getConnection();
				pstm = objCon.prepareStatement(sqlConsulta);
				pstm.setString(1,nome);
				rs = pstm.executeQuery();
				rs.next();
				if(rs.getRow() == 0){
					objDepartamento = null;
					System.out.println("Usuario não consta na base de dados!");
				}else{
					objDepartamento.setCodDpto(rs.getInt("cod_dpto"));
					objDepartamento.setNome(rs.getString("nome_dpto"));
					
				}
			}catch(SQLException e){
				System.out.println("Erro na consulta do Usuario!\nMotivo: "+e.getMessage());
			}finally{			
				ConexaoDAO.closeConnection(objCon,pstm,rs);
			}		
			return objDepartamento;
		}
		public ResultSet listarDepartamento(){
			Connection objCon = null;
			ResultSet rs=null;
			
			String sqlListar = "select cod_dpto, nome_dpto from departamento";
			try{
				objCon = ConexaoDAO.getConnection();		
				Statement st = objCon.createStatement();
				rs = st.executeQuery(sqlListar);
				
			}catch(Exception e){
				System.out.println("Erro na listagem de departamento");
			}
			finally{			
				ConexaoDAO.closeConnection(null,null,null);
			}
			return rs;
		}
	
}


