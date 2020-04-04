package com.kpjavapackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//KP : Additional Libraries
import java.net.URL;
 

/**
 * @author  Kailash Pasumarthy
 * 			KP : Servlet implementation class Servlet2CallKPWebAPIs
 */
@WebServlet(description = "Servlet Calls : Local KP Web APIs hosted on IIS Server", 
			asyncSupported = true,
			urlPatterns = { "/Servlet2CallKPWebAPIs" })
public class Servlet2CallKPWebAPIs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//KP : Debug Print on Console & Output File
	private String outPrintLn = "KP : KPJavaWebApp Config Code : Entering Config()...\n";
	private String outFilePath = new String("C:/Users/admin/eclipse-workspace/KPJavaWebApp/src/com/kpjavapackage/KPJavaWebAppDebug.txt");
	private Config config = new Config();
	private MySQLJDBConnection mysqlCon = new MySQLJDBConnection();
	
	
    /**
     * Default constructor. 
     */
    public Servlet2CallKPWebAPIs() {
        // TODO Auto-generated constructor stub		
		String outPrintLn = "";
		outPrintLn = "KP : KPJavaWebApp Servlet Code : Entering Servlet2CallKPWebAPIs()...\n";
		System.out.println(outPrintLn);
		//System.out.print(outPrintLn);
		try {
			config.FilesBufferWrite2Append();
			//mysqlCon.TestMySQLJDBConnection();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		////KP : Servlet URL : http://localhost/KPJavaWebApp/index.html
		PrintWriter out = response.getWriter();
		String outPrintLn = "";
		outPrintLn = "KP : KPJavaWebApp Servlet Code : Entering Servlet2CallKPWebAPIs.doGet()...\n";
		System.out.println(outPrintLn);
		//System.out.print(outPrintLn);
		//mysqlCon.TestMySQLJDBConnection();
		//mysqlCon.Select();
		String rsString = mysqlCon.SelectWorldCities();
		
		////KP : Append the HttpServletResponse response
		//response.getWriter().append("Served at: ").append(request.getContextPath()).append("\n" + outPrintLn);
		response.getWriter().append("KP : Served at: ").append(request.getContextPath()).append("\n" + outPrintLn).append("\n" + rsString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		////KP : Servlet URL : http://localhost/KPJavaWebApp/index.html
		PrintWriter out = response.getWriter();
		String outPrintLn = "";
		outPrintLn = "KP : KPJavaWebApp Servlet Code : Entering Servlet2CallKPWebAPIs.doPost()...\n";
		System.out.println(outPrintLn);
		System.out.print(outPrintLn);
		
	}


	/*
	protected void justConnect(javax.servlet.http.HttpServletResponse
			response) throws java.io.IOException
			{
			response.setContentType("text/plain");
			javax.servlet.ServletOutputStream out = response.getOutputStream();

			System.out.println("Creating https connection ...");
			com.ibm.net.ssl.internal.www.protocol.https.HttpsURLConnection urlc
			= null;
			java.io.BufferedReader reader = null;

			try
			{
			java.net.URL url = new java.net.URL(urlString);

			Object obj = url.openConnection();
			System.out.println("Object created:" + obj.toString());
			urlc =
			(com.ibm.net.ssl.internal.www.protocol.https.HttpsURLConnection) obj;

			System.out.println("Https connection created.");

			out.println("THE HEADERS");
			out.println("-----------");

			reader = new java.io.BufferedReader(new
			java.io.InputStreamReader(urlc.getInputStream()));

			String line;
			out.println("THE CONTENT");
			out.println("-----------");

			while((line = reader.readLine()) != null)
			out.println(line);

			}
			catch(ClassCastException ce)
			{
			ce.printStackTrace(System.out);
			}
			catch(Exception e)
			{
			System.getProperties();
			System.out.println("Java classpath: " +
			System.getProperty("java.class.path"));
			System.out.println("Java home: " + System.getProperty("java.home"));
			e.printStackTrace(System.out);
			}
			finally
			{
			try
			{
			if(reader != null)
			reader.close();
			}
			catch(java.io.IOException ioe){}
			}
			}

			}
	 */


}
