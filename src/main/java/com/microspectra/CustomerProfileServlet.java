package com.microspectra;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.microspectra.util.Dbconnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CUSTOMER_PROFILE")
public class CustomerProfileServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
                         throws ServletException, IOException
    {
        try
        {
        	resp.setHeader("Cache-Control",
                    "no-cache, no-store, must-revalidate");
            resp.setHeader("Pragma", "no-cache");
            resp.setDateHeader("Expires", 0);
            
            HttpSession session =req.getSession(false);
            
            if(session == null)
            {
                resp.sendRedirect("login.html");
                return;
            }

            int customerId =(Integer)session.getAttribute("customerId");

            Dbconnection db =new Dbconnection();

            Connection con = db.connect();

            String query = "select * from customer_demo where customer_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();

            
            
            if(rs.next())
            {
            	String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String branch = rs.getString("branch");
                
                req.setAttribute("name",name);
                req.setAttribute("email",email);
                req.setAttribute("phone",phone);
                req.setAttribute("branch",branch);
            }

            RequestDispatcher rd = req.getRequestDispatcher("customer_profile.jsp");

            rd.forward(req, resp);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}