package com.kpjavapackage;

import java.sql.*;

import com.mysql.*;
import com.mysql.jdbc.*;

import java.util.*;

public class MySQLJDBConnection {

	//KP : Class Level Variables
	private static String url  = "jdbc:mysql://localhost/";
	private static String database = "world";
	private static String user = "svcaccount";				///"user";
	private static String password = "(svcP@33word)";		///"password";
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
		       
		       rsString.append("ID: " + id)
		       			.append(", Name: " + name)
		       			.append(", CountryCode: " + countrycode)
		       			.append(", Population: " + population + "\n");		       
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
	 * OracleJDBConnection Class : Select() 
	 */
	//public void Select() {	
	public String Select2GetHTMLTable() {	
		StringBuilder rsString = new StringBuilder();
		StringBuilder sbHTMLTable = new StringBuilder();
		String strHTMLTable = "";
		try 
		{	
			//conn =  DriverManager.getConnection(url, connProps);
			//CreateMySQLJDBConnection();
			//System.out.println("KP : Oracle DriverManager.getConnection() Successful!");					
			
		    //Execute a query
		    System.out.println("KP : Creating Java Oracle SQL statement...");
		    Statement stmt = conn.createStatement();

		    //String sql = "Select * From world.city";
		    String sql = "Select * From world.city";
		    //USERNAME, USER_ID, CREATED, COMMON, ORACLE_MAINTAINED, INHERITED, DEFAULT_COLLATION, IMPLICIT, ALL_SHARD		    
		    
		    strHTMLTable = "<style>table { font-family: arial, sans-serif;  border-collapse: collapse;  width: 100%;}td," +
		                   "th {  border: 1px solid #dddddd;  text-align: left;  padding: 8px;}tr:nth-child(even)" +
		    		       " {  background-color: #dddddd;}</style>";
		    
		    sbHTMLTable.append(strHTMLTable);
		    
		    strHTMLTable = 	"<table><tr><th>ID</th> <th>Name</th>" +  
		    				"<th>CountryCode</th> <th>District</th>" +
		    				"<th>Population</th> </tr>";
		    
		    sbHTMLTable.append(strHTMLTable);
		    
		    int colIndex = 1;
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
			       
			       rsString.append("ID: " + id)
			       			.append(", Name: " + name)
			       			.append(", CountryCode: " + countrycode)
			       			.append(", Population: " + population + "\n");		
			          			          			          
			       	//HTML Table	   
			       	sbHTMLTable.append("<tr><td>" + id  + "</td>"  )
			       		   .append("<td>" + name + "</td>"  	)
			       		   .append("<td>" + countrycode + "</td>"  )
			       		   .append("<td>" + district + "</td>"  )
			       		   .append("<td>" + population + "</td>"  )
			       		   .append("</tr>");
			       		   		       		  			       		   
			       		   
			    }
			    rs.close();
			    sbHTMLTable.append("</table>");
			    
			    
			    System.out.println(sbHTMLTable);
			    
		}
		catch(SQLException ex)
		{
			System.out.println("KP : Failed Oracle SQL Select statement!");
			System.out.println(ex);
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			ex.printStackTrace();
		}
		finally {			
			//CloseMySQLJDBConnection();
		}
		
		//return rsString.toString();
		return sbHTMLTable.toString();
	}
	
			
	/**
	 * @author Kailash Pasumarthy
	 * MySQLJDBConnection Class : CloseMySQLJDBConnection();
	 */
	public void CloseMySQLJDBConnection() {	
		try 
		{	
			////Register (or) Load MySQL JDBC Drivers
			//DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
			
			////Connection Properties
			//connProps.put("database", database);
			//connProps.put("user", user);
			//connProps.put("password", password);
			
			//MySQL DriverManager getConnection()
			//conn =  DriverManager.getConnection(url, connProps);
			if(conn != null) {
				conn.close();
				System.out.println("KP : MySQL Connection Closed Successfully!");	
			}
		}
		catch(SQLException ex)
		{
			System.out.println("KP :  MySQL Connection Close Failed!");				
			System.out.println(ex);
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * @author Kailash Pasumarthy
	 * MySQLJDBConnection Class : TestMySQLJDBConnection() : Primitive MySQL DB Connection 
	 */
	public void TestMySQLJDBConnection() {
	
		//Create the JDBC Connection
		String url  = "jdbc:mysql://localhost/world?";	//KP : World DB exists on MySQL
		String user = "user=svcaccount";
		String password = "password=(svcP@33word)";
		
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


