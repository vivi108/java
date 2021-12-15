package Socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Cal_Client {
	public static void checkResponse(String str) {
		//������ ���� �� response�� �����ϴ� �޽����� ������
		String[] response =str.split(" ");
		if(response[0].equals("100")) //�������� ������ 2���̻�
			System.out.println("100: opNum is more than 1");
		else if(response[0].equals("200"))//������ ������ ����
			System.out.println("200: : argNum is too many");
		else if(response[0].equals("300"))//������ ������ ����
			System.out.println("300: need more argNum");
		else if(response[0].equals("400"))//0���� ������
			System.out.println("400: Divided by 0");
		else if(response[0].equals("500"))//�����ڰ� �߸� �ۼ��Ǿ���
			System.out.println("500: OP ERROR");
		else if(response[0].equals("10")) //���Ϸ�
			System.out.println("Answer: "+response[1]);
	}
	public static String changeMsg(String str) {
	// ������ string ���� ���� ���� ������ protocol�� �°� ������ ���ڸ� �ٲ��ִ� �Լ�.
		String forReturn="";
		String[] splitted= str.split(" ");
		if(splitted[0].equalsIgnoreCase("FINISH")) return str;
		for(int i=0; i<splitted.length; i++) {
			if(splitted[i].equals("+")) splitted[i]="ADD";
			if(splitted[i].equals("-")) splitted[i]="SUB";
			if(splitted[i].equals("/")) splitted[i]="DIV";
			if(splitted[i].equals("*")) splitted[i]="MUL";
		}
		
		forReturn=splitted[1];
		for(int i=0; i<splitted.length; i++) {
			if(i==1) continue;
		
			forReturn =forReturn.concat(" "+splitted[i]);
		}
		
		return forReturn;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// 1. ���� ��ġ ����
        String path = "C:\\\\Users\\\\82108\\\\eclipse-workspace\\\\MyFirstNetWork\\\\src\\\\Socket/input.dat";
        // 2. ��Ʈ�� �غ�(����)
        FileInputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);
         
        // 3. �б� (���Ͽ� �ִ� Ÿ�Ե��� �˾ƾ� �ϰ�
        // �Է��� ������� �ҷ��� �Ѵ�.)
        int pnum = dis.readInt();
        // 4. ���
        System.out.println("portnum : " + pnum);
        
        // 5. �ݱ�
        dis.close();
        bis.close();
        fis.close();
        
        
        String serverIP = "127.0.0.1";
        Socket clientSocket=null;
        DataOutputStream outToServer;
        BufferedReader inFromUser;
        BufferedReader inFromServer;
        try {
        	
        	clientSocket = new Socket(serverIP, pnum);
        	inFromUser = new BufferedReader(new InputStreamReader(System.in));
        	outToServer =new DataOutputStream(clientSocket.getOutputStream());
     		inFromServer =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
     		String outputMessage;
        while(true) {
        	System.out.print("request msg: ");
        	outputMessage=inFromUser.readLine();
        	//�Է��� �޽����� protocol ���Ŀ� �°� ��ȯ�Ѵ�.
        	outputMessage=changeMsg(outputMessage);
        	
        	//finish��� �ۼ��ϸ� ������ ����ȴ�
        	if(outputMessage.equalsIgnoreCase("FINISH")) {
        		outToServer.writeBytes("FINISH");
        		outToServer.flush();
        		break;
        	}
        	//������ �޽����� ������.
        	outToServer.writeBytes(outputMessage+"\n");
        	outToServer.flush();
        	
        	//������ ����ޱ�
        	String response = inFromServer.readLine();
        	response.replace('\n', '\0');
        	checkResponse(response);
        	}

        }
        catch(IOException e){
        	System.out.println(e.getMessage());
        }finally {
        	try {
            	clientSocket.close();//Ŭ���̾�Ʈ ���ϴݱ�
        	}catch(IOException ex) {
        		System.out.println("�������� ��ſ� ������ �߻���");
        	}
        }

	}

}
