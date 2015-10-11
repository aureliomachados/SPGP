package mvc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mvc.beans.Documento;

public class DocumentoDAO {

		public static void inserir(Documento objDocumento ){
		  	
			String sqlInsercao = "INSERT INTO documento(nome_interessado, cpf_cnpj, num_doc, data_doc, assunto, data_entrada, tipo_doc, status, analista)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstm = null;
			Connection objCon = null;	
			
			try{
				objCon = ConexaoDAO.getConnection();
				pstm = objCon.prepareStatement(sqlInsercao); 
				pstm.setString(1,objDocumento.getNomeInteressado());
				pstm.setString(2,objDocumento.getCpf_cnpj());
				pstm.setInt(3,objDocumento.getNumDoc());
				pstm.setString(4,objDocumento.getDataDoc());
				pstm.setString(5,objDocumento.getAssunto());
				pstm.setString(6,objDocumento.getDataEntrada());
				pstm.setString(7,objDocumento.getTipo());
				pstm.setString(8,objDocumento.getStatus());
				pstm.setInt(9,objDocumento.getAnalista());
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

		public void encerrarProcesso(int numProtolo, String status){
			Documento objDocumento = new Documento(numProtolo, status);
			String sqlDesabilitar = "update documento set status = ? where cod_doc = ?";
			PreparedStatement pstm = null;
			Connection objCon = null;	
			
			try{
				objCon = ConexaoDAO.getConnection();
				PreparedStatement st = objCon.prepareStatement(sqlDesabilitar);
				st.setString(1,objDocumento.getStatus());
				st.setInt(2,objDocumento.getNumDoc());
				st.executeUpdate();
				System.out.println("encerrado com Sucesso!");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Erro ao encerrar processo!\nMotivo: "+e.getMessage());
			}
			finally{			
				ConexaoDAO.closeConnection(objCon,pstm,null);
			} 
		}
		
		public void alterar(Documento objDocumento ){		
			String sqlAtualizacao = "UPDATE documento SET nome_interessado=?, cpf_cnpj=?, num_doc=?, data_doc=?, assunto=?, data_entrada=?, data_encerramento=?, tipo_doc=?, status=?, providencia=?, analista=? WHERE cod_doc=?";
			PreparedStatement pstm = null;
			Connection objCon = null;
			
			try{
				objCon = ConexaoDAO.getConnection();
				pstm = objCon.prepareStatement(sqlAtualizacao);
				pstm.setString(1,objDocumento.getNomeInteressado());
				pstm.setString(2,objDocumento.getCpf_cnpj());
				pstm.setInt(3,objDocumento.getNumDoc());
				pstm.setString(4,objDocumento.getDataDoc());
				pstm.setString(5,objDocumento.getAssunto());
				pstm.setString(6,objDocumento.getDataEntrada());
				pstm.setString(7,objDocumento.getTipo());
				pstm.setString(8,objDocumento.getStatus());
				pstm.setInt(9,objDocumento.getAnalista());
				pstm.setInt(10,objDocumento.getNumProtolo());
				pstm.executeUpdate();
				System.out.println("Atualizacao Feita com Sucesso!");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Erro na atualizacao");
			}
			finally{			
				ConexaoDAO.closeConnection(objCon,pstm,null);
			}
			
		}	
			
		public Documento consultar(int numProtolo ){
			Documento objDocumento = new Documento();
			String sqlConsulta = "SELECT cod_doc, nome_interessado, cpf_cnpj, num_doc, data_doc, assunto, data_entrada, data_encerramento, tipo_doc, status, providencia, analista FROM documento WHERE cod_doc=?";
			PreparedStatement pstm = null;
			Connection objCon = null;
			ResultSet rs=null;
			 
			try{
				objCon = ConexaoDAO.getConnection();
				pstm = objCon.prepareStatement(sqlConsulta);
				pstm.setInt(1,numProtolo);
				rs = pstm.executeQuery();
				rs.next();
				if(rs.getRow() == 0){
					objDocumento = null;
					System.out.println("Documento não consta na base de dados!");
				}else{
					objDocumento.setNumProtolo(rs.getInt("cod_doc"));
					objDocumento.setNomeInteressado(rs.getString("nome_interessado"));
					objDocumento.setCpf_cnpj(rs.getString("cpf_cnpj"));
					objDocumento.setNumDoc(rs.getInt("num_doc"));
					objDocumento.setDataDoc(rs.getString("data_doc"));
					objDocumento.setAssunto(rs.getString("assunto"));
					objDocumento.setDataEntrada(rs.getString("data_entrada"));
					objDocumento.setDataEncerramento(rs.getString("data_encerramento"));
					objDocumento.setTipo(rs.getString("tipo_doc"));
					objDocumento.setStatus(rs.getString("status"));
					objDocumento.setProvidencia(rs.getString("providencia"));
					objDocumento.setAnalista(rs.getInt("analista"));	
				}
			}catch(SQLException e){
				System.out.println("Erro na consulta de documento!\nMotivo: "+e.getMessage());
			}finally{			
				ConexaoDAO.closeConnection(objCon,pstm,rs);
			}		
			return objDocumento;
		}
		
		public ResultSet listarDoc(){
			Connection objCon = null;
			ResultSet rs=null;
			
			String sqlListar = "select cod_doc, nome_interessado, status from documento";
			try{
				objCon = ConexaoDAO.getConnection();		
				Statement st = objCon.createStatement();
				rs = st.executeQuery(sqlListar);
				
			}catch(Exception e){
				System.out.println("Erro na listagem de documentos");
			}
			finally{			
				ConexaoDAO.closeConnection(null,null,null);
			}
			return rs;
		}
		
	}