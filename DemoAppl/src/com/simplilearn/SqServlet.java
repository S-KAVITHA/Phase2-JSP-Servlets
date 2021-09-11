package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletConfig;
import javax.servlet.http.Cookie;

@SuppressWarnings("serial")
public class SqServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		int k = 0;

		// method 1 requestdispatcher syntax to get k value
		// int k = (int)req.getAttribute("k");

		// method 2 sendRedirect syntax to get k value
		// int k = Integer.parseInt(req.getParameter("k"));

		// method 3 : session
		/*
		 * HttpSession session = req.getSession(); int k = (int)
		 * session.getAttribute("k");
		 */

		// method 4 :cookie
		Cookie cookies[] = req.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("k"))
				k = Integer.parseInt(c.getValue());

		}

		k = k * k;

		PrintWriter out = res.getWriter();
		out.println("Result is : " + k);
		

		out.print("<br> Hi !!!");
		
		ServletConfig cg = getServletConfig();
		String str = cg.getInitParameter("name");
		out.print("Hi " + str + "!!!");
		
	}
}
