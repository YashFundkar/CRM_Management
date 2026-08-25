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

@WebServlet("/ADD_CUSTOMER_NOTE")
public class CustomerAddNoteServlet
       extends HttpServlet {

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws IOException {

        try {

            HttpSession session =
                req.getSession();

            String customerName =
                (String) session.getAttribute(
                    "customerName"
                );

            String title =
                req.getParameter("noteTitle");

            String description =
                req.getParameter("noteDescription");

            String date =
                req.getParameter("noteDate");

            Dbconnection db =
                new Dbconnection();

            Connection con =
                db.connect();

            String query =
            "INSERT INTO notes_demo(customer_name,note_title,note_description,note_date) VALUES(?,?,?,?)";

            PreparedStatement psmt =
                con.prepareStatement(query);

            psmt.setString(1, customerName);
            psmt.setString(2, title);
            psmt.setString(3, description);
            psmt.setString(4, date);

            psmt.executeUpdate();

            resp.sendRedirect(
                "CUSTOMER_NOTES"
            );

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}