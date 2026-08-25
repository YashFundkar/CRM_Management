package com.microspectra;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.microspectra.util.Dbconnection;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req , HttpServletResponse resp) throws IOException
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
			
			String query = "Select * from admin_login where admin_email=? and admin_password=?";
			PreparedStatement psmt = con.prepareStatement(query);
			
			psmt.setString(1, email);
			psmt.setString(2, password);
			
			System.out.println("Email: " + email);
			System.out.println("Password: " + password);
			ResultSet rs =  psmt.executeQuery();
			if(rs.next())
			{
				resp.sendRedirect("DASHBOARD");
			}else {
				 resp.setContentType("text/html");

				    out.println("<script>");
				    out.println("alert('Invalid email or password');");
				    out.println("location='login.html';");
				    out.println("</script>");
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
