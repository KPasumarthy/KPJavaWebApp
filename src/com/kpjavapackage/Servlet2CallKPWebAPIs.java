package com.kpjavapackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.HttpURLConnection;
//KP : Additional Libraries
import java.net.URL;
 
//KP : Google JSON - gson Libraries
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


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
	private String kpMVCWebAPIsURL = new String();
	
	
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
		//mysqlCon.TestMySQLJDBConnection();				//KP : WORKING
		//mysqlCon.Select();								//KP : WORKING
		//String rsString = mysqlCon.SelectWorldCities();	//KP : WORKING
		String rsString = GetKPMVCWebAPIsPerson();
		
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

	
	/**
	 * KP : Get KPMVCWebAPIs URL  : "http://kpmvcwebapis.com/api/Persons/2"
	 *   																
	 */
	private String GetKPMVCWebAPIsPerson() throws IOException {
			
			//KP : Hard-Coded Item URL for Debug Purposes
			kpMVCWebAPIsURL = "http://kpmvcwebapis.com/api/Persons/27"; 
			
			URL url = new URL(kpMVCWebAPIsURL);
		    String result = "";
		    //String response = "";
			
			//Print Debug to the Console
			outPrintLn = "KP : KPJavaWebApp Servlet Code : Entering GetKPMVCWebAPIsPerson.doGet()...\n";
			System.out.print(outPrintLn);
			System.out.println(outPrintLn);
			
			try {
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setRequestMethod("GET");
					con.setRequestProperty("Accept", "text/html, application/xhtml+xml, application/xml; q=0.9, */*; q=0.8");
					con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
					con.setRequestProperty("User-Agent", "Mozilla /5.0 (Compatible MSIE 9.0;Windows NT 6.1;WOW64; Trident/5.0)");
					
					int responseCode = con.getResponseCode();
					System.out.println(outPrintLn);
					//if (responseCode == HttpURLConnection.HTTP_OK) { // success
						BufferedReader in = new BufferedReader(new InputStreamReader(
								con.getInputStream()));
						String inputLine;
						StringBuffer response = new StringBuffer();
			
						while ((inputLine = in.readLine()) != null) {
							response.append(inputLine);
						}
						in.close();
			
						// print result
						System.out.println(response.toString());
						result = response.toString();
						outPrintLn =  outPrintLn + "\n GetKPMVCWebAPIsPerson : \n" + result;		
						System.out.print(outPrintLn);
						System.out.println(outPrintLn);
						
					//} else {
						outPrintLn = outPrintLn +"KP : Leaving Servlet2CallKPWebAPIs()... \n" + "GetKPMVCWebAPIsPerson NOT WORKING:: " + responseCode + " \n";
						outPrintLn = outPrintLn + result + " \n" ;
						System.out.print(outPrintLn);
						System.out.println(outPrintLn);

					//}
			    } 
			catch (Exception e) {
		        e.printStackTrace();
		        
		        outPrintLn = e.getMessage();
				System.out.print(outPrintLn);
				System.out.println(outPrintLn);
		    }		

			//Write FileOutputStream to Debug File
			//FilesWrite2Append(outPrintLn);
			
			return result;
		}
		
	
	/**
	 * KP : GetKPMVCWebAPIsPersonOnHTTP() KPMVCWebAPIs URL  : "http://kpmvcwebapis.com/api/Persons/2" : KP ; WORKING
	 *   																
	 */
	private String GetKPMVCWebAPIsPersonOnHTTP() throws IOException {
			
			//KP : Hard-Coded Item URL for Debug Purposes
			kpMVCWebAPIsURL = "http://kpmvcwebapis.com/api/Persons/27"; 
			
			URL url = new URL(kpMVCWebAPIsURL);
		    String result = "";
		    //String response = "";
			
			//Print Debug to the Console
			outPrintLn = "KP : KPJavaWebApp Servlet Code : Entering GetKPMVCWebAPIsPerson.doGet()...\n";
			System.out.print(outPrintLn);
			System.out.println(outPrintLn);
			
			try {
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setRequestMethod("GET");
					con.setRequestProperty("Accept", "text/html, application/xhtml+xml, application/xml; q=0.9, */*; q=0.8");
					con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
					con.setRequestProperty("User-Agent", "Mozilla /5.0 (Compatible MSIE 9.0;Windows NT 6.1;WOW64; Trident/5.0)");
					
					int responseCode = con.getResponseCode();
					System.out.println(outPrintLn);
					//if (responseCode == HttpURLConnection.HTTP_OK) { // success
						BufferedReader in = new BufferedReader(new InputStreamReader(
								con.getInputStream()));
						String inputLine;
						StringBuffer response = new StringBuffer();
			
						while ((inputLine = in.readLine()) != null) {
							response.append(inputLine);
						}
						in.close();
			
						// print result
						System.out.println(response.toString());
						result = response.toString();
						outPrintLn =  outPrintLn + "\n GetKPMVCWebAPIsPerson : \n" + result;		
						System.out.print(outPrintLn);
						System.out.println(outPrintLn);
						
					//} else {
						outPrintLn = outPrintLn +"KP : Leaving Servlet2CallKPWebAPIs()... \n" + "GetKPMVCWebAPIsPerson NOT WORKING:: " + responseCode + " \n";
						outPrintLn = outPrintLn + result + " \n" ;
						System.out.print(outPrintLn);
						System.out.println(outPrintLn);

					//}
			    } 
			catch (Exception e) {
		        e.printStackTrace();
		        
		        outPrintLn = e.getMessage();
				System.out.print(outPrintLn);
				System.out.println(outPrintLn);
		    }		

			//Write FileOutputStream to Debug File
			//FilesWrite2Append(outPrintLn);
			
			return result;
		}
		
	
	

}
