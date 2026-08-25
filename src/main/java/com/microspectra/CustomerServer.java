package com.microspectra;
import com.microspectra.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/customerserv")
public class CustomerServer extends HttpServlet{
	
	protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html");
		Dbconnection db = new Dbconnection();
		db.connect();
		
		String action = req.getParameter("action");
		
		if(action!=null && action.equals("addCustomerBtn"))
		{
			String name = req.getParameter("cname");
			String email = req.getParameter("cemail");
			String number = req.getParameter("cnumber");
			String branch = req.getParameter("cbranch");
			
			db.addCustomer(name, email, number, branch);
			resp.sendRedirect("customer.html");
		}
		else if(action!=null && action.equals("delCustomerBtn"))
		{
			int id = Integer.parseInt(req.getParameter("customerId"));
			System.out.println("Deleting id = " +id);
			
			db.delCustomer(id);
			resp.sendRedirect("showCustomer");
		}
		else if(action != null && action.equals("updCustomerBtn"))
		{
		    int id = Integer.parseInt(req.getParameter("customerId"));

		    String name = req.getParameter("cname");
		    String email = req.getParameter("cemail");
		    String number = req.getParameter("cnumber");
		    String branch = req.getParameter("cbranch");

		    db.updateCustomer(id, name, email, number, branch);

		    resp.sendRedirect("showCustomer");
		}
		
		
	}
	
	protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws IOException
	{
		doPost(req,resp);
	}

}
