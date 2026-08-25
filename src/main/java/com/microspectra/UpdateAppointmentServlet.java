package com.microspectra;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.microspectra.util.Dbconnection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/UPDATE_APPOINTMENT")
public class UpdateAppointmentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws IOException {

        try {

            int id =
                Integer.parseInt(
                    req.getParameter("appointmentId")
                );

            String name =
                req.getParameter("apname");

            String date =
                req.getParameter("apdate");

            String time =
                req.getParameter("aptime");

            Dbconnection db =
                new Dbconnection();

            Connection con =
                db.connect();

            String query =
            "UPDATE appointment_demo SET ap_name=?, ap_date=?, ap_time=? WHERE ap_id=?";

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, date);
            ps.setString(3, time);
            ps.setInt(4, id);

            ps.executeUpdate();

            resp.sendRedirect("showAppointment");

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}