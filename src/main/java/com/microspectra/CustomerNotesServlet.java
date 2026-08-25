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

@WebServlet("/CUSTOMER_NOTES")
public class CustomerNotesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        try {
        	resp.setHeader("Cache-Control",
                    "no-cache, no-store, must-revalidate");
            resp.setHeader("Pragma", "no-cache");
            resp.setDateHeader("Expires", 0);

            HttpSession session =
                req.getSession();

            String customerName =
                (String) session.getAttribute(
                    "customerName"
                );

            Dbconnection db =
                new Dbconnection();

            Connection con =
                db.connect();

            String query =
            "SELECT * FROM notes_demo WHERE customer_name=? ORDER BY note_id DESC";

            PreparedStatement psmt =
                con.prepareStatement(query);

            psmt.setString(1, customerName);

            ResultSet rs =
                psmt.executeQuery();

            req.setAttribute(
                "notes",
                rs
            );

            RequestDispatcher rd =
                req.getRequestDispatcher(
                    "customer_notes.jsp"
                );

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