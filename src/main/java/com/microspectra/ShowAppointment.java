package com.microspectra;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.microspectra.util.Dbconnection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/showAppointment")
public class ShowAppointment extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Dbconnection db = new Dbconnection();
        ResultSet rs = db.showAppointment();

        out.println("""
        		<!DOCTYPE html>
        		<html>
        		<head>
        		<title>Appointments</title>

        		<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css' rel='stylesheet'>
                 

        		<style>
        		body{
        		    background-color:#f8f9fa;
        		}
        		
        		@media print {

				    .no-print {
				        display: none !important;
				    }
				}
        		</style>

        		</head>

        		<body>

        		<div class='container mt-4'>

        		<h2 class='text-center mb-4'>Appointment Management</h2>

        		<div class='mb-3 no-print'>
        		    <a href='appointment.html' class='btn btn-secondary'>Back</a>

        		    <button onclick='window.print()' class='btn btn-primary '>
        		        Print
        		    </button>

        		    <a href='APPOINTMENT_CSV' class='btn btn-success '>
        		        Download CSV
        		    </a>

        		    <a href='APPOINTMENT_PDF' class='btn btn-danger '>
        		        Download PDF
        		    </a>
        		</div>

        		<div class='card shadow'>

        		<div class='card-header bg-dark text-white'>
        		    Customer Records
        		</div>

        		<div class='card-body'>

        		<table class='table table-bordered table-hover'>

        		<thead class='table-dark'>
        		<tr>
        		<th>Appointment_ID</th>
        		<th>Customer_Name</th>
        		<th>Date</th>
        		<th>Time</th>
        		<th class = 'no-print'>Action</th>
        		</tr>
        		</thead>

        		<tbody>
        		""");

        try {
            while (rs.next()) {

                out.println("<tr>");
                out.println("<td>" + rs.getInt("ap_id") + "</td>");
                out.println("<td>" + rs.getString("ap_name") + "</td>");
                out.println("<td>" + rs.getString("ap_date") + "</td>");
                out.println("<td>" + rs.getString("ap_time") + "</td>");
                out.println("<td class='no-print'>");

             // Update Button
             out.println("<form action='EDIT_APPOINTMENT' method='get' style='display:inline;'>");
             out.println("<input type='hidden' name='appointmentId' value='" + rs.getInt("ap_id") + "'>");
             out.println("<button class='btn btn-outline-warning btn-sm me-2'>Update</button>");
             out.println("</form>");

             // Delete Button
             out.println("<form action='APPOINTMENT' method='post' style='display:inline;'>");
             out.println("<input type='hidden' name='action' value='delAppoint'>");
             out.println("<input type='hidden' name='appointmentId' value='" + rs.getInt("ap_id") + "'>");
             out.println("<button class='btn btn-outline-danger btn-sm '>Delete</button>");
             out.println("</form>");

             out.println("</td>");
                out.println("</tr>");
            }
        } catch (Exception e) {
            out.println(e);
        }

        out.println("""
        </tbody>
        </table>
        </div>
        </div>
        </div>
        </body>
        </html>
        """);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException 
    {
        doGet(req, resp);
    }

    }
