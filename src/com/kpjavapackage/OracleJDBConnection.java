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

public class OracleJDBConnection {

	//KP : Class Level Variables
	//private static String url  = "jdbc:mysql://localhost/";
	//private static String user = "svcaccount";				///"user";
	//private static String password = "(svcP@33word)";	///"password";
	private static String url  = "jdbc:oracle:thin:@//localhost/orcl";
	//private static String database = "world";
	private static String user = "sys as sysdba";				///"user";
	private static String password = "Sita2008";	///"password";
		
	
	private static Connection conn = null;
	private static Properties connProps = new Properties();
    
	
	/**
	 * OracleJDBConnection() Class Constructor
	 */
	public OracleJDBConnection() {
		// TODO Auto-generated constructor stub
		//CreateOracleJDBConnection();
	}
	
	/**
	 * @author Kailash Pasumarthy
	 * OracleJDBConnection Class : CreateOracleJDBConnection();
	 */
	public void CreateOracleJDBConnection() {	
		try 
		{	
			//Register (or) Load MySQL JDBC Drivers
			//DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			
			//Connection Properties
			//connProps.put("database", database);
			connProps.put("user", user);
			connProps.put("password", password);
			
			//MySQL DriverManager getConnection()
			conn =  DriverManager.getConnection(url, connProps);
			System.out.println("KP : Oracle DriverManager.getConnection() Successful!");				
		}
		catch(SQLException ex)
		{
			System.out.println("KP : Oracle DriverManager.getConnection() Failed!");				
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
	 * OracleJDBConnection Class : CloseOracleJDBConnection();
	 */
	public void CloseOracleJDBConnection() {	
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
				System.out.println("KP : Oracle Connection Closed Successfully!");	
			}
		}
		catch(SQLException ex)
		{
			System.out.println("KP :  Oracle Connection Close Failed!");				
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
	 * OracleJDBConnection Class : Select() 
	 */
	//public void Select() {	
	public String Select() {	
		StringBuilder rsString = new StringBuilder();
		try 
		{	
			//conn =  DriverManager.getConnection(url, connProps);
			CreateOracleJDBConnection();
			//System.out.println("KP : Oracle DriverManager.getConnection() Successful!");					
			
		    //Execute a query
		    System.out.println("KP : Creating Java Oracle SQL statement...");
		    Statement stmt = conn.createStatement();

		    //String sql = "SELECT * FROM All_Users";
		    String sql = "SELECT * FROM All_Users";
		    //USERNAME, USER_ID, CREATED, COMMON, ORACLE_MAINTAINED, INHERITED, DEFAULT_COLLATION, IMPLICIT, ALL_SHARD
	    		    
		    
		    int colIndex = 1;
		    ResultSet rs = stmt.executeQuery(sql);
		    //Extract data from result set
		    while(rs.next()){
			       //Retrieve by column name
			       String userName = rs.getString("USERNAME");
			       String userId = rs.getString("USER_ID");       
			       String created = rs.getString("CREATED");
			       String common = rs.getString("COMMON");
			       String oraMaintained = rs.getString("ORACLE_MAINTAINED");		       
			       String inherited = rs.getString("INHERITED");
			       String collation = rs.getString("DEFAULT_COLLATION");
			       String implicit = rs.getString("IMPLICIT");		       
			       String shard = rs.getString("ALL_SHARD");

			       //Display values
			       System.out.print("ID: " + userId);
			       System.out.print(", UserName: " + userName);
			       System.out.print(", Created: " + created);
			       System.out.print(", Common: " + common);
			       System.out.println(", OracleMaintained: " + oraMaintained);
			       System.out.print(", Inherited: " + inherited);
			       System.out.print(", Collation: " + collation);
			       System.out.print(", Implicit: " + implicit);
			       System.out.print(", Shard: " + shard);
			       System.out.print("\n");
			       
			       //ResultSet
			       rsString.append("ID: " + userId)		       		   
			       		   .append(", UserName: " + userName)
			       		   .append(", Created: " + created)
			       		   .append(", Common: " + common)
			       		   .append(", OracleMaintained: " + oraMaintained)			       		   
			       		   .append(", Inherited: " + inherited)
			       		   .append(", Collation: " + collation)
			       		   .append(", Implicit: " + implicit)
			       		   .append(", Shard: " + shard)
			       		   .append("\n");
			          
			    }
			    rs.close();
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
			CloseOracleJDBConnection();
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
			CreateOracleJDBConnection();
			//System.out.println("KP : Oracle DriverManager.getConnection() Successful!");					
			
		    //Execute a query
		    System.out.println("KP : Creating Java Oracle SQL statement...");
		    Statement stmt = conn.createStatement();

		    //String sql = "SELECT * FROM All_Users;";
		    String sql = "SELECT * FROM All_Users";
		    //USERNAME, USER_ID, CREATED, COMMON, ORACLE_MAINTAINED, INHERITED, DEFAULT_COLLATION, IMPLICIT, ALL_SHARD		    
		    
		    strHTMLTable = "<style>table { font-family: arial, sans-serif;  border-collapse: collapse;  width: 100%;}td," +
		                   "th {  border: 1px solid #dddddd;  text-align: left;  padding: 8px;}tr:nth-child(even)" +
		    		       " {  background-color: #dddddd;}</style>";
		    
		    sbHTMLTable.append(strHTMLTable);
		    
		    strHTMLTable = 	"<table><tr><th>ID</th><th>UserName</th><th>Created</th>" +  
		    				"<th>Common</th><th>OracleMaintained</th><th>Inherited</th>"+
		    				"<th>Collation</th><th>Implicit</th><th>Shard</th></tr>";
		    
		    sbHTMLTable.append(strHTMLTable);
		    
		    int colIndex = 1;
		    ResultSet rs = stmt.executeQuery(sql);
		    //Extract data from result set
		    while(rs.next()){
			       //Retrieve by column name
			       String userName = rs.getString("USERNAME");
			       String userId = rs.getString("USER_ID");       
			       String created = rs.getString("CREATED");
			       String common = rs.getString("COMMON");
			       String oraMaintained = rs.getString("ORACLE_MAINTAINED");		       
			       String inherited = rs.getString("INHERITED");
			       String collation = rs.getString("DEFAULT_COLLATION");
			       String implicit = rs.getString("IMPLICIT");		       
			       String shard = rs.getString("ALL_SHARD");

			       //Display values
			       System.out.print("ID: " + userId);
			       System.out.print(", UserName: " + userName);
			       System.out.print(", Common: " + common);
			       System.out.println(", OracleMaintained: " + oraMaintained);
			       System.out.print(", Inherited: " + inherited);
			       System.out.print(", Collation: " + collation);
			       System.out.print(", Implicit: " + implicit);
			       System.out.print(", Shard: " + shard );
			       System.out.print("\n");
			       
			       //ResultSet
			       rsString.append("ID: " + userId)		       		   
			       		   .append(", UserName: " + userName)
			       		   .append(", Created: " + created)
			       		   .append(", Common: " + common)
			       		   .append(", OracleMaintained: " + oraMaintained)			       		   
			       		   .append(", Inherited: " + inherited)
			       		   .append(", Collation: " + collation)
			       		   .append(", Implicit: " + implicit)
			       		   .append(", Shard: " + shard)
			       		   .append("\n");
			          			          			          
			       	//HTML Table	   
			       	sbHTMLTable.append("<tr><td>" + userId  + "</td>"  )
			       		   .append("<td>" + userName + "</td>"  )
			       		   .append("<td>" + created + "</td>"  )
			       		   .append("<td>" + common + "</td>"  )
			       		   .append("<td>" + oraMaintained + "</td>"  )
			       		   .append("<td>" + inherited + "</td>"  )                      
			       		   .append("<td>" + collation + "</td>"  )
			       		   .append("<td>" + implicit + "</td>"  )
			       		   .append("<td>" + shard + "</td>"  )
			       		   .append("</tr>");
			       		   
			       		   
			       		   
			       		   
			    }
			    rs.close();
			    sbHTMLTable.append("</table>");
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
			CloseOracleJDBConnection();
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
			CreateOracleJDBConnection();
			//System.out.println("KP : Oracle DriverManager.getConnection() Successful!");					
			
		    //Execute a query
		    System.out.println("KP : Creating Java Oracle SQL statement...");
		    Statement stmt = conn.createStatement();

		    //String sql = "SELECT * FROM All_Users";
		    String sql = "SELECT * FROM All_Users";
		    //USERNAME, USER_ID, CREATED, COMMON, ORACLE_MAINTAINED, INHERITED, DEFAULT_COLLATION, IMPLICIT, ALL_SHARD
		    
		    int colIndex = 1;
		    //ResultSet rs = stmt.executeQuery(sql);
		    rs = stmt.executeQuery(sql);
		    //Extract data from result set
		    while(rs.next()){
			       //Retrieve by column name
			       String userName = rs.getString("USERNAME");
			       String userId = rs.getString("USER_ID");       
			       String created = rs.getString("CREATED");
			       String common = rs.getString("COMMON");
			       String oraMaintained = rs.getString("ORACLE_MAINTAINED");		       
			       String inherited = rs.getString("INHERITED");
			       String collation = rs.getString("DEFAULT_COLLATION");
			       String implicit = rs.getString("IMPLICIT");		       
			       String shard = rs.getString("ALL_SHARD");

			       //Display values
			       System.out.print("ID: " + userId);
			       System.out.print(", UserName: " + userName);
			       System.out.print(", Created: " + created);
			       System.out.print(", Common: " + common);
			       System.out.println(", OracleMaintained: " + oraMaintained);
			       System.out.print(", Inherited: " + inherited);
			       System.out.print(", Collation: " + collation);
			       System.out.print(", Implicit: " + implicit);
			       System.out.print(", Shard: " + shard);
			       
			       //ResultSet
			       rsString.append("ID: " + userId)		       		   
			       		   .append(", UserName: " + userName)
			       		   .append(", Created: " + created)
			       		   .append(", Common: " + common)
			       		   .append(", OracleMaintained: " + oraMaintained)			       		   
			       		   .append(", Inherited: " + inherited)
			       		   .append(", Collation: " + collation)
			       		   .append(", Implicit: " + implicit)
			       		   .append(", Shard: " + shard)
			       		   .append("\n");			    
			       }
			    rs.close();
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
			CloseOracleJDBConnection();
		}
		
		//return rsString.toString();
		return rs;
	}

	
	/**
	 * @author Kailash Pasumarthy
	 * OracleJDBConnection Class : Select() 
	 */
	//public void Select() {	
	public List<OracleUser> SelectListAllUsers() {	
		ResultSet rs = null;
		List<OracleUser> allUsers = new ArrayList<OracleUser>();
		StringBuilder rsString = new StringBuilder();
		try 
		{	
			//conn =  DriverManager.getConnection(url, connProps);
			CreateOracleJDBConnection();
			//System.out.println("KP : Oracle DriverManager.getConnection() Successful!");					
			
		    //Execute a query
		    System.out.println("KP : Creating Java Oracle SQL statement...");
		    Statement stmt = conn.createStatement();

		    //String sql = "SELECT * FROM All_Users;";
		    String sql = "SELECT * FROM All_Users";
		    //USERNAME, USER_ID, CREATED, COMMON, ORACLE_MAINTAINED, INHERITED, DEFAULT_COLLATION, IMPLICIT, ALL_SHARD		    		    

		    //ResultSet rs = stmt.executeQuery(sql);
		    rs = stmt.executeQuery(sql);
		    //Extract data from result set    	
			    while(rs.next()){
				       //Retrieve by column name
				       String userName = rs.getString("USERNAME");
				       String userId = rs.getString("USER_ID");       
				       String created = rs.getString("CREATED");
				       String common = rs.getString("COMMON");
				       String oraMaintained = rs.getString("ORACLE_MAINTAINED");		       
				       String inherited = rs.getString("INHERITED");
				       String collation = rs.getString("DEFAULT_COLLATION");
				       String implicit = rs.getString("IMPLICIT");		       
				       String shard = rs.getString("ALL_SHARD");

				       //Display values
				       System.out.print("ID: " + userId);
				       System.out.print(", UserName: " + userName);
				       System.out.print(", Created: " + created);
				       System.out.print(", Common: " + common);
				       System.out.println(", OracleMaintained: " + oraMaintained);
				       System.out.print(", Inherited: " + inherited);
				       System.out.print(", Collation: " + collation);
				       System.out.print(", Implicit: " + implicit);
				       System.out.print(", Shard: " + shard);
				       System.out.print("\n");
				       
				       //ResultSet
				       rsString.append("ID: " + userId)		       		   
				       		   .append(", UserName: " + userName)
				       		   .append(", Created: " + created)
				       		   .append(", Common: " + common)
				       		   .append(", OracleMaintained: " + oraMaintained)			       		   
				       		   .append(", Inherited: " + inherited)
				       		   .append(", Collation: " + collation)
				       		   .append(", Implicit: " + implicit)
				       		   .append(", Shard: " + shard)
				       		   .append("\n");				   
			    	//OracleUser
			    	OracleUser user = new OracleUser();
			    	user.userId = userId;
			    	user.userName = userName;
			    	user.created = created;
			    	user.oraMaintained = oraMaintained;
			    	user.inherited = inherited;
			    	user.common = common;	
			    	user.collation = collation;
			    	user.implicit = implicit;
			    	user.shard = shard;		       		    	  			    	
			    	
			    	allUsers.add(user);			       
			       
			    }
			    rs.close();
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
			CloseOracleJDBConnection();
		}
				
		//return rsString.toString();
		return allUsers;
	}

	
	/**
	 * @author Kailash Pasumarthy
	 * OracleJDBConnection Class : Select() 
	 */
	//public void Select() {	
	//public List<ETSUser> SelectETSUsers() {	
	public ArrayList<OracleUser> SelectAllUsers() {	
		ResultSet rs = null;
		ArrayList<OracleUser> allUsers = new ArrayList<OracleUser>();
		StringBuilder rsString = new StringBuilder();		
		try 
		{	
			//conn =  DriverManager.getConnection(url, connProps);
			CreateOracleJDBConnection();
			//System.out.println("KP : Oracle DriverManager.getConnection() Successful!");					
			
		    //Execute a query
		    System.out.println("KP : Creating Java Oracle SQL statement...");
		    Statement stmt = conn.createStatement();

		    //String sql = "SELECT * FROM All_Users;";
		    String sql = "SELECT * FROM All_Users;";
		    //USERNAME, USER_ID, CREATED, COMMON, ORACLE_MAINTAINED, INHERITED, DEFAULT_COLLATION, IMPLICIT, ALL_SHARD		    		    

		    //ResultSet rs = stmt.executeQuery(sql);
		    rs = stmt.executeQuery(sql);
		    //Extract data from result set    	
			    while(rs.next()){
				       //Retrieve by column name
				       String userName = rs.getString("USERNAME");
				       String userId = rs.getString("USER_ID");       
				       String created = rs.getString("CREATED");
				       String common = rs.getString("COMMON");
				       String oraMaintained = rs.getString("ORACLE_MAINTAINED");		       
				       String inherited = rs.getString("INHERITED");
				       String collation = rs.getString("DEFAULT_COLLATION");
				       String implicit = rs.getString("IMPLICIT");		       
				       String shard = rs.getString("ALL_SHARD");

				       //Display values
				       System.out.print("ID: " + userId);
				       System.out.print(", UserName: " + userName);
				       System.out.print(", Created: " + created);
				       System.out.print(", Common: " + common);
				       System.out.println(", OracleMaintained: " + oraMaintained);
				       System.out.print(", Inherited: " + inherited);
				       System.out.print(", Collation: " + collation);
				       System.out.print(", Implicit: " + implicit);
				       System.out.print(", Shard: " + shard);
				       System.out.print("\n");
				       
				       //ResultSet
				       rsString.append("ID: " + userId)		       		   
				       		   .append(", UserName: " + userName)
				       		   .append(", Created: " + created)
				       		   .append(", Common: " + common)
				       		   .append(", OracleMaintained: " + oraMaintained)			       		   
				       		   .append(", Inherited: " + inherited)
				       		   .append(", Collation: " + collation)
				       		   .append(", Implicit: " + implicit)
				       		   .append(", Shard: " + shard)
				       		   .append("\n");
				       
			    	//OracleUser
			    	OracleUser user = new OracleUser();
			    	user.userId = userId;
			    	user.userName = userName;
			    	user.created = created;
			    	user.oraMaintained = oraMaintained;
			    	user.inherited = inherited;
			    	user.common = common;	
			    	user.collation = collation;
			    	user.implicit = implicit;
			    	user.shard = shard;		       		    	  			    	
			    	
			    	allUsers.add(user);			       
			       
			    }
			    rs.close();
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
			CloseOracleJDBConnection();
		}
				
		//return rsString.toString();
		return allUsers;
	}	

	
	/**
	 * @author Kailash Pasumarthy
	 * OracleJDBConnection Class : Update() 
	 */
	//public void Update(String nbkId) {
	public String Update() {
	//public ResultSet Update() {
		StringBuilder rsString = new StringBuilder();
		ResultSet rs = null;
		try 
		{	
			//conn =  DriverManager.getConnection(url, connProps);
			CreateOracleJDBConnection();
			//System.out.println("KP : Oracle DriverManager.getConnection() Successful!");					
			
		    //Execute a query
		    System.out.println("KP : Creating Java Oracle SQL statement...");
		    Statement stmt = conn.createStatement();		
		    
		    //String sql = "SELECT * FROM All_Users";
		    String sql = "SELECT * FROM All_Users";
		    //USERNAME, USER_ID, CREATED, COMMON, ORACLE_MAINTAINED, INHERITED, DEFAULT_COLLATION, IMPLICIT, ALL_SHARD
		    
		    //ResultSet rs = stmt.executeQuery(sql);
		    rs = stmt.executeQuery(sql);
		    //Extract data from result set		    
		    while(rs.next()){
			       //Retrieve by column name
			       String userName = rs.getString("USERNAME");
			       String userId = rs.getString("USER_ID");       
			       String created = rs.getString("CREATED");
			       String common = rs.getString("COMMON");
			       String oraMaintained = rs.getString("ORACLE_MAINTAINED");		       
			       String inherited = rs.getString("INHERITED");
			       String collation = rs.getString("DEFAULT_COLLATION");
			       String implicit = rs.getString("IMPLICIT");		       
			       String shard = rs.getString("ALL_SHARD");

			       //Display values
			       System.out.print("ID: " + userId);
			       System.out.print(", UserName: " + userName);
			       System.out.print(", Created: " + created);
			       System.out.print(", Common: " + common);
			       System.out.println(", OracleMaintained: " + oraMaintained);
			       System.out.print(", Inherited: " + inherited);
			       System.out.print(", Collation: " + collation);
			       System.out.print(", Implicit: " + implicit);
			       System.out.print(", Shard: " + shard);
			       
			       //ResultSet
			       rsString.append("ID: " + userId)		       		   
			       		   .append(", UserName: " + userName)
			       		   .append(", Created: " + created)
			       		   .append(", Common: " + common)
			       		   .append(", OracleMaintained: " + oraMaintained)			       		   
			       		   .append(", Inherited: " + inherited)
			       		   .append(", Collation: " + collation)
			       		   .append(", Implicit: " + implicit)
			       		   .append(", Shard: " + shard)
			       		   .append("\n");			    
			       }
			    rs.close();
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
			CloseOracleJDBConnection();
		}
		
		return rsString.toString();
		//return rs;
	}
	
/**
	 * @author Kailash Pasumarthy
	 * OracleJDBConnection Class : TestOracleJDBConnection() : Primitive OracleJDBConnection DB Connection 
	 */
	public void TestOracleJDBConnection() {
	
		//Create the JDBC Connection
		String url  = "jdbc:oracle:thin:@//localhost/orcl";	//KP : World DB exists on MySQL
		String user = "user=sys as sysdba";
		String password = "password=Sita2008";
		
		//Retrieving data using SQL Query
		String sql = new String("select * From v$database");
		Connection conn = null;
		try 
		{	
			//Register (or) Load MySQL JDBC Drivers
			Class.forName("oracle.jdbc.driver.oracledriver").newInstance();
			
			conn =  DriverManager.getConnection(url + user + "&" + password);
			System.out.println("KP : DriverManager.getConnection()!");	
			Statement st = conn.createStatement();
			System.out.println("KP : Connection.CreateStatement!");	
			boolean bflag = st.execute(sql);
			if(bflag) 
			{
				System.out.println("KP : Successful Oracle Select statement!");				
			}
			else
			{
				System.out.println("KP : Failed Oracle Select statement!");
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





