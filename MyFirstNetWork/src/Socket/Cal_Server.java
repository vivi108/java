package Socket;
import java.io.*;
import java.net.*;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.nio.ByteOrder;


public class Cal_Server {
	public static boolean isStringDouble(String s) {//�������� ���θ� �˷���
	    try {
	    	Double.parseDouble(s);
	        return true;

	    } catch (NumberFormatException e) {
	        return false;
	    }
	  }
	public static String response(String str) {//response semantic �ۼ�
		
		String[] clientInput = str.split(" ");
		//finsish��� ���ڰ� ������ �״�� ��ȯ
		if(clientInput[0].equalsIgnoreCase("FINISH")) {
			return "FINISH";
		}
		
		int op=0, arg=0;//�������� ����, ������ ����
		double result=0;
		for(int i=0; i<clientInput.length; i++) {
			if(isStringDouble(clientInput[i])) arg++;//���� ���� ���ϱ�
			else op++;//������ ���� ���ϱ�
		}
		
		if(op>1) return "100";//�����ڰ� 2�� �̻�
		else if(arg>2) return "200";//������ ������ ����
		else if(arg<2) return "300";//������ ������ ����
		//0���� ������
		else if(clientInput[0].equalsIgnoreCase("DIV")&& Integer.parseInt(clientInput[2])==0) return "400";
		//�����ڰ� �߸� �ۼ��Ǿ���
		else if(isStringDouble(clientInput[0])|| (!clientInput[0].equalsIgnoreCase("ADD")&&!clientInput[0].equalsIgnoreCase("DIV")&&!clientInput[0].equalsIgnoreCase("MUL")&&!clientInput[0].equalsIgnoreCase("SUB"))) return "500";
		else {//���Ϸ�
			if (clientInput[0].equalsIgnoreCase("ADD")) result=Double.parseDouble(clientInput[1])+Double.parseDouble(clientInput[2]);
			else if(clientInput[0].equalsIgnoreCase("SUB")) result=Double.parseDouble(clientInput[1])-Double.parseDouble(clientInput[2]);
			else if(clientInput[0].equalsIgnoreCase("DIV")) result=Double.parseDouble(clientInput[1])/Double.parseDouble(clientInput[2]);
			else if(clientInput[0].equalsIgnoreCase("MUL")) result=Double.parseDouble(clientInput[1])*Double.parseDouble(clientInput[2]);
			return "10 ".concat(String.valueOf(result));
		}
		
	}
	public static void main(String[] args) throws Exception{
		 // �ڷ����� �����ؼ� ���Ͽ� ����
        // 1. ���� ��ġ ����
        String path = "C:\\Users\\82108\\eclipse-workspace\\MyFirstNetWork\\src\\Socket/input.dat";
        // 2. ��Ʈ�� �غ�(����)
        FileOutputStream fos = new FileOutputStream(path);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);
         
        // 3. ����
       int portnum =6789;
       dos.writeInt(portnum);
       dos.close();
	    bos.close();
	    fos.close();
       //�������� ����
       ServerSocket listenSocket = new ServerSocket(portnum);
       
       String clientSentence;
       BufferedReader in= null;
       BufferedWriter out=null;
       Socket socket=null;
       try {
    	 //Ŭ���̾�Ʈ�κ��� ���� ��ٸ�
    	   socket =listenSocket.accept();
    	   System.out.println("newly connected..\n");
    	   //��Ʈ��ũ ����� ��Ʈ�� ����
    	   in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
    	   out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    	   
    	   while(true) {
    		   clientSentence = in.readLine();//Ŭ���̾�Ʈ�� ��û�б�
    		   clientSentence.replace('\n', '\0');
    		   //protocol�������� response�ۼ�
    		   String Response =response(clientSentence);
    		   if(Response.equalsIgnoreCase("FINISH")) break; //��û�� ������ ����
    		   out.write(Response+"\n");
    		   out.flush();
    	   }
       }catch(IOException e) {
    	   System.out.println(e.getMessage());
    	
       }finally {
    	   try {
       		socket.close();//Ŭ���̾�Ʈ ���ϴݱ�
       		listenSocket.close();//�������� �ݱ�
       		
       	}catch(IOException ex) {
       		System.out.println("Ŭ���̾�Ʈ���� ��ſ� ������ �߻���");
       	}
       }
	}

}
