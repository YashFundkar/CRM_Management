package com.microspectra;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.microspectra.util.Dbconnection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/BOOK_APPOINTMENT")
public class BookAppointmentServlet
       extends HttpServlet {

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws IOException {

        try {

            HttpSession session =
                req.getSession(false);

            String customerName =
                (String) session.getAttribute(
                    "customerName"
                );

            String date =
                req.getParameter("date");

            String time =
                req.getParameter("time");

            String branch =
                req.getParameter("branch");

            Dbconnection db =
                new Dbconnection();

            Connection con =
                db.connect();

            String query =
            "INSERT INTO appointment_demo(ap_name,ap_date,ap_time,ap_branch) VALUES(?,?,?,?)";

            PreparedStatement psmt =
                con.prepareStatement(query);

            psmt.setString(1, customerName);
            psmt.setString(2, date);
            psmt.setString(3, time);
            psmt.setString(4, branch);

            int result = psmt.executeUpdate();

            System.out.println(
                "Appointment Added = " + result
            );

            resp.sendRedirect(
                "CUSTOMER_APPOINTMENT"
            );

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}