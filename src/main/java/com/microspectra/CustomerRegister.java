package com.microspectra;

import java.io.IOException;

import com.microspectra.util.Dbconnection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CustomerRegisterServlet")
public class CustomerRegister extends HttpServlet {

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
                          throws IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String branch = req.getParameter("branch");
        String password = req.getParameter("password");

        Dbconnection db = new Dbconnection();

        db.registerCustomer(
                name,
                email,
                phone,
                branch,
                password);

        resp.sendRedirect("login.html");
    }
}