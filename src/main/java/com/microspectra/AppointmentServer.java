package com.microspectra;

import java.io.IOException;

import com.microspectra.util.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/APPOINTMENT")
public class AppointmentServer extends HttpServlet {
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException
	{
		
		
		String action = req.getParameter("action");
		
		Dbconnection db = new Dbconnection();
		if(action!=null && action.equals("addappoint"))
		{
			String apname = req.getParameter("apname");
			String apdate = req.getParameter("apdate");
			String aptime =req.getParameter("aptime");
			String apbranch = req.getParameter("apbranch");
			
			db.addAppointment(apname,apdate, aptime,apbranch);
			resp.sendRedirect("appointment.html");
		}
		else if(action != null && action.equals("delAppoint"))
		{
			int id =Integer.parseInt( req.getParameter("appointmentId"));
			db.delAppointment(id);
			 resp.sendRedirect("showAppointment");
		}
		
	}
	protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws IOException
	{
		doPost(req , resp);
	}

}
