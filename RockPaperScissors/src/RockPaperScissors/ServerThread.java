package RockPaperScissors;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

import RockPaperScissors.HandGameServer;
import RockPaperScissors.ServerThread;


public class ServerThread extends Thread {
	  private Socket st_sock;
	   private DataInputStream st_in;
	   private DataOutputStream st_out;
	   private StringBuffer st_buffer;

	   /* �α׿µ� ����� ���� */
	   private static Hashtable<String,ServerThread> logonHash; 
	   private static Vector<String> logonVector;
	   private static Set<DataOutputStream> ChatHash; // ê
	   
	   /* ���ӹ� ����Ʈ ���� */
	   private static Hashtable<String,ServerThread> playerHash; 
	   private static Vector<String> playerVector;

	   private static int isOpenRoom = 0; // ��ȭ���� �����ȵ�(�ʱⰪ)
	   private HandGameClient st_client;
	   private static final String SEPARATOR = "|"; // �޽����� ������
	   private static final String DELIMETER = "`"; // �Ҹ޽����� ������

	   public String st_ID; 			// ID ����
	   private static String choose1=null;
	   private static String choose2=null;
	   private static ServerThread client1 = null;
	   private static ServerThread client2 = null;
	   private static int chooseInt1=0;
	   private static int chooseInt2=0;
	   private PlayGame gameroom;

	   // Ŭ���̾�Ʈ�κ��� ���޵Ǵ� �޽��� �ڵ�
	   private static final int REQ_LOGON = 1001;
	   private static final int REQ_SENDWORDS = 1021;
	   private static final int REQ_LOGOUT = 1031;
	   private static final int REQ_GETRESULT = 1042;
	   private static final int REQ_QUITROOM = 1041;
	   private static final int REQ_SENDMESSAGE = 1045;
	   private static final int REQ_PLAYGAME = 1055;
	   private static final int REQ_CHAT = 1056; //ê
 
	   
	   // Ŭ���̾�Ʈ�� �����ϴ� �޽��� �ڵ�
	   private static final int YES_LOGON = 2001;
	   private static final int NO_LOGON = 2002;
	   private static final int MDY_PLAYMEMBER = 2013;
	   private static final int MDY_PLAYERS = 2005;
	   private static final int YES_QUITROOM = 2042;
	   private static final int YES_LOGOUT = 2031;
	   private static final int NO_LOGOUT = 2032;
	   private static final int YES_GETRESULT = 2041;
	   private static final int MDY_MEMVER = 2004;
	   private static final int NO_PLAYGAME = 2014;
	   private static final int YES_PLAYGAME = 2018;
	   private static final int SEND_MSG = 2021; // ê
	   
	   
	   // ���� �޽��� �ڵ�
	   private static final int MSG_ALREADYUSER = 3001;
	   private static final int MSG_SERVERFULL = 3002;
	   private static final int MSG_CANNOTOPEN = 3011;
	   private static final int ERR_NOUSER = 2015;
	   private static final int ERR_REJECITON = 2019;
	   private static final int ERR_ALREADYPLAYER = 2033;

	   //���� ����
	   //�̰����� ������ ���޹ޱ�
	   private static final int WIN=1111;
		private static final int LOSE=1110;
	   
	   static{	
		      logonHash = new Hashtable<String,ServerThread>(HandGameServer.maxclient);
		      logonVector = new Vector<String>(HandGameServer.maxclient); 
		      playerHash = new Hashtable<String,ServerThread>(HandGameServer.maxclient);
		      playerVector = new Vector<String>(HandGameServer.maxclient);

			  ChatHash = new HashSet<>();
		   }
	
	public ServerThread(Socket sock){
		
	      try{
	         st_sock = sock; //������ �� Ŭ���̾�Ʈ�� ���� ����	        
	         st_in = new DataInputStream(sock.getInputStream()); 
	         st_out = new DataOutputStream(sock.getOutputStream());
	         st_buffer = new StringBuffer(2048);
	         
	      }catch(IOException e){
	         System.out.println(e);
	      }
	   }

