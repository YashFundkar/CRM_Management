package com.microspectra.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public class Dbconnection {
	
	//Connection Creation
	public Connection connect()
	{
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String user = "root";
			String pass = "Admin@123";
			String url = "jdbc:mysql://localhost:3306/crmdemo";
			
	      con = DriverManager.getConnection(url,user,pass);
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Error :"+e);
		}
		return con;
	}	
	
	public void registerCustomer(
	        String name,
	        String email,
	        String phone,
	        String branch,
	        String password)
	{
	    try {

	        Connection con = connect();

	        String query =
	        "INSERT INTO customer_demo(name,email,phone,branch,customer_pass) VALUES(?,?,?,?,?)";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ps.setString(1, name);
	        ps.setString(2, email);
	        ps.setString(3, phone);
	        ps.setString(4, branch);
	        ps.setString(5, password);

	        int row = ps.executeUpdate();

	        System.out.println(row + " customer registered");

	    } catch(Exception e) {

	        System.out.println("Error : " + e);
	    }
	}
	
	//Customer CRUD operations
	//Add customer
	public void addCustomer(String name,String email,String number,String branch)
	{
		try {
		 Connection con = connect();
			String query = "INSERT INTO customer_demo (name,email,phone,branch)VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, number);
			ps.setString(4, branch);

			int row = ps.executeUpdate();	
			System.out.println(row+" customer row inserted");
		}
		catch(Exception e)
		{
			System.out.println("error : "+e);
		}
	}
	
	public void delCustomer(int id)
	{
		try {
			Connection con = connect();
			
			String delquery ="DELETE FROM customer_demo WHERE customer_id=?";
			PreparedStatement psmt = con.prepareStatement(delquery);
			psmt.setInt(1,  id);
			
			int row = psmt.executeUpdate();
			System.out.println(row+ " customer row deleted");
		}
		catch(Exception e){
			System.out.println("error :"+e);
		}
		
	}
	
	public ResultSet getCustomerById(int id)
	{
	    ResultSet rs = null;

	    try {
	        Connection con = connect();

	        String query =
	            "SELECT * FROM customer_demo WHERE customer_id=?";

	        PreparedStatement psmt =
	            con.prepareStatement(query);

	        psmt.setInt(1, id);

	        rs = psmt.executeQuery();
	    }
	    catch(Exception e)
	    {
	        System.out.println("error : " + e);
	    }

	    return rs;
	}
	
	
	public void updateCustomer(int id, String name, String email, String phone, String branch) {

	    Connection con = connect();

	    try {
	        String query = "UPDATE customer_demo SET name=?, email=?, phone=?, branch=? WHERE customer_id=?";

	        PreparedStatement psmt = con.prepareStatement(query);

	        psmt.setString(1, name);
	        psmt.setString(2, email);
	        psmt.setString(3, phone);
	        psmt.setString(4, branch);
	        psmt.setInt(5, id);

	        int rows = psmt.executeUpdate();

	        if(rows > 0) {
	            System.out.println("Customer Updated Successfully");
	        } else {
	            System.out.println("Customer Not Found");
	        }

	        psmt.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	public ResultSet showCustomer()
	{
		ResultSet rs = null;
		try {
			Connection con = connect();
			
			String query = "SELECT * FROM customer_demo";
			PreparedStatement psmt = con.prepareStatement(query);
			
			 rs = psmt.executeQuery();
		}catch(Exception e)
		{
			System.out.println("error : "+e);
		}
		return rs;
	}
		
	public void addAppointment(String ap_name,String ap_date,String ap_time ,String ap_branch)
	{
		try {
			Connection con = connect();
			
			String query = "INSERT INTO appointment_demo (ap_name,ap_date,ap_time,ap_branch) values(?,?,?,?)";
			PreparedStatement psmt = con.prepareStatement(query);
			
			psmt.setString(1, ap_name);
			psmt.setString(2, ap_date);
			psmt.setString(3, ap_time);
			psmt.setString(4, ap_branch);
			
			int row = psmt.executeUpdate();	
			System.out.println(row+"appointment inserted");
		}catch(Exception e)
		{
			System.out.println("error : "+e);
		}
	}
	
	public void delAppointment(int id)
	{
		try {
			Connection con = connect();
			
			String query = "DELETE FROM appointment_demo WHERE ap_id = ?";
			PreparedStatement psmt = con.prepareStatement(query);
			
			psmt.setInt(1, id);
			
			int row = psmt.executeUpdate();
			System.out.println(row+" appointment deleted");
		}catch(Exception e)
		{
			System.out.println("error "+e);
		}
		
		
	}
	
	public ResultSet showAppointment()
	{
		ResultSet rs = null;
		try {
			Connection con = connect();
			
			String query = "SELECT * FROM appointment_demo";
			PreparedStatement psmt = con.prepareStatement(query);
			
			 rs = psmt.executeQuery();			
		}catch(Exception e)
		{
			System.out.println("error "+e);
		}
		return rs;
	}
	
	
}
