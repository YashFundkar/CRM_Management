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

@WebServlet("/CUSTOMER_DASHBOARD")
public class CustomerDashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        try {
        	resp.setHeader("Cache-Control",
                    "no-cache, no-store, must-revalidate");
            resp.setHeader("Pragma", "no-cache");
            resp.setDateHeader("Expires", 0);
            HttpSession session = req.getSession(false);

            if(session == null) {
                resp.sendRedirect("login.html");
                return;
            }

            String customerName =
                (String) session.getAttribute("customerName");

            Dbconnection db = new Dbconnection();
            Connection con = db.connect();

            // Appointment Count
            String countQuery =
                "SELECT COUNT(*) FROM appointment_demo WHERE ap_name=?";

            PreparedStatement countPsmt =
                con.prepareStatement(countQuery);

            countPsmt.setString(1, customerName);

            ResultSet countRs =
                countPsmt.executeQuery();

            int appointmentCount = 0;

            if(countRs.next()) {
                appointmentCount =
                    countRs.getInt(1);
            }

            req.setAttribute(
                "appointmentCount",
                appointmentCount
            );
            
            // Notes Count
            String noteQuery =
            		"SELECT COUNT(*) FROM notes_demo WHERE customer_name=?";

            		PreparedStatement notePsmt =
            		con.prepareStatement(noteQuery);

            		notePsmt.setString(1, customerName);

            		ResultSet noteRs =
            		notePsmt.executeQuery();

            		int noteCount = 0;

            		if(noteRs.next())
            		{
            		    noteCount = noteRs.getInt(1);
            		}

            		req.setAttribute("noteCount", noteCount);

            // Recent Appointments
            String recentQuery =
                "SELECT * FROM appointment_demo WHERE ap_name=? ORDER BY ap_id DESC LIMIT 5";

            PreparedStatement recentPsmt =
                con.prepareStatement(recentQuery);

            recentPsmt.setString(1, customerName);

            ResultSet recentRs =
                recentPsmt.executeQuery();

            req.setAttribute(
                "recentAppointments",
                recentRs
            );

            RequestDispatcher rd =
                req.getRequestDispatcher(
                    "customer_dashboard.jsp"
                );

            rd.forward(req, resp);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        doGet(req, resp);
    }
}