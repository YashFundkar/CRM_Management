package com.microspectra;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.microspectra.util.Dbconnection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NOTES")
public class NotesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws IOException {

        try {
        	//UPDATE NOTE
        	
        	String action = req.getParameter("action");

        	if(action != null && action.equals("deleteNote"))
        	{
        	    int noteId =
        	        Integer.parseInt(
        	            req.getParameter("noteId"));

        	    Dbconnection db =
        	        new Dbconnection();

        	    Connection con =
        	        db.connect();

        	    String deleteQuery =
        	        "DELETE FROM notes_demo WHERE note_id=?";

        	    PreparedStatement deletePsmt =
        	        con.prepareStatement(deleteQuery);

        	    deletePsmt.setInt(1, noteId);

        	    deletePsmt.executeUpdate();

        	    resp.sendRedirect("SHOW_NOTES");
        	    return;
        	}
        	
        	//ADD NOTE

            String customerName =
                req.getParameter("customerName");

            String noteTitle =
                req.getParameter("noteTitle");

            String noteDescription =
                req.getParameter("noteDescription");

            String noteDate =
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
            psmt.setString(2, noteTitle);
            psmt.setString(3, noteDescription);
            psmt.setString(4, noteDate);

            int result = psmt.executeUpdate();

            if(result > 0)
            {
                System.out.println("Note Added Successfully");
            }

            resp.sendRedirect("SHOW_NOTES");

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
  
}