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

@WebServlet("/SHOW_NOTES")
public class ShowNotesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        try {

            Dbconnection db = new Dbconnection();
            Connection con = db.connect();

            String query =
                "SELECT * FROM notes_demo ORDER BY note_id DESC";

            PreparedStatement psmt =
                con.prepareStatement(query);

            ResultSet rs =
                psmt.executeQuery();

            req.setAttribute(
                "notes",
                rs
            );

            RequestDispatcher rd =
                req.getRequestDispatcher(
                    "show_notes.jsp"
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