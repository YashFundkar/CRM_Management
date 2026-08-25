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

@WebServlet("/BRANCH")
public class BranchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {

            Dbconnection db = new Dbconnection();
            Connection con = db.connect();

            // Shegaon Customers count
            String query1 =
                "SELECT COUNT(*) FROM customer_demo WHERE branch='SHEGAON'";

            PreparedStatement psmt1 =
                con.prepareStatement(query1);

            ResultSet rs1 = psmt1.executeQuery();

            int shegaonCustomers = 0;

            if(rs1.next())
            {
                shegaonCustomers = rs1.getInt(1);
            }

            req.setAttribute(
                "shegaonCustomers",
                shegaonCustomers
            );

            
            //PUNE customer count
            int PUNECustomer = 0  ;
            String query2 = "SELECT COUNT(*) FROM customer_demo WHERE branch = 'PUNE'";
            PreparedStatement psmt2 =  con.prepareStatement(query2);
            
            ResultSet rs2 =  psmt2.executeQuery();
            
            if(rs2.next()) {
               PUNECustomer = 	rs2.getInt(1);
            }
            req.setAttribute("PUNECustomer", PUNECustomer);
            
            
            //Akola customer count
            int akolaCustomer = 0  ;
            String query3 = "SELECT COUNT(*) FROM customer_demo WHERE branch = 'AKOLA'";
            PreparedStatement psmt3 =  con.prepareStatement(query3);
            
            ResultSet rs3 =  psmt3.executeQuery();
            
            if(rs3.next()) {
               akolaCustomer = 	rs3.getInt(1);
            }
            req.setAttribute("akolaCustomer", akolaCustomer);
           

           

            //shegaon appointment count
            int shegaonAppointment = 0;
            
            String query4 = "SELECT COUNT(*) FROM appointment_demo WHERE ap_branch = 'SHEGAON'";
            PreparedStatement psmt4 =  con.prepareStatement(query4);
            
            ResultSet rs4 =  psmt4.executeQuery();
            
            if(rs4.next())
            {
            	shegaonAppointment = rs4.getInt(1);
            }
            req.setAttribute("shegaonAppointment", shegaonAppointment);
            
            
          //PUNE appointment count
            int PUNEAppointment = 0;
            
            String query5 = "SELECT COUNT(*) FROM appointment_demo WHERE ap_branch = 'PUNE'";
            PreparedStatement psmt5 =  con.prepareStatement(query5);
            
            ResultSet rs5 =  psmt5.executeQuery();
            
            if(rs5.next())
            {
            	PUNEAppointment = rs5.getInt(1);
            }
            
            req.setAttribute("PUNEAppointment", PUNEAppointment);
            
            
          //Akola appointment count
            int akolaAppointment = 0;
            
            String query6 = "SELECT COUNT(*) FROM appointment_demo WHERE ap_branch = 'AKOLA'";
            PreparedStatement psmt6 =  con.prepareStatement(query6);
            
            ResultSet rs6 =  psmt6.executeQuery();
            if(rs6.next())
            {
            	akolaAppointment = rs6.getInt(1);
            }
            
            req.setAttribute("akolaAppointment",akolaAppointment);
            
            RequestDispatcher rd = req.getRequestDispatcher("branch.jsp");
            rd.forward(req, resp);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        doGet(req, resp);
    }
}