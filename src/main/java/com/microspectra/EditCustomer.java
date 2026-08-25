package com.microspectra;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import com.microspectra.util.Dbconnection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editCustomer")
public class EditCustomer extends HttpServlet
{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException                     
    {
    	PrintWriter out = resp.getWriter();
    	
    	int id =Integer.parseInt(req.getParameter("customerId"));

    			Dbconnection db = new Dbconnection();
                ResultSet rs = db.getCustomerById(id);
    			
    			try {

    	            if(rs.next())
    	            {
    	                out.println("<html><head>");
    	                out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css' rel='stylesheet'>");
    	                out.println("</head><body>");

    	                out.println("<div class='container mt-5'>");
    	                out.println("<div class='card'>");

    	                out.println("<div class='card-header bg-success text-white'>");
    	                out.println("<h2>Update Customer</h2>");
    	                out.println("</div>");

    	                out.println("<div class='card-body'>");

    	                out.println("<form action='customerserv' method='post'>");

    	                out.println("<input type='hidden' name='customerId' value='"+rs.getInt("customer_id")+"'>");
    	                
    	                out.println("<label class='form-label'>Customer ID</label>");
    	                out.println("<input type='text' class='form-control mb-3' "
    	                          + "value='"+rs.getInt("customer_id")+"' readonly>");
    	                out.println("<input type='text' class='form-control mb-3' name='cname' value='"+rs.getString("name")+"'>");
    	                out.println("<input type='email' class='form-control mb-3' name='cemail' value='"+rs.getString("email")+"'>");
    	                out.println("<input type='text' class='form-control mb-3' name='cnumber' value='"+rs.getString("phone")+"'>");
    	                out.println("<input type='text' class='form-control mb-3' name='cbranch' value='"+rs.getString("branch")+"'>");

    	                out.println("<button class='btn btn-success' name='action' value='updCustomerBtn'>");
    	                out.println("Save Changes");
    	                out.println("</button>");

    	                out.println("</form>");

    	                out.println("</div>");
    	                out.println("</div>");
    	                out.println("</div>");
    	                out.println("</body></html>");
    	            }

    	        } catch(Exception e) {
    	            out.println(e);
    	        }
    	    }

    }
