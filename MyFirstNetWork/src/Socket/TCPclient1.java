package Socket;

import java.io.*;
import java.net.*;
public class TCPclient1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String sentence;
		String modifiedSentence;
		String serverIP = "127.0.0.1";
		int nPort = 9999;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader
		(System.in));
		Socket clientSocket = new Socket(serverIP, nPort);
		
		DataOutputStream outToServer =
		new DataOutputStream(clientSocket.getOutputStream());
		
		BufferedReader inFromServer =
		new BufferedReader(
		new InputStreamReader(clientSocket.getInputStream()));
		
		sentence = inFromUser.readLine();
		
		outToServer.writeBytes(sentence + '\n');
		
		modifiedSentence = inFromServer.readLine();
		
		System.out.println("FROM SERVER: " + modifiedSentence);
		
		clientSocket.close();
	}

}
