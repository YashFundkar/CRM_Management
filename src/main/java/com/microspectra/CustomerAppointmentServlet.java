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

@WebServlet("/CUSTOMER_APPOINTMENT")
public class CustomerAppointmentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        try {

            HttpSession session = req.getSession(false);

            if(session == null) {
                resp.sendRedirect("login.html");
                return;
            }

            String customerName =
                (String) session.getAttribute("customerName");

            System.out.println("Customer = " + customerName);

            Dbconnection db = new Dbconnection();
            Connection con = db.connect();

            String query =
                "SELECT * FROM appointment_demo WHERE ap_name=?";

            PreparedStatement psmt =
                con.prepareStatement(query);

            psmt.setString(1, customerName);

            ResultSet rs = psmt.executeQuery();

            req.setAttribute("appointments", rs);

            RequestDispatcher rd =
                req.getRequestDispatcher(
                    "customer_appointments.jsp"
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