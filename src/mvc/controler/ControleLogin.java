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
 * Servlet implementation class ControleLogin
 */
@WebServlet("/controleLogin")
public class ControleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
					
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuario = usuarioDAO.consultar(login);
		RequestDispatcher direcionador = null;
		
		if (usuario.getSenha().trim().equals(senha.trim())){
			request.getSession(true).setAttribute("usuarioOK", usuario);
		
			if ((usuario.getSituacao().trim().equals("Ativo"))) {
				
				if (usuario.getPerfil().trim().equals("Administrador")){
					direcionador = request.getRequestDispatcher("homeAdm.jsp");
				}
				else if(usuario.getPerfil().trim().equals("Analista")){
					direcionador = request.getRequestDispatcher("homeAnalista.jsp");
				}
				else if(usuario.getPerfil().trim().equals("Protocolista")){
					direcionador = request.getRequestDispatcher("homeProtocolista.jsp");
				}
			}
		} else direcionador = request.getRequestDispatcher("falhaLogin.jsp");
			   direcionador.forward(request,response);
	}
}