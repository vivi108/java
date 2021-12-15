package Socket;
import java.io.*;
import java.net.*;
public class TCPserver {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		ServerSocket welcomeSocket;
		String clientSentence;
		String capitalizedSentence;
		int nPort;
		nPort = 9999;
		welcomeSocket = new ServerSocket(nPort);
		System.out.println("Server start.. (port#=" + nPort + ")\n ");
		while(true) {
		// wait for a new connection on nPort#
		Socket connectionSocket = welcomeSocket.accept();
		
		BufferedReader inFromClient = new BufferedReader(
		new InputStreamReader(connectionSocket.getInputStream()));
		
		DataOutputStream outToClient =
		new DataOutputStream(connectionSocket.getOutputStream());
		
		clientSentence = inFromClient.readLine();
		
		System.out.println("FROM CLIENT: " + clientSentence );
		
		capitalizedSentence = clientSentence.toUpperCase() + '\n';
		
		outToClient.writeBytes(capitalizedSentence);
		}
	}

}