	   ///
	connectingDB update = new connectingDB();
	   ///
	   //����� �������� Ŭ���̾�Ʈ ������
	   public void run(){
		   try{
		         while(true){
		            String recvData = st_in.readUTF();
		            StringTokenizer st = new StringTokenizer(recvData, SEPARATOR);
		            int command = Integer.parseInt(st.nextToken());
		            switch(command){

						//ê
						case REQ_CHAT:{
							String msg = st_ID +" : " + st.nextToken(); //�޼��� ������ �ް�

							for (DataOutputStream writer : ChatHash) {
								writer.writeUTF(SEND_MSG + SEPARATOR + msg);
								writer.flush();
							}
							break;
						}

		               // �α׿� �õ� �޽��� PACKET : REQ_LOGON|ID
		               case REQ_LOGON:{
		                  int result;
		                  String id = st.nextToken(); // Ŭ���̾�Ʈ�� ID�� ��´�.
		                  result = addUser(id, this, st_out);
		                  st_buffer.setLength(0);
		                  if(result ==0){  // ������ ����� ����	                	 
		                     st_buffer.append(YES_LOGON);                      					
		                     st_buffer.append(SEPARATOR);
		                     st_buffer.append(SEPARATOR);
		                     String userIDs = getUsers(); //�α��� ���� �����ID�� ���Ѵ�
		                     st_buffer.append(userIDs);
		                     send(st_buffer.toString());
		                     
		                     st_buffer.setLength(0);   //��� Ŭ���̾�Ʈ�� �α׿� ����� ����
		                     st_buffer.append(MDY_MEMVER);
		                     st_buffer.append(SEPARATOR);
		                     st_buffer.append(userIDs);    
		                     broadcast_log(st_buffer.toString());
		                     
		                     
		                     String playerIDs = getPlayers();
		                     if(!playerIDs.equals("")) {
		                    	 st_buffer.setLength(0);   //��� Ŭ���̾�Ʈ�� ���������� label ����
		                    	 st_buffer.append(MDY_PLAYERS);
		                    	 st_buffer.append(SEPARATOR);
		                    	 st_buffer.append(playerIDs);    
		                    	 broadcast_log(st_buffer.toString());
		                     }
		                     
		                     
		                  }else{  // ���ӺҰ� ����
		                     st_buffer.append(NO_LOGON);  // NO_LOGON|errCode
		                     st_buffer.append(SEPARATOR);
		                     st_buffer.append(result); // ���ӺҰ� �����ڵ� ����
		                     send(st_buffer.toString());
		                  }
		                  break;
		               }
		               case REQ_LOGOUT:{
		            	   st_buffer.setLength(0);
		                   String id = st.nextToken(); // �׷��� �������� ID�� ��´�.
		            	   
		                   logonVector.removeElement(id);  // ����� ID ����
		                   logonHash.remove(id, this); //����� ID �� Ŭ���̾�Ʈ�� �����  ������ ����

		                   st_buffer.append(YES_LOGOUT); 
		                   send(st_buffer.toString()); // YES_ENTERROOM ��Ŷ�� �����Ѵ�.

		                   
		                   st_buffer.setLength(0);
		                   st_buffer.append(MDY_MEMVER);
		                   st_buffer.append(SEPARATOR);
		                   String userIDs = getUsers(); // ��ȭ�� ���� ����� ID�� ���Ѵ�
		                   st_buffer.append(userIDs);
		                   broadcast_log(st_buffer.toString()); // �α��� ����� ���� label����
		                  
		                  break;
		               }
		               //���� ��û
		               case REQ_PLAYGAME :{
		            	   String id = st.nextToken();
		            	   String idTo = st.nextToken();
		            	   
		            	   ServerThread client = null;
		            	   ServerThread client_p = null;
		            	   
		            	   //������ ��û���� ����ڸ� hash�� �̾Ƴ� ��û �޼��� ������
		            	   if((client = (ServerThread) logonHash.get(idTo))!=null){
		            		   //���� ���ӹ濡 �ִ� ����� �϶�
		            		   if((client_p = (ServerThread) playerHash.get(idTo))!=null){
		            			   st_buffer.setLength(0);
			            		   st_buffer.append(NO_PLAYGAME);
			            		   st_buffer.append(SEPARATOR);
			            		   st_buffer.append(ERR_ALREADYPLAYER);
			            		   st_buffer.append(SEPARATOR);
			            		   st_buffer.append(idTo);
			            		   send(st_buffer.toString()); 
			            		   break;     
		            		   }
		            		   st_buffer.setLength(0);
		            		   st_buffer.append(REQ_PLAYGAME);
		            		   st_buffer.append(SEPARATOR);
		            		   st_buffer.append(id);
		            		   st_buffer.append(SEPARATOR);
		            		   st_buffer.append(idTo);
		            		   client.send(st_buffer.toString()); 
		            		   break;
		            	   }
		            	   else { //����ڸ� �������� �ʾ�����
		            		   st_buffer.setLength(0);
		            		   st_buffer.append(NO_PLAYGAME);
		            		   st_buffer.append(SEPARATOR);
		            		   st_buffer.append(ERR_NOUSER);
		            		   st_buffer.append(idTo);
		            		   send(st_buffer.toString()); 
		            		   break;   
		            	   }
		            	      
		               }
		               //������ ������ �Ͽ� ������ �����Ѵ�.
		               case YES_PLAYGAME :{
		            	   String id = st.nextToken();
		            	   String idTo = st.nextToken();
		            	   
		            	   playerVector.addElement(id);  //�����ڵ� ���Ϳ� �ؽ����̺� �߰�
		                   playerHash.put(id, this); 
		                   playerVector.addElement(idTo);  
		                   playerHash.put(idTo, this); 
		                   	
		                   //��û�� ���̵𿡰� ������ ������ �����Ͽ��ٰ� �˷���.
		            	   ServerThread client = null;
		            	   client = (ServerThread) logonHash.get(id);
		            	   st_buffer.setLength(0);
		        		   st_buffer.append(YES_PLAYGAME);
		        		   st_buffer.append(SEPARATOR);
		        		   st_buffer.append(idTo);	        		   
		        		   client.send(st_buffer.toString()); 
		        		   
		        		   String playerIDs = getPlayers(); //���������ڸ�� ����
		        		   st_buffer.setLength(0);
		        		   st_buffer.append(MDY_PLAYERS);
		        		   st_buffer.append(SEPARATOR);
		        		   st_buffer.append(playerIDs);		
		        		   broadcast_log(st_buffer.toString()); 
		        		    
		        		   break;
		 
		               }
		               
		               //������ ������ �ź��Ѵ�.
		               case NO_PLAYGAME :{
		            	   String id = st.nextToken();
		            	   ServerThread client = null;
		            	   client = (ServerThread) logonHash.get(id);
		            	   st_buffer.setLength(0);
		        		   st_buffer.append(NO_PLAYGAME);
		        		   st_buffer.append(SEPARATOR);
		        		   st_buffer.append(ERR_REJECITON);
		        		   st_buffer.append(SEPARATOR);
		        		   st_buffer.append(id);

		        		   client.send(st_buffer.toString()); 
		        		   break;
		 
		               }
		               
		               //���� ��� ����ϱ�
		               case REQ_GETRESULT:{
		            	   
		            	   String id = st.nextToken();
		            	   st_buffer.setLength(0);
		                   st_buffer.append(YES_GETRESULT);
		                   st_buffer.append(SEPARATOR);
		                   
		                   if(client1 == null) {  //������1 hashtable���� ã��
		            		   client1 = (ServerThread) logonHash.get(id);
		            	   }
		            	   else{  //������2 hashtable���� ã��
		            		   client2 = (ServerThread) logonHash.get(id);
		            	   }
		            	   
		            	   if(choose1 == null) {  //������1�� ��ư���
		            		    choose1 = st.nextToken();
		            		    chooseInt1 = Integer.parseInt(choose1);
		            		    
		            	   }
		            	   else{				//������1�� ��ư���
		            		    choose2 = st.nextToken();
		            		    chooseInt2 = Integer.parseInt(choose2);
		            	   }
		            	   
		            	   if(choose1!=null&&choose2!=null) {  //�� ��ư�� ��� �������� ��� ����ϱ�
		            		   switch(chooseInt1) {
		            		   case 0 :   //����
		            			   if(chooseInt2 == 0) {
		            				   st_buffer.append("������� ���ӿ��� �����ϴ�!");
		            				   client1.send(st_buffer.toString()); 
		            				   client2.send(st_buffer.toString());
		            				   
		            				   choose1 = choose2 = null;
		            				   client1 = client2 = null;
		            				   break;
		            			  ////////////////////////////////////////////////////////////////////////////////////
		            			   }else if(chooseInt2 == 1) {  
		            				   st_buffer.append("������� ���ӿ��� �����ϴ�.");

									   st_buffer.append(SEPARATOR);
									   st_buffer.append(LOSE);


									   client1.send(st_buffer.toString());
		            				   System.out.println(st_buffer.toString()+"\n");
		            				   st_buffer.delete( st_buffer.length()-21, st_buffer.length()-1);

		            				   st_buffer.append("������� ���ӿ��� �̰���ϴ�.");

									   st_buffer.append(SEPARATOR);
									   st_buffer.append(WIN);


									   client2.send(st_buffer.toString());
		            				   
		            				   choose1 = choose2 = null;
		            				   client1 = client2 = null;
		            				   break;
		            			   
		            			   }else if(chooseInt2 == 2) {
		            				   st_buffer.append("������� ���ӿ��� �̰���ϴ�.");

									   st_buffer.append(SEPARATOR);
									   st_buffer.append(WIN);

									   client1.send(st_buffer.toString());
		            				   st_buffer.delete( st_buffer.length()-22, st_buffer.length()-1);

		            				   st_buffer.append("������� ���ӿ��� �����ϴ�.");
									   st_buffer.append(SEPARATOR);
									   st_buffer.append(LOSE);

									   client2.send(st_buffer.toString());
		            				   
		            				   choose1 = choose2 = null;
		            				   client1 = client2 = null;
		            				   break;
		            			   
		            			   }
		            			 
		            		   case 1 :  //����
		            		   
		            			   if(chooseInt2 == 0) {
		            				   st_buffer.append("������� ���ӿ��� �̰���ϴ�.");

									   st_buffer.append(SEPARATOR);
									   st_buffer.append(WIN);


									   client1.send(st_buffer.toString());
		            				   st_buffer.delete( st_buffer.length()-22, st_buffer.length()-1);

		            				   st_buffer.append("������� ���ӿ��� �����ϴ�.");

									   st_buffer.append(SEPARATOR);
									   st_buffer.append(LOSE);


									   client2.send(st_buffer.toString());
		            				   
		            				   choose1 = choose2 = null;
		            				   client1 = client2 = null;
		            				   break;
		            			  
		            			   }else if(chooseInt2 == 1) {
		            				   st_buffer.append("������� ���ӿ��� �����ϴ�!");
		            				   client1.send(st_buffer.toString());
		            				   client2.send(st_buffer.toString());
		            				   
		            				   choose1 = choose2 = null;
		            				   client1 = client2 = null;
		            				   break;
		            			  
		            			   }else if(chooseInt2 == 2) {
		            				   st_buffer.append("������� ���ӿ��� �����ϴ�.");

									   st_buffer.append(SEPARATOR);
									   st_buffer.append(LOSE);

									   client1.send(st_buffer.toString());
		            				   
		            				   st_buffer.delete( st_buffer.length()-21, st_buffer.length()-1);
		            				   st_buffer.append("������� ���ӿ��� �̰���ϴ�.");

									   st_buffer.append(SEPARATOR);
									   st_buffer.append(WIN);

									   client2.send(st_buffer.toString());

		            				   choose1 = choose2 = null;
		            				   client1 = client2 = null;
		            				   break;
		            			   
		            			   }
		            		   case 2 :  //��
		            		   
		            			   if(chooseInt2 == 0) {
		            				   st_buffer.append("������� ���ӿ��� �����ϴ�.");

									   st_buffer.append(SEPARATOR);
									   st_buffer.append(LOSE);

									   client1.send(st_buffer.toString());
		            				   st_buffer.delete( st_buffer.length()-21, st_buffer.length()-1);
		            				   st_buffer.append("������� ���ӿ��� �̰���ϴ�.");

									   st_buffer.append(SEPARATOR);
									   st_buffer.append(WIN);

									   client2.send(st_buffer.toString());
		            				   
		            				   choose1 = choose2 = null;
		            				   client1 = client2 = null;
		            				   break;
		            			  
		            			   }else if(chooseInt2 == 1) {
		            				   st_buffer.append("������� ���ӿ��� �̰���ϴ�.");

									   st_buffer.append(SEPARATOR);
									   st_buffer.append(WIN);

									   client1.send(st_buffer.toString());
		            				   st_buffer.delete( st_buffer.length()-22, st_buffer.length()-1);
		            				   st_buffer.append("������� ���ӿ��� �����ϴ�.");

									   st_buffer.append(SEPARATOR);
									   st_buffer.append(LOSE);

									   client2.send(st_buffer.toString());
		            				   
		            				   choose1 = choose2 = null;
		            				   client1 = client2 = null;
		            				   break;
		            			   
		            			   }else if(chooseInt2 == 2) {
		            				   st_buffer.append("������� ���ӿ��� �����ϴ�!");
		            				   client1.send(st_buffer.toString());
		            				   client2.send(st_buffer.toString()); 
		            				   
		            				   choose1 = choose2 = null;
		            				   client1 = client2 = null;
		            				   break;
		            			   }
		            		 

		            		   }
		            	   }
		            	   break; 
 	   
		               }
		               //���ӹ��� ������
		               case REQ_QUITROOM:{
		            	   st_buffer.setLength(0);
		                   String id = st.nextToken();  
		                  
		            	   playerVector.removeElement(id); //���������� ����Ʈ���� ���� 
		                   playerHash.remove(id, this); 

		                   st_buffer.append(YES_QUITROOM); 
		                   send(st_buffer.toString()); 
		                   String PlayerIDs = getPlayers();
 
		                   st_buffer.setLength(0);
		                   st_buffer.append(MDY_PLAYERS);
		                   st_buffer.append(SEPARATOR);  
		                   //PlayerIDs�� null���ܸ� ��������
		                   if(PlayerIDs.equals("")) PlayerIDs = "������ ����";
		                   st_buffer.append(PlayerIDs);
		                   broadcast_log(st_buffer.toString());
		                   break;
		               }
		               
		            } // switch ����

		            Thread.sleep(100);
		         } //while ����

		      }catch(NullPointerException e){ // �α׾ƿ��� st_in�� �� ���ܸ� �߻��ϹǷ�
		      }catch(InterruptedException e){
		      }catch(IOException e){
		      }
  }
	   

