package mvc.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.DAO.DepartamentoDAO;
import mvc.beans.Departamento;




/**
 * Servlet implementation class ControleDepto
 */
@WebServlet("/controleDpto")
public class ControleDpto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleDpto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String acao = request.getParameter("acao");
				
		if(acao.equals("inserirDepartamento")){
			 			
			String nome = request.getParameter("nome"); 
		
			Departamento departamento = new Departamento();
			
			departamento.setNome(nome);

			DepartamentoDAO.inserirDepartamento(departamento); 
						
			RequestDispatcher direcionador = request.getRequestDispatcher("manterDepartamento.jsp");
			direcionador.forward(request,response);
	
	}
		else if(acao.equals("alterarDepartamento")){
				
				int codDpto = Integer.parseInt(request.getParameter("codigo")); 
				String nome = request.getParameter("nome");
								
				DepartamentoDAO departamentoDAO = new DepartamentoDAO();
				
				Departamento departamento = new Departamento(codDpto, nome);
				
				departamentoDAO.alterarDepartamento(departamento);
				
				RequestDispatcher direcionador = request.getRequestDispatcher("manterDepartamento.jsp");
				direcionador.forward(request,response);
		
		}
			else 
				if (acao.equals("consultarDepartamento")){
				
					String nome = request.getParameter("nome");
					
					DepartamentoDAO departamentoDAO = new DepartamentoDAO();
					Departamento departamento = departamentoDAO.consultarDepartamento(nome);
					request.setAttribute("consDpto", departamento);
					
					RequestDispatcher direcionador = request.getRequestDispatcher("departamentoConsulta.jsp");
					direcionador.forward(request,response);
				}
				
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if (acao.equals("listarDpto")){
			
			DepartamentoDAO departamentoDAO = new DepartamentoDAO();
			
			request.getSession(true).setAttribute("listaDpto", departamentoDAO.listarDepartamento());
						
			RequestDispatcher direcionador = request.getRequestDispatcher("consultarDepartamento.jsp");
			direcionador.forward(request,response);
		}
		else if (acao.equals("excluirDepartamento")){
			
			String nome = request.getParameter("nome");
			
	
			DepartamentoDAO departamentoDAO = new DepartamentoDAO();
			
			departamentoDAO.excluirDepartamento(nome);
	
			RequestDispatcher direcionador = request.getRequestDispatcher("manterDepartamento.jsp");
			direcionador.forward(request,response);
		}
		 else if (acao.equals("consultarDp")){
				
				String nome = request.getParameter("nome");
				
				
				DepartamentoDAO departamentoDAO = new DepartamentoDAO();
				Departamento departamento = departamentoDAO.consultarDepartamento(nome);							
				request.setAttribute("dpt", departamento);
						
				RequestDispatcher direcionador = request.getRequestDispatcher("alterarDepartamento.jsp");
				direcionador.forward(request,response);
				
		}
	}
}
