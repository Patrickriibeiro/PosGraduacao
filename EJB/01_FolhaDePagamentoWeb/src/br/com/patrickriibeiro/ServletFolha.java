package br.com.patrickriibeiro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.patrickriibeiro.interfaces.FolhaPagamento;

@WebServlet("/folha")
public class ServletFolha extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	FolhaPagamento fp;

	public ServletFolha() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/salario.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		try {
			int salario = Integer.parseInt(req.getParameter("salario"));
			fp.setSalario(salario);
			out.print("Salario Bruto: " + salario);
			out.print("<br/> Salario Liquido: " + fp.calcularSalarioLiquido());

			out.print("<br/>");

			out.print(fp.getSalario());
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}