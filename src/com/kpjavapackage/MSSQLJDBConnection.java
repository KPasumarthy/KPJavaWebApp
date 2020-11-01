package com.kpjavapackage;

import java.util.*;
import java.util.ArrayList;
import java.util.Properties;


//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.json.JSONException;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MSSQLJDBConnection {

	//KP : Class Level Variables
	//private static String url  = "jdbc:mysql://localhost/";
	//private static String user = "svcaccount";				///"user";
	//private static String password = "(svcP@33word)";			///"password";
	//private static String url  = "jdbc:oracle:thin:@//localhost/orcl";
	//private static String database = "world";
	//private static String user = "sys as sysdba";				///"user";
	//private static String password = "Sita2008";				///"password";
		
	private static String url  =  "jdbc:sqlserver://localhost; databaseName=AdventureWorks2017; integratedSecurity=true";	
	//private static String user = "svcaccount";				///"user";	
	//private static String password = "(svcP@33word)";			///"password";
	//private static String url  = "jdbc:sqlserver://localhost/";

	
	private static Connection conn = null;
	private static Properties connProps = new Properties();
    
	
	/**
	 * OracleJDBConnection() Class Constructor
	 */
	public MSSQLJDBConnection() {
		// TODO Auto-generated constructor stub
		//CreateOracleJDBConnection();
	}
	
	/**
	 * @author Kailash Pasumarthy
	 * MSSQLJDBConnection Class : CreateMSSQLJDBConnection();
	 */
	public void CreateMSSQLJDBConnection() {	
		try 
		{	
			//Register (or) Load MySQL JDBC Drivers
			//DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
			//Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			
			//Connection Properties
			//connProps.put("database", database);
			//connProps.put("user", user);
			//connProps.put("password", password);
			
			//MySQL DriverManager getConnection()
			conn =  DriverManager.getConnection(url);
			System.out.println("KP : MS SQL DriverManager.getConnection() Successful!");				
		}
		catch(SQLException ex)
		{
			System.out.println("KP : MSSQL DriverManager.getConnection() Failed!");				
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
	 * MSSQLJDBConnection Class : CloseMSSQLJDBConnection();
	 */
	public void CloseMSSQLJDBConnection() {	
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
				System.out.println("KP : MS SQL Connection Closed Successfully!");	
			}
		}
		catch(SQLException ex)
		{
			System.out.println("KP :  MS SQL Connection Close Failed!");				
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
	 * MSSQLJDBConnection Class : Select() 
	 */
	//public void Select() {	
	public String Select() {	
		StringBuilder rsString = new StringBuilder();
		try 
		{	
			//conn =  DriverManager.getConnection(url, connProps);
			CreateMSSQLJDBConnection();
			//System.out.println("KP : Oracle DriverManager.getConnection() Successful!");					
			
		    //Execute a query
		    System.out.println("KP : Creating Java MSSQL statement...");
		    Statement stmt = conn.createStatement();

		    //String sql = "SELECT * FROM All_Users";
		    String sql = "SELECT Top 10 * FROM Person.Person";
		    //USERNAME, USER_ID, CREATED, COMMON, ORACLE_MAINTAINED, INHERITED, DEFAULT_COLLATION, IMPLICIT, ALL_SHARD
   		    
		    
		    int colIndex = 1;
		    ResultSet rs = stmt.executeQuery(sql);
		    //Extract data from result set
		    while(rs.next()){
			       //Retrieve by column name
			       String businessEntityID = rs.getString("BusinessEntityID");
			       String personType = rs.getString("PersonType");       
			       String nameStyle = rs.getString("NameStyle");
			       String title = rs.getString("Title");
			       String firstName = rs.getString("FirstName");		       
			       String middleName = rs.getString("MiddleName");
			       String lastName = rs.getString("LastName");
			       String suffix = rs.getString("Suffix");		       
			       String emailPromotion = rs.getString("EmailPromotion");
			       String additionalContactInfo = rs.getString("AdditionalContactInfo");
			       String demographics = rs.getString("Demographics");
			       String rowGUID = rs.getString("rowguid");		       
			       String modifiedDate = rs.getString("ModifiedDate");
			         
			       /* KP : System.out Working 
			       //Display values
			       System.out.print("BusinessEntityID: " + businessEntityID);
			       System.out.print(", PersonType: " + personType);
			       System.out.print(", NameStyle: " + nameStyle);
			       System.out.print(", Title: " + title);
			       System.out.println(", FirstName: " + firstName);
			       System.out.print(", MiddleName: " + middleName);
			       System.out.print(", LastName: " + lastName);
			       System.out.print(", Suffix: " + suffix);
			       System.out.print(", EmailPromotion: " + emailPromotion);
			       System.out.print(", AdditionalContactInfo: " + additionalContactInfo);
			       System.out.print(", Demographics: " + demographics);
			       System.out.print(", Rowguid: " + rowGUID);
			       System.out.print(", ModifiedDate: " + modifiedDate);
			       System.out.print("\n");		*/	       
			       		       			     
			       //ResultSet
			       rsString.append("BusinessEntityID: " + businessEntityID)		       		   
			       		   .append(", PersonType: " + personType)
			       		   .append(", NameStyle: " + nameStyle)
			       		   .append(", Title: " + title)
			       		   .append(", FirstName: " + firstName)			       		   
			       		   .append(", MiddleName: " + middleName)
			       		   .append(", LastName: " + lastName)
			       		   .append(", Suffix: " + suffix)
			       		   .append(", EmailPromotion: " + emailPromotion)
			       		   .append(", AdditionalContactInfo: " + additionalContactInfo)			       		   
			       		   .append(", Demographics: " + demographics)
			       		   .append(", rowguid: " + rowGUID)
			       		   .append(", ModifiedDate: " + modifiedDate)
			       		   .append("\n");
			          
			    }
			    rs.close();
		}
		catch(SQLException ex)
		{
			System.out.println("KP : Failed MS SQL Select statement!");
			System.out.println(ex);
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			ex.printStackTrace();
		}
		finally {			
			CloseMSSQLJDBConnection();
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
			CreateMSSQLJDBConnection();
			//System.out.println("KP : Oracle DriverManager.getConnection() Successful!");					
			
		    //Execute a query
		    System.out.println("KP : Creating Java Oracle SQL statement...");
		    Statement stmt = conn.createStatement();

		    
		    //String sql = "SELECT * FROM All_Users;";
		    String sql = "SELECT Top 10 * FROM Person.Person";
		    //USERNAME, USER_ID, CREATED, COMMON, ORACLE_MAINTAINED, INHERITED, DEFAULT_COLLATION, IMPLICIT, ALL_SHARD		    
		    
		    strHTMLTable = "<style>table { font-family: arial, sans-serif;  border-collapse: collapse;  width: 100%;}td," +
		                   "th {  border: 1px solid #dddddd;  text-align: left;  padding: 6px;}tr:nth-child(even)" +
		    		       " {  background-color: #dddddd;}</style>";
		    
		    sbHTMLTable.append(strHTMLTable);
		    
		    strHTMLTable = 	"<table><tr><th>BusinessEntityID</th><th>PersonType</th><th>NameStyle</th>" +  
		    				"<th>Title</th><th>FirstName</th><th>MiddleName</th><th>LastName</th>"+
		    				"<th>Suffix</th><th>EmailPromotion</th><th>AdditionalContactInfo</th>" +
		    				//"<th>Demographics</th>"+
		    				"<th>RowGUID</th><th>ModifiedDate</th></tr>";
		    
		    sbHTMLTable.append(strHTMLTable);
		    		    
		    int colIndex = 1;
		    ResultSet rs = stmt.executeQuery(sql);
		    //Extract data from result set
		    while(rs.next()){
			       //Retrieve by column name
			       String businessEntityID = rs.getString("BusinessEntityID");
			       String personType = rs.getString("PersonType");       
			       String nameStyle = rs.getString("NameStyle");
			       String title = rs.getString("Title");
			       String firstName = rs.getString("FirstName");		       
			       String middleName = rs.getString("MiddleName");
			       String lastName = rs.getString("LastName");
			       String suffix = rs.getString("Suffix");		       
			       String emailPromotion = rs.getString("EmailPromotion");
			       String additionalContactInfo = rs.getString("AdditionalContactInfo");
			       //String demographics = rs.getString("Demographics");
			       String rowGUID = rs.getString("rowguid");		       
			       String modifiedDate = rs.getString("ModifiedDate");
			       
			       /* KP : System.out Working 
			       //Display values
			       System.out.print("BusinessEntityID: " + businessEntityID);
			       System.out.print(", PersonType: " + personType);
			       System.out.print(", NameStyle: " + nameStyle);
			       System.out.print(", Title: " + title);
			       System.out.println(", FirstName: " + firstName);
			       System.out.print(", MiddleName: " + middleName);
			       System.out.print(", LastName: " + lastName);
			       System.out.print(", Suffix: " + suffix);
			       System.out.print(", EmailPromotion: " + emailPromotion);
			       System.out.print(", AdditionalContactInfo: " + additionalContactInfo);
			       //System.out.print(", Demographics: " + demographics);
			       System.out.print(", Rowguid: " + rowGUID);
			       System.out.print(", ModifiedDate: " + modifiedDate);
			       System.out.print("\n");	  */     
			       		       			     
			       //ResultSet
			       rsString.append("BusinessEntityID: " + businessEntityID)		       		   
			       		   .append(", PersonType: " + personType)
			       		   .append(", NameStyle: " + nameStyle)
			       		   .append(", Title: " + title)
			       		   .append(", FirstName: " + firstName)			       		   
			       		   .append(", MiddleName: " + middleName)
			       		   .append(", LastName: " + lastName)
			       		   .append(", Suffix: " + suffix)
			       		   .append(", EmailPromotion: " + emailPromotion)
			       		   .append(", AdditionalContactInfo: " + additionalContactInfo)			       		   
			       		   //.append(", Demographics: " + demographics)
			       		   .append(", rowguid: " + rowGUID)
			       		   .append(", ModifiedDate: " + modifiedDate)
			       		   .append("\n");
			       
			       	//HTML Table	   
			       	sbHTMLTable.append("<tr><td>" + businessEntityID  + "</td>"  )
			       		   .append("<td>" + personType + "</td>"  )
			       		   .append("<td>" + nameStyle + "</td>"  )
			       		   .append("<td>" + title + "</td>"  )
			       		   .append("<td>" + firstName + "</td>"  )
			       		   .append("<td>" + middleName + "</td>"  )                      
			       		   .append("<td>" + lastName + "</td>"  )
			       		   .append("<td>" + suffix + "</td>"  )
			       		   .append("<td>" + emailPromotion + "</td>"  )
			       		   .append("<td>" + additionalContactInfo + "</td>"  )
			       		   //.append("<td>" + demographics + "</td>"  )
			       		   .append("<td>" + rowGUID + "</td>"  )
			       		   .append("<td>" + modifiedDate + "</td>"  )
			       		   .append("</tr>");
			       		   
			       
			       
			    }
			    rs.close();
			    sbHTMLTable.append("</table>");
		}
		catch(SQLException ex)
		{
			System.out.println("KP : Failed MS SQL Select statement!");
			System.out.println(ex);
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			ex.printStackTrace();
		}
		finally {			
			CloseMSSQLJDBConnection();
		}
		
		//return rsString.toString();
		return sbHTMLTable.toString();
	}
	
			
	
	/**
	 * @author Kailash Pasumarthy
	 * OracleJDBConnection Class : Select() 
	 */
	//public void Select() {	
	public ResultSet SelectResultSet() {	
		ResultSet rs = null;
		StringBuilder rsString = new StringBuilder();
		try 
		{	
			//conn =  DriverManager.getConnection(url, connProps);
			CreateMSSQLJDBConnection();
			//System.out.println("KP : Oracle DriverManager.getConnection() Successful!");					
			
		    //Execute a query
		    System.out.println("KP : Creating Java Oracle SQL statement...");
		    Statement stmt = conn.createStatement();

		    //String sql = "SELECT * FROM All_Users";
		    String sql = "SELECT Top 100 * FROM Person.Person";
		    //USERNAME, USER_ID, CREATED, COMMON, ORACLE_MAINTAINED, INHERITED, DEFAULT_COLLATION, IMPLICIT, ALL_SHARD
		    
		    int colIndex = 1;
		    //ResultSet rs = stmt.executeQuery(sql);
		    rs = stmt.executeQuery(sql);
		    //Extract data from result set
		    while(rs.next()){
			       //Retrieve by column name
			       String businessEntityID = rs.getString("BusinessEntityID");
			       String personType = rs.getString("PersonType");       
			       String nameStyle = rs.getString("NameStyle");
			       String title = rs.getString("Title");
			       String firstName = rs.getString("FirstName");		       
			       String middleName = rs.getString("MiddleName");
			       String lastName = rs.getString("LastName");
			       String suffix = rs.getString("Suffix");		       
			       String emailPromotion = rs.getString("EmailPromotion");
			       String additionalContactInfo = rs.getString("AdditionalContactInfo");
			       String demographics = rs.getString("Demographics");
			       String rowGUID = rs.getString("rowguid");		       
			       String modifiedDate = rs.getString("ModifiedDate");

			       /* KP : System.out Working 
			       //Display values
			       System.out.print("BusinessEntityID: " + businessEntityID);
			       System.out.print(", PersonType: " + personType);
			       System.out.print(", NameStyle: " + nameStyle);
			       System.out.print(", Title: " + title);
			       System.out.println(", FirstName: " + firstName);
			       System.out.print(", MiddleName: " + middleName);
			       System.out.print(", LastName: " + lastName);
			       System.out.print(", Suffix: " + suffix);
			       System.out.print(", EmailPromotion: " + emailPromotion);
			       System.out.print(", AdditionalContactInfo: " + additionalContactInfo);
			       System.out.print(", Demographics: " + demographics);
			       System.out.print(", Rowguid: " + rowGUID);
			       System.out.print(", ModifiedDate: " + modifiedDate);
			       System.out.print("\n");		*/	       
			       		       			     
			       //ResultSet
			       rsString.append("BusinessEntityID: " + businessEntityID)		       		   
			       		   .append(", PersonType: " + personType)
			       		   .append(", NameStyle: " + nameStyle)
			       		   .append(", Title: " + title)
			       		   .append(", FirstName: " + firstName)			       		   
			       		   .append(", MiddleName: " + middleName)
			       		   .append(", LastName: " + lastName)
			       		   .append(", Suffix: " + suffix)
			       		   .append(", EmailPromotion: " + emailPromotion)
			       		   .append(", AdditionalContactInfo: " + additionalContactInfo)			       		   
			       		   .append(", Demographics: " + demographics)
			       		   .append(", rowguid: " + rowGUID)
			       		   .append(", ModifiedDate: " + modifiedDate)
			       		   .append("\n");	    
			       }
			    rs.close();
		}
		catch(SQLException ex)
		{
			System.out.println("KP : Failed MS SQL Select statement!");
			System.out.println(ex);
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			ex.printStackTrace();
		}
		finally {			
			CloseMSSQLJDBConnection();
		}
		
		//return rsString.toString();
		return rs;
	}

	
	
/**
	 * @author Kailash Pasumarthy
	 * MSSQLJDBConnection Class : TestMSSQLJDBConnection() : Primitive MSSQLJDBConnection DB Connection 
	 */
	public void TestMSSQLJDBConnection() {
	
		//Create the JDBC Connection
		String url  =  "jdbc:sqlserver://localhost; databaseName=AdventureWorks2017; integratedSecurity=true";
		//String user = "user=admin";
		//String password = "password=Srinidhi2013";
		
		//Retrieving data using SQL Query
		String sql = new String("Select Top 10 * From Person.Person");
		Connection conn = null;
		try 
		{	
			//Register (or) Load MySQL JDBC Drivers
			//Class.forName("oracle.jdbc.driver.oracledriver").newInstance();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			//String connectionUrl = "jdbc:sqlserver://localhost;database=AdventureWorks;integratedSecurity=true;"  
			
			conn =  DriverManager.getConnection(url);
			System.out.println("KP : DriverManager.getConnection()!");	
			Statement st = conn.createStatement();
			System.out.println("KP : Connection.CreateStatement!");	
			boolean bflag = st.execute(sql);
			if(bflag) 
			{
				System.out.println("KP : Successful MSSQL Select statement!");				
			}
			else
			{
				System.out.println("KP : Failed MSSQL Select statement!");
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





