package mvc.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.DAO.DocumentoDAO;
import mvc.beans.Documento;




/**
 * Servlet implementation class ControleDocumento
 */
@WebServlet("/controleDocumento")
public class ControleDocumento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleDocumento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
	
		
		if (acao.equals("inserirDocumento")){
			//Protocolista
			
			String nomeInteressado = request.getParameter("nome");
			String cpf_cnpj = request.getParameter("cpf_cnpj");
			int numDoc = Integer.parseInt(request.getParameter("numDoc"));
			String dataDoc = request.getParameter("dataDoc");
			String assunto = request.getParameter("assunto");
			String dataEntrada = request.getParameter("dataEntrada");
			String tipo = request.getParameter("tipo");
			int analista = Integer.parseInt(request.getParameter("analista"));
			
			Documento documento = new Documento( nomeInteressado, cpf_cnpj, numDoc, dataDoc, assunto,dataEntrada, tipo, analista);
					
			DocumentoDAO.inserir(documento);
		
			RequestDispatcher direcionador = request.getRequestDispatcher("manterDocumento.jsp");
			direcionador.forward(request,response);
						
		} 
		else if(acao.equals("alterarDocumento")){
			// Protocolista e Analista
			int numProtocolo = Integer.parseInt(request.getParameter("numProtocolo"));
			String nomeInteressado = request.getParameter("nomeInteressado");
			String cpf_cnpj = request.getParameter("cpf_cnpj");
			int numDoc = Integer.parseInt(request.getParameter("numDoc"));
			String dataDoc = request.getParameter("dataDoc");
			String assunto= request.getParameter("assunto");
			String tipo= request.getParameter("tipo");
			String status= request.getParameter("status");
			int analista= Integer.parseInt(request.getParameter("analista"));
					
						
			DocumentoDAO documentoDAO = new DocumentoDAO();
			
			Documento documento = new Documento(numProtocolo , nomeInteressado, cpf_cnpj, numDoc, dataDoc, assunto, tipo, status, analista);
			
			documentoDAO.alterar(documento);
			
			RequestDispatcher direcionador = request.getRequestDispatcher("manterDocumento.jsp");
			direcionador.forward(request,response);

		}
		else if (acao.equals("consultarDocumento")){
			
			int numProtocolo = Integer.parseInt(request.getParameter("numProtocolo"));
			
			DocumentoDAO documentoDAO = new DocumentoDAO();
		
			Documento documento = documentoDAO.consultar(numProtocolo);							
			request.setAttribute("doc", documento);
					
			RequestDispatcher direcionador = request.getRequestDispatcher("processoConsulta.jsp");
			direcionador.forward(request,response);
			
		}
		else if (acao.equals("consultaDocmto")){
			//Analista
			int numProtocolo = Integer.parseInt(request.getParameter("numProtocolo"));
			
			DocumentoDAO documentoDAO = new DocumentoDAO();
		
			Documento documento = documentoDAO.consultar(numProtocolo);							
			request.setAttribute("docmto", documento);
					
			RequestDispatcher direcionador = request.getRequestDispatcher("processoConsult.jsp");
			direcionador.forward(request,response);
			
		}
		else if (acao.equals("consltDocumento")){
			//Protocolista 
			int numProtocolo = Integer.parseInt(request.getParameter("numProtocolo"));
			
			DocumentoDAO documentoDAO = new DocumentoDAO();
		
			Documento documento = documentoDAO.consultar(numProtocolo);							
			request.setAttribute("doc", documento);
					
			RequestDispatcher direcionador = request.getRequestDispatcher("processoConsulta.jsp");
			direcionador.forward(request,response);
			
		}
		else if (acao.equals("inserirProvidenc")){
			
			int numProtocolo = Integer.parseInt(request.getParameter("numProtocolo"));
			String providencia = request.getParameter("providencia");
			
			DocumentoDAO documentoDAO = new DocumentoDAO();
			Documento documento= new Documento(numProtocolo,providencia);
					
			documentoDAO.inserirProvidencia(documento); 
			Documento doc = documentoDAO.consultar(numProtocolo);
			request.setAttribute("procDetalhado", doc);
			
			RequestDispatcher direcionador = request.getRequestDispatcher("providencia.jsp");
			direcionador.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if (acao.equals("listarDoc")){
				//Protocolista
			DocumentoDAO documentoDAO = new DocumentoDAO();
				
			request.getSession(true).setAttribute("listaDoc", documentoDAO.listarDoc());
							
			RequestDispatcher direcionador = request.getRequestDispatcher("consultarProcesso.jsp");
			direcionador.forward(request,response);
			}
		else if (acao.equals("listarDocumento")){
				//Analista
				DocumentoDAO documentoDAO = new DocumentoDAO();
					
				request.getSession(true).setAttribute("listaDocumento", documentoDAO.listarDoc());
								
				RequestDispatcher direcionador = request.getRequestDispatcher("consProcAnalista.jsp");
				direcionador.forward(request,response);
				}
		else if (acao.equals("consultaDocmto")){
			//Analista
			int numProtocolo = Integer.parseInt(request.getParameter("numProtocolo"));
			
			DocumentoDAO documentoDAO = new DocumentoDAO();
		
			Documento documento = documentoDAO.consultar(numProtocolo);							
			request.setAttribute("docmto", documento);
					
			RequestDispatcher direcionador = request.getRequestDispatcher("processoConsult.jsp");
			direcionador.forward(request,response);
			
		}
		else if (acao.equals("consltDocumento")){
			//Protocolista 
			int numProtocolo = Integer.parseInt(request.getParameter("numProtocolo"));
			
			DocumentoDAO documentoDAO = new DocumentoDAO();
		
			Documento documento = documentoDAO.consultar(numProtocolo);							
			request.setAttribute("doc", documento);
					
			RequestDispatcher direcionador = request.getRequestDispatcher("processoConsulta.jsp");
			direcionador.forward(request,response);
			
		}
		 else if (acao.equals("consultProc")){
				//Analista e Protocolista
				int numProtocolo = Integer.parseInt(request.getParameter("numProtocolo"));
				
				DocumentoDAO documentoDAO = new DocumentoDAO();
				Documento documento = documentoDAO.consultar(numProtocolo);	
				if(documento.getStatus()!= "Encerrado"){
				request.setAttribute("prot", documento);
				
				RequestDispatcher direcionador = request.getRequestDispatcher("alterarDoc.jsp");
				direcionador.forward(request,response);
				} 
				else if(documento.getStatus()== "Encerrado"){
					
					RequestDispatcher direcionador = request.getRequestDispatcher("erroAlterar.jsp");
					direcionador.forward(request,response);
					
				}
				
		}
		 else if (acao.equals("consultDetalh")){
				//Analista
			 	// vem do consProcAnalista e do outro
				int numProtocolo = Integer.parseInt(request.getParameter("numProtocolo"));
				
				DocumentoDAO documentoDAO = new DocumentoDAO();
				Documento documento = documentoDAO.consultar(numProtocolo);							
				request.setAttribute("procDeta", documento);
						
				RequestDispatcher direcionador = request.getRequestDispatcher("detalharDoc.jsp");
				direcionador.forward(request,response);
				
		}
		 else if (acao.equals("consProvi")){
				//Analista
			 	// vem do detalharDoc
				int numProtocolo = Integer.parseInt(request.getParameter("numProtocolo"));
				
				DocumentoDAO documentoDAO = new DocumentoDAO();
				Documento documento = documentoDAO.consultar(numProtocolo);							
				request.setAttribute("provideDeta", documento);
						
				RequestDispatcher direcionador = request.getRequestDispatcher("inserirProvidencia.jsp");
				direcionador.forward(request,response);
				
		}
		 else if (acao.equals("consultDetalhada")){
				
				int numProtocolo = Integer.parseInt(request.getParameter("numProtocolo"));
				
				DocumentoDAO documentoDAO = new DocumentoDAO();
				Documento documento = documentoDAO.consultar(numProtocolo);							
				request.setAttribute("procDetalha", documento);
						
				RequestDispatcher direcionador = request.getRequestDispatcher("detalhDocProt.jsp");
				direcionador.forward(request,response);
				
		}
		 else if (acao.equals("encerrarProcesso")){
			
			int numProtocolo = Integer.parseInt(request.getParameter("numProtocolo"));
					
			DocumentoDAO documentoDAO = new DocumentoDAO();
			Documento documento= new Documento(numProtocolo);
			Documento doc = documentoDAO.consultar(numProtocolo);	
			if(doc.getStatus().trim().equals("Encerrado")){
				
				request.setAttribute("procEnce", documento);
				
				RequestDispatcher direcionador = request.getRequestDispatcher("mensErroEncer.jsp");
				direcionador.forward(request,response);
				
			} 
			else{
				// colocar pra pegar a data atual
				documentoDAO.encerrarProcesso(documento); 
				
				RequestDispatcher direcionador = request.getRequestDispatcher("mensEncer.jsp");
				direcionador.forward(request,response);
				
			}
			
		}
		if (acao.equals("emitirRelatorio")){
		
		DocumentoDAO documentoDAO = new DocumentoDAO();
			
		request.getSession(true).setAttribute("relatorioDoc", documentoDAO.listarDoc());
						
		RequestDispatcher direcionador = request.getRequestDispatcher("relatorioProcesso.jsp");
		direcionador.forward(request,response);
		}
    }

}