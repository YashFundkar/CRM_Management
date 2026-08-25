package com.microspectra;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.microspectra.util.Dbconnection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/APPOINTMENT_CSV")
public class DownloadAppointment extends HttpServlet {
	
	public void doPost(HttpServletRequest req , HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/csv");
		resp.setHeader("Content-Disposition",
                "attachment; filename=appointment_report.csv");
		
		
		
		PrintWriter out = resp.getWriter();
		
		out.println("Appoint_id , Customer_name , Date , Time");
		
		try {
			Dbconnection db = new Dbconnection();
			Connection con = db.connect();
			
			PreparedStatement psmt =  con.prepareStatement("SELECT * FROM appointment_demo");
			ResultSet rs = psmt.executeQuery();		
			
			while(rs.next())
			{
				out.println(rs.getInt(1)+ " ,"+
			                rs.getString(2)+ ", "+
						    rs.getString(3)+ ", "+
			                rs.getString(4)
			                               );
				
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		doPost(req,resp);
		
	}

}
