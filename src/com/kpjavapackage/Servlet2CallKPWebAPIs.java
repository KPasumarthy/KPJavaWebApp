package com.kpjavapackage;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//KP : Additional Libraries
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.net.HttpURLConnection;
import sun.net.www.protocol.https.*;
import java.security.KeyStore;
import java.security.cert.Certificate;
 
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
	private static String outPrintLn = "KP : KPJavaWebApp Config Code : Entering Config()...\n";
	private static String outFilePath = new String("C:/Users/admin/eclipse-workspace/KPJavaWebApp/src/com/kpjavapackage/KPJavaWebAppDebug.txt");
	private Config config = new Config();
	private MySQLJDBConnection mysqlCon = new MySQLJDBConnection();
	private String kpMVCWebAPIsURL = new String();
	private ImportCACert cacert = null;
	
	
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
			cacert = new ImportCACert();
		
			
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
		
		

		//KP : Print all do Post All Header Names
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
		  String headerName = headerNames.nextElement();
		  System.out.println("KP : Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
		}
		
		//KP : Print all do Post Parameters
		Enumeration<String> params = request.getParameterNames(); 
		while(params.hasMoreElements()){
			 String paramName = params.nextElement();
			 System.out.println("KP : Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
			}
		
		
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
		
		
		//KP : Print all do Post All Header Names
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
		  String headerName = headerNames.nextElement();
		  System.out.println("KP : Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
		}
		
		//KP : Print all do Post Parameters
		Enumeration<String> params = request.getParameterNames(); 
		while(params.hasMoreElements()){
			 String paramName = params.nextElement();
			 System.out.println("KP : Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
			}
		
	}
	
	
	/**
	 * KP : Get KPMVCWebAPIs URL  : "http://kpmvcwebapis.com/api/Persons/2"
	 *   																
	 */
	private String GetKPMVCWebAPIsPerson() throws IOException {
			
		
	
			//KP : Hard-Coded Item URL for Debug Purposes
			//kpMVCWebAPIsURL = "http://kpmvcwebapis.com/api/Persons/27"; 
			//kpMVCWebAPIsURL = "http://www.google.com";
			kpMVCWebAPIsURL  = "https://www.w3schools.com/angular/tryit.asp?filename=try_ng_services";
			//kpMVCWebAPIsURL = "https://kpmvcwebapis.com/api/Persons/27";
			
			//URL url = new URL(kpMVCWebAPIsURL);
			@SuppressWarnings("restriction")
			URL url = new URL(null, kpMVCWebAPIsURL, new sun.net.www.protocol.https.Handler());
		    String result = "";
		    //String response = "";
		    	    			
			//Print Debug to the Console
			outPrintLn = "KP : KPJavaWebApp Servlet Code : Entering GetKPMVCWebAPIsPerson.doGet()...\n";
			System.out.print(outPrintLn);
			System.out.println(outPrintLn);
			
			try {
				
					//Import CA Certificates
					//cacert.LetsImport();
				
			        //String certfile = "yourcert.cer"; /*your cert path*/
			        //java.io.FileInputStream is = new java.io.FileInputStream("yourKeyStore.keystore");
			        String certfile = "C:\\Program Files\\Java\\jdk-13.0.2\\KPSitaRamaCert.cer"; /*your cert path*/
			        //   java.io.FileInputStream is = new java.io.FileInputStream("KPSitaRamaCertKeyStore");
			
			        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
			        //keystore.load(is, "KPSitaRamaCertKeyStore".toCharArray());
			
			        String alias = "KPSitaRamaCert";
			        char[] password = "SitaRama".toCharArray();
			
			        //////
			        CertificateFactory cf = CertificateFactory.getInstance("X.509");
			        InputStream certstream = fullStream (certfile);
			        Certificate certs =  cf.generateCertificate(certstream);
			
			        ///
			        //java.io.File keystoreFile = new java.io.File("yourKeyStorePass.keystore");
			        // Load the keystore contents
			        //java.io.FileInputStream in = new java.io.FileInputStream(keystoreFile);
			        //keystore.load(in, password);
			        //in.close();
			
			        // Add the certificate
			        //keystore.setCertificateEntry(alias, certs);
			
			        // Save the new keystore contents
			        //java.io.FileOutputStream out = new java.io.FileOutputStream(keystoreFile);
			        //keystore.store(out, password);
			        //out.close();
			        
					//Print Debug to the Console
					outPrintLn = "KP : KPJavaWebApp Servlet Code : Entering ImportCACert.LetsImport()...\n";
					System.out.print(outPrintLn);
					System.out.println(outPrintLn);
				
				
				
					//HttpURLConnection con = (HttpURLConnection) url.openConnection();
					//HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
					//SSLContext sc = SSLContext.getInstance("TLSv1.2"); 
					//sc.init(null, null, null);
					//con.setSSLSocketFactory(sc.getSocketFactory());	
					
					HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
					SSLContext sc = SSLContext.getInstance("TLSv1.2"); 
					sc.init(null, null, new java.security.SecureRandom());
					con.setSSLSocketFactory(sc.getSocketFactory());
				
					con.setRequestMethod("GET");
					con.setRequestProperty("Accept", "application/json");
					//con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
					//con.setRequestProperty("User-Agent", "Mozilla /5.0 (Compatible MSIE 9.0;Windows NT 6.1;WOW64; Trident/5.0)");
															
					int responseCode = con.getResponseCode();
					System.out.println(outPrintLn);
					if (responseCode == HttpURLConnection.HTTP_OK) { // success
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
						
					} else {
						outPrintLn = outPrintLn +"KP : Leaving Servlet2CallKPWebAPIs()... \n" + "GetKPMVCWebAPIsPerson NOT WORKING:: " + responseCode + " \n";
						outPrintLn = outPrintLn + result + " \n" ;
						System.out.print(outPrintLn);
						System.out.println(outPrintLn);

					}
			    } 
			catch (Exception e) {
		        e.printStackTrace();
		        
		        outPrintLn = e.getMessage();
		        
				System.out.print(outPrintLn);
				System.out.println(outPrintLn);
				
				return result + "\n" + outPrintLn;
		    }		

			//Write FileOutputStream to Debug File
			//FilesWrite2Append(outPrintLn);
			
			return result;
		}
			
	/**
	 * KP : FullStream to read the cert files
	 *   																
	 */
    private static InputStream fullStream ( String fname ) throws IOException {
    	java.io.FileInputStream fis = new java.io.FileInputStream(fname);
    	java.io.DataInputStream dis = new java.io.DataInputStream(fis);
        byte[] bytes = new byte[dis.available()];
        dis.readFully(bytes);
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        return bais;
    }
	
	/**
	 * KP : Get KPMVCWebAPIs URL  : "http://kpmvcwebapis.com/api/Persons/2"
	 *   																
	 */
	private String GetKPMVCWebAPIsPersonOK() throws IOException {
			
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
