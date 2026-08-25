package com.microspectra;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.microspectra.util.Dbconnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DASHBOARD")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int customerCount = 0;
        int appointmentCount = 0;
        int notesCount = 0;

        try {

            Dbconnection db = new Dbconnection();
            Connection con = db.connect();

            // =========================
            // CUSTOMER COUNT
            // =========================

            String cquery = "SELECT COUNT(*) FROM customer_demo";

            PreparedStatement psmt = con.prepareStatement(cquery);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                customerCount = rs.getInt(1);
            }

            req.setAttribute("customerCount", customerCount);

            rs.close();
            psmt.close();


            // =========================
            // APPOINTMENT COUNT
            // =========================

            String aquery = "SELECT COUNT(*) FROM appointment_demo";

            PreparedStatement psmt2 = con.prepareStatement(aquery);
            ResultSet rs2 = psmt2.executeQuery();

            if (rs2.next()) {
                appointmentCount = rs2.getInt(1);
            }

            req.setAttribute("appointmentCount", appointmentCount);

            rs2.close();
            psmt2.close();


            // =========================
            // NOTES COUNT
            // =========================

            String nquery = "SELECT COUNT(*) FROM notes_demo";

            PreparedStatement psmt3 = con.prepareStatement(nquery);
            ResultSet rs3 = psmt3.executeQuery();

            if (rs3.next()) {
                notesCount = rs3.getInt(1);
            }

            req.setAttribute("notesCount", notesCount);

            rs3.close();
            psmt3.close();


            // =========================
            // UPCOMING APPOINTMENTS
            // =========================

           
            		String sql =
					"SELECT ap_name, ap_date " +
					"FROM appointment_demo " +
					"WHERE ap_date >= CURDATE() " +
					"ORDER BY ap_date ASC " +
					"LIMIT 5";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs4 = ps.executeQuery();

            List<String> upcoming = new ArrayList<>();

            while (rs4.next()) {

                upcoming.add(
                    rs4.getString("ap_name")
                    + " - "
                    + rs4.getDate("ap_date")
                );
            }

            req.setAttribute("upcoming", upcoming);

            rs4.close();
            ps.close();

            con.close();


            // =========================
            // SEND DATA TO JSP
            // =========================

            RequestDispatcher rd =
                    req.getRequestDispatcher("admin_dashboard.jsp");

            rd.forward(req, resp);


        } catch (Exception e) {

            e.printStackTrace();
            resp.getWriter().println(e.getMessage());
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doGet(req, resp);
    }
}