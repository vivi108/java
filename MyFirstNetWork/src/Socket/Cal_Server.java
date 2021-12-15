package Socket;
import java.io.*;
import java.net.*;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.nio.ByteOrder;


public class Cal_Server {
	public static boolean isStringDouble(String s) {//숫자인지 여부를 알려줌
	    try {
	    	Double.parseDouble(s);
	        return true;

	    } catch (NumberFormatException e) {
	        return false;
	    }
	  }
	public static String response(String str) {//response semantic 작성
		
		String[] clientInput = str.split(" ");
		//finsish라는 문자가 들어오면 그대로 반환
		if(clientInput[0].equalsIgnoreCase("FINISH")) {
			return "FINISH";
		}
		
		int op=0, arg=0;//연산자의 개수, 인자의 개수
		double result=0;
		for(int i=0; i<clientInput.length; i++) {
			if(isStringDouble(clientInput[i])) arg++;//인자 개수 구하기
			else op++;//연산자 개수 구하기
		}
		
		if(op>1) return "100";//연산자가 2개 이상
		else if(arg>2) return "200";//인자의 개수가 많음
		else if(arg<2) return "300";//인자의 개수가 적음
		//0으로 나눠짐
		else if(clientInput[0].equalsIgnoreCase("DIV")&& Integer.parseInt(clientInput[2])==0) return "400";
		//연산자가 잘못 작성되었음
		else if(isStringDouble(clientInput[0])|| (!clientInput[0].equalsIgnoreCase("ADD")&&!clientInput[0].equalsIgnoreCase("DIV")&&!clientInput[0].equalsIgnoreCase("MUL")&&!clientInput[0].equalsIgnoreCase("SUB"))) return "500";
		else {//계산완료
			if (clientInput[0].equalsIgnoreCase("ADD")) result=Double.parseDouble(clientInput[1])+Double.parseDouble(clientInput[2]);
			else if(clientInput[0].equalsIgnoreCase("SUB")) result=Double.parseDouble(clientInput[1])-Double.parseDouble(clientInput[2]);
			else if(clientInput[0].equalsIgnoreCase("DIV")) result=Double.parseDouble(clientInput[1])/Double.parseDouble(clientInput[2]);
			else if(clientInput[0].equalsIgnoreCase("MUL")) result=Double.parseDouble(clientInput[1])*Double.parseDouble(clientInput[2]);
			return "10 ".concat(String.valueOf(result));
		}
		
	}
	public static void main(String[] args) throws Exception{
		 // 자료형을 유지해서 파일에 쓰기
        // 1. 파일 위치 설정
        String path = "C:\\Users\\82108\\eclipse-workspace\\MyFirstNetWork\\src\\Socket/input.dat";
        // 2. 스트림 준비(보조)
        FileOutputStream fos = new FileOutputStream(path);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);
         
        // 3. 쓰기
       int portnum =6789;
       dos.writeInt(portnum);
       dos.close();
	    bos.close();
	    fos.close();
       //서버소켓 생성
       ServerSocket listenSocket = new ServerSocket(portnum);
       
       String clientSentence;
       BufferedReader in= null;
       BufferedWriter out=null;
       Socket socket=null;
       try {
    	 //클라이언트로부터 접속 기다림
    	   socket =listenSocket.accept();
    	   System.out.println("newly connected..\n");
    	   //네트워크 입출력 스트림 생성
    	   in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
    	   out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    	   
    	   while(true) {
    		   clientSentence = in.readLine();//클라이언트의 요청읽기
    		   clientSentence.replace('\n', '\0');
    		   //protocol형식으로 response작성
    		   String Response =response(clientSentence);
    		   if(Response.equalsIgnoreCase("FINISH")) break; //요청이 없으면 멈춤
    		   out.write(Response+"\n");
    		   out.flush();
    	   }
       }catch(IOException e) {
    	   System.out.println(e.getMessage());
    	
       }finally {
    	   try {
       		socket.close();//클라이언트 소켓닫기
       		listenSocket.close();//서버소켓 닫기
       		
       	}catch(IOException ex) {
       		System.out.println("클라이언트와의 통신에 문제가 발생함");
       	}
       }
	}

}
