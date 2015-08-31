package com.deloitte.innovations.main;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.deloitte.innovations.usermanager.BOEUserManager;

public class Main {

	public static void main(String[] a) throws IOException{
		
		
		BOEUserManager boem=new BOEUserManager();
		boem.createUser();
		
		
		
		/**** SAMPLE PING PROGRAM
		 InetAddress inet;
		 	//10.118.255.228
		   // inet = InetAddress.getByAddress(new byte[] {(byte) 10, (byte)118, (byte) 255, (byte) 228 });
		   
		 inet = InetAddress.getByAddress(new byte[] {(byte) 10, (byte)17, (byte) 206, (byte) 150});
		 System.out.println("Sending Ping Request to " + inet);
		    System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");
		***///
		 
		
		
	}
	
	
	
}
