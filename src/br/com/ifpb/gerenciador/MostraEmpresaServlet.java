package br.com.ifpb.gerenciador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostraEmpresaServlet
 */
@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Banco banco = new Banco();
	
	Empresa emp = new Empresa();
  
    public MostraEmpresaServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		
		emp = banco.buscaPeloId(id);
		
		System.out.println(emp.getNome());
		
		RequestDispatcher rd = request.getRequestDispatcher("formAlteraEmpresa.jsp");
		request.setAttribute("empresa", emp);
		rd.forward(request, response);
	}

}
