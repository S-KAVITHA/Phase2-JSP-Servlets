package com.simplilearn;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
public class AddServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = i + j ;
		
		
		/* method 1 : to call another servlet
		 		req.setAttribute("k", k);
		RequestDispatcher rd = req.getRequestDispatcher("sq");
		rd.forward(req, res);
		
		*/
		
		
		// method 2 : to use send redirect
		//res.sendRedirect("sq?k="+k);
		
		
		
		// method 3 : sessions
		/*HttpSession session = req.getSession();
		session.setAttribute("k",k);
		res.sendRedirect("sq");
		*/
		
		

		
		//method 4 :cookies
		Cookie cookie = new Cookie("k",k + "");
		res.addCookie(cookie);
		res.sendRedirect("sq");
		
		
		
		
	}
	
	

}
