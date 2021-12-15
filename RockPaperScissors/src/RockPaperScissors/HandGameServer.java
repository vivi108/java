package RockPaperScissors;

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

import RockPaperScissors.ServerThread;

public class HandGameServer extends Frame implements ActionListener,KeyListener {
	
	public static final int port = 3000;
	public static final int maxclient = 7;

	// Ŭ���̾�Ʈ�κ��� ���ӿ�û�� ��ٸ���, ������ �����Ѵ�.
	   public static void main(String args[]){
	      try{
	    	  
	          ServerSocket theSocket = new ServerSocket(port);
	          while(true){
	              Socket sock = null;
	              ServerThread client = null; //Ŭ���̾�Ʈ�� ����� ��������

				  try{
	                 sock = theSocket.accept(); // Ŭ���̾�Ʈ�� ������ ��ٸ���.
	                 client = new ServerThread(sock);
	                 client.start();
	              }catch(IOException e){
	                 System.out.println(e);
	                 try{
	                    if(sock != null)
	                       sock.close();
	                 }catch(IOException e1){
	                    System.out.println(e);
	                 }finally{
	                    sock = null;
	                 }
	              }
	           }
	        }catch(IOException e){
	           // ������ ���������� �������� �ʴ� ��츦 ó���Ѵ�.
	        }
	     }


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}