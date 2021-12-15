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
		//서버로 부터 온 response에 대응하는 메시지를 보여줌
		String[] response =str.split(" ");
		if(response[0].equals("100")) //연산자의 개수가 2개이상
			System.out.println("100: opNum is more than 1");
		else if(response[0].equals("200"))//인자의 개수가 많음
			System.out.println("200: : argNum is too many");
		else if(response[0].equals("300"))//인자의 개수가 적음
			System.out.println("300: need more argNum");
		else if(response[0].equals("400"))//0으로 나눠짐
			System.out.println("400: Divided by 0");
		else if(response[0].equals("500"))//연산자가 잘못 작성되었음
			System.out.println("500: OP ERROR");
		else if(response[0].equals("10")) //계산완료
			System.out.println("Answer: "+response[1]);
	}
	public static String changeMsg(String str) {
	// 수학적 string 으로 받은 것을 지정한 protocol에 맞게 순번과 문자를 바꿔주는 함수.
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
		// 1. 파일 위치 설정
        String path = "C:\\\\Users\\\\82108\\\\eclipse-workspace\\\\MyFirstNetWork\\\\src\\\\Socket/input.dat";
        // 2. 스트림 준비(보조)
        FileInputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);
         
        // 3. 읽기 (파일에 있는 타입들을 알아야 하고
        // 입력한 순서대로 불러야 한다.)
        int pnum = dis.readInt();
        // 4. 출력
        System.out.println("portnum : " + pnum);
        
        // 5. 닫기
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
        	//입력한 메시지를 protocol 형식에 맞게 변환한다.
        	outputMessage=changeMsg(outputMessage);
        	
        	//finish라고 작성하면 연결이 종료된다
        	if(outputMessage.equalsIgnoreCase("FINISH")) {
        		outToServer.writeBytes("FINISH");
        		outToServer.flush();
        		break;
        	}
        	//서버로 메시지를 보낸다.
        	outToServer.writeBytes(outputMessage+"\n");
        	outToServer.flush();
        	
        	//서버의 응답받기
        	String response = inFromServer.readLine();
        	response.replace('\n', '\0');
        	checkResponse(response);
        	}

        }
        catch(IOException e){
        	System.out.println(e.getMessage());
        }finally {
        	try {
            	clientSocket.close();//클라이언트 소켓닫기
        	}catch(IOException ex) {
        		System.out.println("서버와의 통신에 문제가 발생함");
        	}
        }

	}

}
