package com.microspectra;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.microspectra.util.Dbconnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet  extends HttpServlet{
	
	public void doPost(HttpServletRequest req , HttpServletResponse resp) throws IOException, ServletException
	{
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		if (email == null || email.trim().isEmpty()) {
		    out.println("Email is required");
		    return;
		}

		if (password == null || password.trim().isEmpty()) {
		    out.println("Password is required");
		    return;
		}

		if (password.length() < 6) {
		    out.println("Password must be at least 6 characters");
		    return;
		}
		
		try {
		Dbconnection db = new Dbconnection();
		Connection con = db.connect();
		
		String query = "Select * from customer_demo where email=? and customer_pass=?";
		PreparedStatement psmt =  con.prepareStatement(query);
		
		psmt.setString(1, email);
		psmt.setString(2, password);
		ResultSet rs =  psmt.executeQuery();
		
		if(rs.next())
		{
		    HttpSession session = req.getSession();
		    

		    int customerId = rs.getInt("customer_id");
		    String name = rs.getString("name");

		    session.setAttribute("customerId", customerId);
		    session.setAttribute("customerName", name);

		    System.out.println("Login Customer = " + name);

		    resp.sendRedirect("CUSTOMER_DASHBOARD");
		}
		else
		{
		    resp.setContentType("text/html");

		    out.println("<script>");
		    out.println("alert('Invalid email or password');");
		    out.println("location='login.html';");
		    out.println("</script>");
	    }
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
		}
	}

}
