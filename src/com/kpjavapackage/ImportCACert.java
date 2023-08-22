package com.kpjavapackage;

import java.security.KeyStore;
import java.security.cert.Certificate;

import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import java.security.spec.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ImportCACert {
	
	//KP : Debug Print on Console & Output File
	private static String outPrintLn = "KP : KPJavaWebApp Config Code : Entering Config()...\n";
	//private static String outFilePath = new String("C:/Users/admin/eclipse-workspace/KPJavaWebApp/src/com/kpjavapackage/KPJavaWebAppDebug.txt");
	private static String outFilePath = new String("~/src/com/kpjavapackage/KPJavaWebAppDebug.txt");
	

    ////public static void main(String[] argv) throws Exception {
	public void LetsImport () throws Exception  {
    	
    	try {
	        //String certfile = "yourcert.cer"; /*your cert path*/
	        //java.io.FileInputStream is = new java.io.FileInputStream("yourKeyStore.keystore");
	        //String certfile = "C:\\Program Files\\Java\\jdk-13.0.2\\KPSitaRamaCert.cer"; /*your cert path*/
    		String certfile = "~/src/com/kpjavapackage/KPSitaRamaCert.cer"; /*your cert path*/
	        //java.io.FileInputStream is = new java.io.FileInputStream("KPSitaRamaCertKeyStore");
	
	        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
	        //keystore.load(is, "".toCharArray());
	
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
	        keystore.setCertificateEntry(alias, certs);
	
	        // Save the new keystore contents
	        //java.io.FileOutputStream out = new java.io.FileOutputStream(keystoreFile);
	        //keystore.store(out, password);
	        //out.close();
	        
			//Print Debug to the Console
			outPrintLn = "KP : KPJavaWebApp Servlet Code : Entering ImportCACert.LetsImport()...\n";
			System.out.print(outPrintLn);
			System.out.println(outPrintLn);
    	}
		catch(Exception ex)
		{
			System.out.println(ex);
			
	        ex.printStackTrace();
	        outPrintLn = ex.getMessage();	        
			System.out.print(outPrintLn);
			System.out.println(outPrintLn);
		}
    }

    private static InputStream fullStream ( String fname ) throws IOException {
    	java.io.FileInputStream fis = new java.io.FileInputStream(fname);
    	java.io.DataInputStream dis = new java.io.DataInputStream(fis);
        byte[] bytes = new byte[dis.available()];
        dis.readFully(bytes);
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        return bais;
    }
}
