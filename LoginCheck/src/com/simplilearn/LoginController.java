package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String[] usernames = { "JohnSmith", "MikeSmith", "DavidMiller", "RajanRam", "RobertKim" };
		String[] passwords = { "John123*", "Mike123*", "David123*", "Raj123*", "Rob123*" };

		String get_username = request.getParameter("username");
		String get_password = request.getParameter("password");
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		
		
		int match = 0;
		for (int index = 0; index < usernames.length; index++) {
			String curr_uname = usernames[index];
			String curr_pwd = passwords[index];
			
			if (curr_uname.equalsIgnoreCase(get_username) &&  curr_pwd.equals(get_password)) {

				rd = request.getRequestDispatcher("SuccessServlet");
				rd.forward(request, response);
				match++;
			}
		}

		if (match == 0) {
			rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			out.println(("<center><span style = 'color:red'>Invalid Credentials!!!</span></center>"));
		}
	}

}
