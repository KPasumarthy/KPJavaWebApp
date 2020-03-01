package com.kpjavapackage;

import java.sql.*;

import com.mysql.*;
import com.mysql.jdbc.*;

import java.util.*;

public class MySQLJDBConnection {

	//KP : Class Level Variables
	private static String url  = "jdbc:mysql://localhost/";
	private static String database = "world";
	private static String user = "user";
	private static String password = "password";
	private static Connection conn = null;
	private static Properties connProps = new Properties();
    
	
	/**
	 * MySQLJDBConnection() Class Constructor
	 */
	public MySQLJDBConnection() {
		// TODO Auto-generated constructor stub
		CreateMySQLJDBConnection();
	}
	
	/**
	 * @author Kailash Pasumarthy
	 * MySQLJDBConnection Class : CreateMySQLJDBConnection() 
	 */
	public void CreateMySQLJDBConnection() {	
		try 
		{	
			//Register (or) Load MySQL JDBC Drivers
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			//Connection Properties
			connProps.put("database", database);
			connProps.put("user", user);
			connProps.put("password", password);
			
			//MySQL DriverManager getConnection()
			conn =  DriverManager.getConnection(url, connProps);
			System.out.println("KP : MySQL DriverManager.getConnection() Successful!");				
		}
		catch(SQLException ex)
		{
			System.out.println("KP : Failed MySQL Select statement!");
			System.out.println(ex);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	/**
	 * @author Kailash Pasumarthy
	 * MySQLJDBConnection Class : Select() 
	 */
	public void Select() {	
		try 
		{	
			//conn =  DriverManager.getConnection(url, connProps);
			//System.out.println("KP : MySQL DriverManager.getConnection() Successful!");		
			
		    //Execute a query
		    System.out.println("KP : Creating Java MySQL statement...");
		    Statement stmt = conn.createStatement();

		    String sql = "Select * From world.city";
		    ResultSet rs = stmt.executeQuery(sql);
		    //Extract data from result set
		    while(rs.next()){
		       //Retrieve by column name
		       int id  = rs.getInt("ID");
		       String name = rs.getString("Name");
		       String countrycode = rs.getString("CountryCode");
		       String district = rs.getString("District");
		       String population = rs.getString("Population");

		       //Display values
		       System.out.print("ID: " + id);
		       System.out.print(", Name: " + name);
		       System.out.print(", CountryCode: " + countrycode);
		       System.out.print(", District: " + district);
		       System.out.println(", Population: " + population);
		    }
		    rs.close();
		}
		catch(SQLException ex)
		{
			System.out.println("KP : Failed MySQL Select statement!");
			System.out.println(ex);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	
	/**
	 * @author Kailash Pasumarthy
	 * MySQLJDBConnection Class : Select() 
	 */
	public String SelectWorldCities() {	
		
		StringBuilder rsString = new StringBuilder();
		try 
		{	
			//conn =  DriverManager.getConnection(url, connProps);
			//System.out.println("KP : MySQL DriverManager.getConnection() Successful!");		
			
		    //Execute a query
		    System.out.println("KP : Creating Java MySQL statement...");
		    Statement stmt = conn.createStatement();

		    String sql = "Select * From world.city";
		    ResultSet rs = stmt.executeQuery(sql);
		    //Extract data from result set
		    while(rs.next()){
		       //Retrieve by column name
		       int id  = rs.getInt("ID");
		       String name = rs.getString("Name");
		       String countrycode = rs.getString("CountryCode");
		       String district = rs.getString("District");
		       String population = rs.getString("Population");

		       //Display values on console
		       System.out.print("ID: " + id);
		       System.out.print(", Name: " + name);
		       System.out.print(", CountryCode: " + countrycode);
		       System.out.print(", District: " + district);
		       System.out.println(", Population: " + population);
		       
		       rsString.append("ID: ").append(id).append(" Name: ").append(name).append(", CountryCode: ").append(countrycode).append(", Population: " + population + "\n");		       
		    }
		    rs.close();
		}
		catch(SQLException ex)
		{
			System.out.println("KP : Failed MySQL Select statement!");
			System.out.println(ex);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		return rsString.toString();
					
	}

				
	/**
	 * @author Kailash Pasumarthy
	 * MySQLJDBConnection Class : TestMySQLJDBConnection() : Primitive MySQL DB Connection 
	 */
	public void TestMySQLJDBConnection() {
	
		//Create the JDBC Connection
		String url  = "jdbc:mysql://localhost/world?";	//KP : World DB exists on MySQL
		String user = "user=username";
		String password = "password=password";
		
		//Retrieving data using SQL Query
		String sql = new String("select * From world.city");
		Connection conn = null;
		try 
		{	
			//Register (or) Load MySQL JDBC Drivers
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			conn =  DriverManager.getConnection(url + user + "&" + password);
			System.out.println("KP : DriverManager.getConnection()!");	
			Statement st = conn.createStatement();
			System.out.println("KP : Connection.CreateStatement!");	
			boolean bflag = st.execute(sql);
			if(bflag) 
			{
				System.out.println("KP : Successful MySQL Select statement!");				
			}
			else
			{
				System.out.println("KP : Failed MySQL Select statement!");
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}