	   private static synchronized int addUser(String id, ServerThread client, DataOutputStream st_out){
		      if(checkUserID(id) != null){
		         return MSG_ALREADYUSER;
		      }  
		      if(logonHash.size() >= HandGameServer.maxclient){
		         return MSG_SERVERFULL;
		      }
		      logonVector.addElement(id);  // ����� ID �߰�
		      logonHash.put(id, client); // ����� ID �� Ŭ���̾�Ʈ�� ����� �����带 �����Ѵ�.
		      ChatHash.add(st_out); // ê
		      client.st_ID = id;
		      return 0; // Ŭ���̾�Ʈ�� ���������� �����ϰ�, ��ȭ���� �̹� ������ ����.
		   }

		   /*ID �ߺ� Ȯ��
		           ��ȯ���� null�̶�� �䱸�� ID�� ���ӹ� ������ ������. */
		   private static ServerThread checkUserID(String id){
		      ServerThread alreadyClient = null;
		      alreadyClient = (ServerThread) logonHash.get(id);
		      return alreadyClient;
		   }
		   
		   // �α׿¿� ������ ����� ID�� ���Ѵ�.
		   private String getUsers(){
		      StringBuffer id = new StringBuffer();
		      String ids;
		      Enumeration<String> enu = logonVector.elements();
		      while(enu.hasMoreElements()){
		         id.append(enu.nextElement());
		         id.append(DELIMETER); 
		      }
		      try{
		         ids = new String(id);  // ���ڿ��� ��ȯ�Ѵ�.
		         ids = ids.substring(0, ids.length()-1); // ������ "`"�� �����Ѵ�.
		      }catch(StringIndexOutOfBoundsException e){
		         return "";
		      }
		      return ids;
		   }

