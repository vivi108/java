package practice;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class d {
	public static String SHA256(String str){
		  String SHA = "";
		  try{
		   MessageDigest sh = MessageDigest.getInstance("SHA-256");
		   sh.update(str.getBytes());
		   byte byteData[] = sh.digest();
		   StringBuffer sb = new StringBuffer();
		  for(int i = 0 ; i < byteData.length ; i++){
			   sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
		  }
		  SHA = sb.toString();
			  
		 }catch(NoSuchAlgorithmException e){
		  e.printStackTrace();
		  SHA = null;
			 }
		 return SHA;
		 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a= "1234";
		System.out.println(this.SHA256(a));
	}

}
