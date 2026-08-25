package com.microspectra;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.microspectra.util.Dbconnection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CUSTOMER_CSV")
public class DownloadCustomer extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/csv");
        resp.setHeader("Content-Disposition",
                "attachment; filename=customer_report.csv");

        PrintWriter out = resp.getWriter();

        out.println("ID,Name,Email,Mobile.no,Branch");

        try {
            Dbconnection db = new Dbconnection();
            Connection con = db.connect();

            String query = "SELECT * FROM customer_demo";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                out.println(
                    rs.getInt("customer_id") + "," +
                    rs.getString("name") + "," +
                    rs.getString("email") + "," +
                    rs.getString("phone") + "," +
                    rs.getString("branch")
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void doGet(HttpServletRequest req , HttpServletResponse resp) throws IOException
    {
    	doPost(req,resp);
    }
}