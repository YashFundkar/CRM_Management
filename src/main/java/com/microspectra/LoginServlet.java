package com.microspectra;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LOGIN")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upassword");
		
		if(uname.equals("admin") && upass.equals("123"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("/DASHBOARD");
			rd.forward(req, resp);
		}
		else 
		{
			RequestDispatcher rd = req.getRequestDispatcher("/login.html");
			rd.include(req, resp);
			out.println("<br><p style='color:red ; text-align:center;'>Wrong username/ password !! please try again</p>");
		}
	}

}
