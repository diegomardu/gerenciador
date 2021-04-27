package br.com.ifpb.gerenciador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		Empresa emp = new Empresa();
		
		String nomeEmpresa = req.getParameter("nome");
		String paramDataEmpresa = req.getParameter("data");
		
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
		
		emp.setNome(nomeEmpresa);
		emp.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		
		banco.adiciona(emp);
		
		resp.sendRedirect("listaempresas");
		
//		System.out.println("Cadastrando empresa...");
		
//		RequestDispatcher rd = req.getRequestDispatcher("/listaempresas");
//		req.setAttribute("empresa", emp.getNome());
//		rd.forward(req, resp);
		
		//String cnpjEmpresa = req.getParameter("cnpj");
		/*PrintWriter out = resp.getWriter();
		out.println("<html><body>Empresa " + nomeEmpresa + ""
		+ " cadastrada com sucesso</body></html>");*/
	}
	

} 
