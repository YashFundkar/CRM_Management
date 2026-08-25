package com.microspectra;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.microspectra.util.Dbconnection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/EDIT_APPOINTMENT")
public class EditAppointmentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws IOException {

        int id =
            Integer.parseInt(
                req.getParameter("appointmentId")
            );

        try {

            Dbconnection db =
                new Dbconnection();

            Connection con =
                db.connect();

            String query =
            "SELECT * FROM appointment_demo WHERE ap_id=?";

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs =
                ps.executeQuery();

            PrintWriter out =
                resp.getWriter();

            if(rs.next()) {

                out.println("""
                <!DOCTYPE html>
                <html>
                <head>
                <title>Edit Appointment</title>
                <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css' rel='stylesheet'>
                </head>
                <body class='container mt-5'>
                <div class='card shadow'>
                <div class='card-header bg-dark text-white'>
                <h3>Edit Appointment</h3>
                </div>
                <div class='card-body'>
                """);

                out.println("<form action='UPDATE_APPOINTMENT' method='post'>");

                out.println("<input type='hidden' name='appointmentId' value='"+rs.getInt("ap_id")+"'>");

                out.println("<label>Name</label>");
                out.println("<input type='text' class='form-control mb-3' name='apname' value='"+rs.getString("ap_name")+"'>");

                out.println("<label>Date</label>");
                out.println("<input type='date' class='form-control mb-3' name='apdate' value='"+rs.getString("ap_date")+"'>");

                out.println("<label>Time</label>");
                out.println("<input type='time' class='form-control mb-3' name='aptime' value='"+rs.getString("ap_time")+"'>");

                out.println("<button class='btn btn-success'>Save Changes</button>");

                out.println("</form>");
                out.println("</div></div></body></html>");
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}