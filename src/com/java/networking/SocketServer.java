package com.java.networking;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;

public class SocketServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(9909);
		System.out.println("Server started...");
		Socket s = ss.accept();
		
		System.out.println("Client Connected...");
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String data = br.readLine();
		//if( (data = )!=null) {
			System.out.println("Client data: "+data);
		//}
		

	}

}
