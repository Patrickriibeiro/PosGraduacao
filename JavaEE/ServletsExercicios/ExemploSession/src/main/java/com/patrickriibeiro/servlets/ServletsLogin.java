package com.patrickriibeiro.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletsLogin
 */
@WebServlet(urlPatterns = { "/validacao" }, initParams = { @WebInitParam(name = "user", value = "admin"),
		@WebInitParam(name = "pwd", value = "admin") })
public class ServletsLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletsLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String nome = (String) session.getAttribute("jnomeUser");

		PrintWriter out = response.getWriter();

		if (nome == null) {
			response.sendRedirect("login.jsp");
		} else {
			out.print("Usuário validado: " + nome);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// obter os parametros de inicialização
		String usuario = this.getServletConfig().getInitParameter("user");
		String senha = this.getServletConfig().getInitParameter("pwd");

		// obter os valores do formulário
		String user = request.getParameter("nome");
		String pass = request.getParameter("senha");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		if (usuario.equals(user) && senha.equals(pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("jnomeUser", user);
			session.setAttribute("juserpass", pass);
			out.print("Parabéns! Usuário validado!");
		} else {
			out.print("Usuário ou senha invalidos.");
		}
	}

}
