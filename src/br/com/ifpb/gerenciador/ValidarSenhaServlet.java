package br.com.ifpb.gerenciador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidarSenhaServlet
 */
@WebServlet("/validarsenhaservlet")
public class ValidarSenhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ValidarSenhaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String user = "diego";
		String password = "123";
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(request.getParameter("usuario"));
		usuario.setSenha(request.getParameter("senha"));
		
		if((usuario.getNome().equals(user)) && (usuario.getSenha().equals(password))) {
			
			response.sendRedirect("login-sucesso.html");
			
		}
		else {
			response.sendRedirect("login-falha.html");
		}
		
		
    	
	}

}
