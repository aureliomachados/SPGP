package mvc.controler;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.DAO.UsuarioDAO;
import mvc.beans.Usuario;


/**
 * Servlet implementation class ControleUsuario
 */
@WebServlet("/controleUsuario")
public class ControleUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao.equals("inserirUsuario")){
			
		
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String perfil = request.getParameter("perfil");
		String departamento = request.getParameter("departamento");
		String situacao = request.getParameter("situacao");
		
		Usuario usuario = new Usuario(cpf, nome, login, senha, perfil, departamento, situacao);
				
		UsuarioDAO.inserir(usuario);
	
		RequestDispatcher direcionador = request.getRequestDispatcher("manterUsuario.jsp");
		direcionador.forward(request,response);
					
	} 
	else if(acao.equals("alterarUsuario")){
			
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String perfil = request.getParameter("perfil");
		String departamento = request.getParameter("departamento");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuario = new Usuario(cpf, nome, login, senha, perfil, departamento);
		
		usuarioDAO.alterar(usuario);
		
		RequestDispatcher direcionador = request.getRequestDispatcher("manterUsuario.jsp");
		direcionador.forward(request,response);

	}
	else if (acao.equals("consultarUsuario")){
		
			String login = request.getParameter("login");
			
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = usuarioDAO.consultaUsuario(login);							
			request.setAttribute("user", usuario);
					
			RequestDispatcher direcionador = request.getRequestDispatcher("usuarioConsulta.jsp");
			direcionador.forward(request,response);
			
	}
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		  
		 if (acao.equals("listar")){
				
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				
				request.getSession(true).setAttribute("lista", usuarioDAO.listarUsuario());
							
				RequestDispatcher direcionador = request.getRequestDispatcher("consultarUsuario.jsp");
				direcionador.forward(request,response);
			}
		 else if (acao.equals("habilitarUsuario")){
				
				String login = request.getParameter("login");
						
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario= new Usuario(login);
						
				usuarioDAO.habilitar(usuario); 
				
				RequestDispatcher direcionador = request.getRequestDispatcher("manterUsuario.jsp");
				direcionador.forward(request,response);
			}
			else if (acao.equals("desabilitarUsuario")){
				
				String login = request.getParameter("login");
						
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario= new Usuario(login);
						
				usuarioDAO.desabilitar(usuario); 
				
				RequestDispatcher direcionador = request.getRequestDispatcher("manterUsuario.jsp");
				direcionador.forward(request,response);
			}
		 else if (acao.equals("consultarUsr")){
				
				String login = request.getParameter("login");
				
				
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = usuarioDAO.consultaUsuario(login);							
				request.setAttribute("user", usuario);
						
				RequestDispatcher direcionador = request.getRequestDispatcher("alterarUsuario.jsp");
				direcionador.forward(request,response);
				
		}
		 if (acao.equals("emitirRelatorioUs")){
				
			 UsuarioDAO usuarioDAO = new UsuarioDAO();
					
				request.getSession(true).setAttribute("relatorioUs", usuarioDAO.listarUsuario());
								
				RequestDispatcher direcionador = request.getRequestDispatcher("relatorioUsuario.jsp");
				direcionador.forward(request,response);
				}
		}
}
