package com.java.networking;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String ipAddress = "localhost";
		int port = 9909;
		
		Socket clientSocket = new Socket(ipAddress, port);
		
		OutputStreamWriter os  =  new OutputStreamWriter(clientSocket.getOutputStream());
		PrintWriter ps = new PrintWriter(os);
		os.write("Siva reddy vundela\n");
		os.close();
		//clientSocket.close();

	}

}