		   // ���ӹ濡 ������ ����� ID�� ���Ѵ�.
		   private String getPlayers(){
		      StringBuffer id = new StringBuffer();
		      String ids;
		      Enumeration<String> enu = playerVector.elements();
		      while(enu.hasMoreElements()){
		         id.append(enu.nextElement());
		         id.append(DELIMETER); 
		      }
		      try{
		         ids = new String(id);
		         ids = ids.substring(0, ids.length()-1); // ������ "`"�� �����Ѵ�.
		      }catch(StringIndexOutOfBoundsException e){
		         return "";
		      }
		      return ids;
		   }
		   //�α����� ����ڵ鿡�� (��ε��ɽ���) �����͸� �����Ѵ�.
		   public synchronized void broadcast_log(String sendData) throws IOException{
			   ServerThread client;
			      Enumeration<String> enu = logonVector.elements();
			      while(enu.hasMoreElements()){	  
			         client = (ServerThread) logonHash.get(enu.nextElement());
			         client.send(sendData);
			      }
		   }
		   
		   // ���ӹ濡 ������ ��� �����(��ε��ɽ���)���� �����͸� �����Ѵ�.
		   public synchronized void broadcast(String sendData) throws IOException{
		      ServerThread client;
		      Enumeration<String> enu = playerVector.elements();
		      while(enu.hasMoreElements()){	  
		         client = (ServerThread) playerHash.get(enu.nextElement());
		         client.send(sendData);
		      }
		   }

		   // �����͸� �����Ѵ�.
		   public void send(String sendData) throws IOException{
		      synchronized(st_out){
		         st_out.writeUTF(sendData);
		         st_out.flush();
		      }
		   }
}
