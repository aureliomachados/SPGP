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
			
			
			String nomeInteressado = request.getParameter("nome");
			String cpf_cnpj = request.getParameter("cpf_cnpj");
			int numDoc = Integer.parseInt(request.getParameter("numDoc"));
			String dataDoc = request.getParameter("dataDoc");
			String assunto = request.getParameter("assunto");
			String dataEntrada = request.getParameter("dataEntrada");
			String tipo = request.getParameter("tipo");
			String status = request.getParameter("status");
			int analista = Integer.parseInt(request.getParameter("analista"));
			
			Documento documento = new Documento( nomeInteressado, cpf_cnpj, numDoc, dataDoc, assunto,dataEntrada, tipo, status, analista);
					
			DocumentoDAO.inserir(documento);
		
			RequestDispatcher direcionador = request.getRequestDispatcher("manterDocumento.jsp");
			direcionador.forward(request,response);
						
		} 
		else if(acao.equals("alterarDocumento")){
			
			int numProtolo = Integer.parseInt(request.getParameter("numProtolo"));
			String nomeInteressado = request.getParameter("nomeInteressado");
			String cpf_cnpj = request.getParameter("cpf_cnpj");
			int numDoc = Integer.parseInt(request.getParameter("numDoc"));
			String dataDoc = request.getParameter("dataDoc");
			String assunto= request.getParameter("assunto");
			String dataEntrada= request.getParameter("dataEntrada");
			String tipo= request.getParameter("tipo= request");
			String status= request.getParameter("tatus");
			int analista= Integer.parseInt(request.getParameter("analista"));
					
						
			DocumentoDAO documentoDAO = new DocumentoDAO();
			
			Documento documento = new Documento(numProtolo , nomeInteressado, cpf_cnpj, numDoc, dataDoc, assunto, dataEntrada, tipo, status, analista);
			
			documentoDAO.alterar(documento);
			
			RequestDispatcher direcionador = request.getRequestDispatcher("manterUsuario.jsp");
			direcionador.forward(request,response);

		}
		else if (acao.equals("consultarDocumento")){
			
			int numProtolo = Integer.parseInt(request.getParameter("numProtolo"));
			
			DocumentoDAO documentoDAO = new DocumentoDAO();
		
			Documento documento = documentoDAO.consultar(numProtolo);							
			request.setAttribute("doc", documento);
					
			RequestDispatcher direcionador = request.getRequestDispatcher("usuarioConsulta.jsp");
			direcionador.forward(request,response);
			
	}
		else if (acao.equals("encerrarProcesso")){
			
			int numProtolo = Integer.parseInt(request.getParameter("numProtolo"));
			String status= request.getParameter("tatus");
	
			DocumentoDAO documentoDAO = new DocumentoDAO();
			
			documentoDAO.encerrarProcesso(numProtolo,status);
	
			RequestDispatcher direcionador = request.getRequestDispatcher("manterDepartamento.jsp");
			direcionador.forward(request,response);
		}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if (acao.equals("listarDoc")){
				
			DocumentoDAO documentoDAO = new DocumentoDAO();
				
			request.getSession(true).setAttribute("listaDoc", documentoDAO.listarDoc());
							
			RequestDispatcher direcionador = request.getRequestDispatcher("consultarDepartamento.jsp");
			direcionador.forward(request,response);
			}
	}

}
