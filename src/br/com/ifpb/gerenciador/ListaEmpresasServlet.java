package br.com.ifpb.gerenciador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresasServlet
 */
@WebServlet("/listaempresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Banco banco = new Banco();
		
		List<Empresa> lista = banco.getEmpresas();
		//PrintWriter out = response.getWriter();
		/*out.println("<html><body>");
		out.println("<ul>");
		for (Empresa empresa : lista) {
		out.println("<li>" + empresa.getNome() + "</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");*/
		
		RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas.jsp");
		req.setAttribute("empresas", lista);
		rd.forward(req,res);
	}

}
