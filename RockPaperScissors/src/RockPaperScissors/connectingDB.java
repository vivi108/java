package RockPaperScissors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.swing.*;

public class connectingDB {
	Connection con = null;
	Statement stmt = null;
	String url = "jdbc:mysql://localhost/game";
	String user = "root";
	String passwd = "12345";
	
	connectingDB () {	//Database ��ü ���� �� �����ͺ��̽� ������ �����Ѵ�.
		try {	//�����ͺ��̽� ������ try-catch������ ���ܸ� ����ش�.
			//�����ͺ��̽��� �����Ѵ�.
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			System.out.println("[Server] MySQL ���� ���� ����");	//�����ͺ��̽� ���ῡ �����ϸ� ������ �ַܼ� �˸���.
		} catch(Exception e) {	//�����ͺ��̽� ���ῡ ���ܰ� �߻����� �� ���и� �ַܼ� �˸���.
			System.out.println("[Server] MySQL ���� ���� ����> " + e.toString());
		}
	}


	
	public String loginCheck(String _i, String _p) {
		
		String nickname = "null";	//��ȯ�� �г��� ������ "null"�� �ʱ�ȭ.
		
		//�Ű������� ���� id�� password���� id�� pw���� �ʱ�ȭ�Ѵ�.
		String id = _i;
		String pw =connectingDB.SHA256(_p);;
		
		try {
			//id�� ��ġ�ϴ� ��й�ȣ�� �г����� �ִ��� ��ȸ�Ѵ�.
			String checkingStr = "SELECT password, nickname FROM member WHERE id='" + id + "'";
			ResultSet result = stmt.executeQuery(checkingStr);
			/*
			 * stmt.executeUpdate(String command) 
			 * : command ������ ����� �����ؼ� mysql�� ������ ������Ʈ ���ִ� ������ �Ѵ�. 
			 * rs = stmt.executeQuery(String command) 
			 * : command ������ ����� ������ �� ���� ����� rs�� ��´�.
			 * */
			int count = 0;
			while(result.next()) {
				//��ȸ�� ��й�ȣ�� pw ���� ��.
				if(pw.equals(result.getString("password"))) {	
					//true�� ��� nickname�� ��ȸ�� �г��ӿ� ��ȯ�ϰ� �α��� ������ �ַܼ� �˸���.
					nickname = result.getString("nickname");
					System.out.println("[Server] �α��� ����");
				}
				
				else {	//false�� ��� nickname�� "null"�� �ʱ�ȭ�ϰ� �α��� ���и� �ַܼ� �˸���.
					nickname = "null";
					System.out.println("[Server] �α��� ����");
				}
				count++;
			}
		} catch(Exception e) {	//��ȸ�� �������� �� nickname�� "null"�� �ʱ�ȭ. ���и� �ַܼ� �˸���.
			nickname = "null";
			System.out.println("[Server] �α��� ���� > " + e.toString());
		}
		
		return nickname;	//nickname ��ȯ
	}
	
	//ȸ�������� �����ϴ� �޼ҵ�. ȸ�����Կ� �����ϸ� true, �����ϸ� false�� ��ȯ�Ѵ�.
	public boolean joinCheck(String id, String pw, String name, String nickname, String email, String sns) {
		boolean flag = false;	//�������� ��ȯ�� flag ����. �ʱⰪ�� false
		
		//*****��й�ȣ ��ȣȭ*******************
		String encordPW= connectingDB.SHA256(pw);
		
		//**********************************
		try {
			//member ���̺� �� ���ڿ����� ������� ������Ʈ�ϴ� ����. ��, �д� �ʱⰪ�� ���� 0���� �Ѵ�.
			
			String insertStr = "INSERT INTO member VALUES('" + id + "', '" + encordPW + "', '" + name + "', '" + nickname + "', '" + email + "','" + sns + "', 0, 0, null, 0, null);";
			stmt.executeUpdate(insertStr);
			flag = true;	//������Ʈ���� ���������� ����Ǹ� flag�� true�� �ʱ�ȭ�ϰ� ������ �ַܼ� �˸���.
			System.out.println("[Server] ȸ������ ����");
		} catch(Exception e) {	//ȸ������ ������ �������� ���ϸ� flag�� false�� �ʱ�ȭ�ϰ� ���и� �ַܼ� �˸���.
			flag = false;
			System.out.println("[Server] ȸ������ ���� > " + e.toString());
		}
		
		return flag;	//flag ��ȯ
	}
	
	public boolean getIdByCheck(String id) {
		  
		ResultSet rs;
		boolean result = true;
 
        try {
            String s = "select id from member where id=\""+id+"\";";
           
            rs = stmt.executeQuery(s); //����
            System.out.println(rs);
            if (rs.next()) result = false; //���ڵ尡 �����ϸ� false
 
        } catch (SQLException e) {
            System.out.println(e + "=>  getIdByCheck fail");
        } 
 
        return result;
 
    }
	//�г��� �ߺ�Ȯ��
	public boolean getnnByCheck(String nn) {
		  
		ResultSet rs;
		boolean result = true;
 
        try {
            String s = "select id from member where nickname=\""+nn+"\";";
           
            rs = stmt.executeQuery(s); //����
            System.out.println(rs);
            if (rs.next()) result = false; //���ڵ尡 �����ϸ� false
 
        } catch (SQLException e) {
            System.out.println(e + "=>  getnnByCheck fail");
        } 
 
        return result;
 
    }

	
	
	//�����ͺ��̽��� ����� �ڽ��� ������ ��ȸ�ϴ� �޼ҵ�. ��ȸ�� �������� String ���·� ��ȯ�Ѵ�.
	public String viewInfo(String _nn) {
		String msg = "null";	//��ȯ�� ���ڿ� ������ "null"�� �ʱ�ȭ.
		
		//�Ű������� ���� �г����� nick�� �ʱ�ȭ�Ѵ�.
		String nick = _nn;
		
		try {
			//member ���̺��� nick�̶�� �г����� ���� ȸ���� �̸��� ������ȸ
			String viewStr = "SELECT win, lose FROM member WHERE nickname='" + nick + "'";
			ResultSet result = stmt.executeQuery(viewStr);
			
			while(result.next()) {
				//msg�� "�̸�//�г���//�̸���" ���·� �ʱ�ȭ�Ѵ�.
				msg = nick + "//"+ result.getString("win") + "//" +  result.getString("lose");
				
			}
			System.out.println("[Server] ȸ������ ��ȸ ����");	//���������� ����Ǹ� ������ �ַܼ� �˸���.
		} catch(Exception e) {	//���������� �������� ���ϸ� ���и� �ַܼ� �˸���.
			System.out.println("[Server] ȸ������ ��ȸ ���� > " + e.toString());
		}
		return msg;

	}
	
	//�г��� �޾Ƽ� �¸� Ƚ�� ����
		public void inputwin(String _nn) {
			
			
			//�Ű������� ���� �г����� nick�� �ʱ�ȭ�Ѵ�.
			String nick = _nn;
			
			try {
				//member ���̺��� nick�̶�� �г����� ���� ȸ���� �̸��� �̸��� ������ ��ȸ�Ѵ�.
				String viewwin = "update member set win=win+1 WHERE nickname='" + nick + "'";
				stmt.executeUpdate(viewwin);
				
		
				System.out.println("[Server] ȸ�� �¸�Ƚ�� ���� ����");	//���������� ����Ǹ� ������ �ַܼ� �˸���.
			} catch(Exception e) {	//���������� �������� ���ϸ� ���и� �ַܼ� �˸���.
				System.out.println("[Server] ȸ�� �¸�Ƚ�� ���� ���� > " + e.toString());
			}
			
	
		}
		
		//�г��� �޾Ƽ� �й� Ƚ�� ����
			public void inputlose(String _nn) {
					
					
					//�Ű������� ���� �г����� nick�� �ʱ�ȭ�Ѵ�.
				String nick = _nn;
					
				try {
					//member ���̺��� nick�̶�� �г����� ���� ȸ���� �̸��� �̸��� ������ ��ȸ�Ѵ�.
					String viewwin = "update member set lose=lose+1 WHERE nickname='" + nick + "'";
					stmt.executeUpdate(viewwin);
						
				
					System.out.println("[Server] ȸ�� �й�Ƚ�� ���� ����");	//���������� ����Ǹ� ������ �ַܼ� �˸���.
				} catch(Exception e) {	//���������� �������� ���ϸ� ���и� �ַܼ� �˸���.
					System.out.println("[Server] ȸ�� �й�Ƚ�� ���� ���� > " + e.toString());
				}
			}
			//�α��� Ƚ�� ����
			public void inputLoginNum(String _nn) {
				
				
				//�Ű������� ���� �г����� nick�� �ʱ�ȭ�Ѵ�.
			String nick = _nn;
				
			try {
				//member ���̺��� nick�̶�� �г����� ���� ȸ���� �̸��� �̸��� ������ ��ȸ�Ѵ�.
				String viewwin = "update member set loginnum=loginnum+1 WHERE nickname='" + nick + "'";
				stmt.executeUpdate(viewwin);
					
			
				System.out.println("[Server] ȸ�� �α��� Ƚ�� ���� ����");	//���������� ����Ǹ� ������ �ַܼ� �˸���.
			} catch(Exception e) {	//���������� �������� ���ϸ� ���и� �ַܼ� �˸���.
				System.out.println("[Server] ȸ�� �α��� Ƚ�� ���� ���� > " + e.toString());
			}
		}
			
			//������ �ð� ����
			public void inputLastloginT(String _nn) {
				
				
				//�Ű������� ���� �г����� nick�� �ʱ�ȭ�Ѵ�.
				String nick = _nn;
				
				try {
					//member ���̺��� nick�̶�� �г����� ���� ȸ���� ����ð��� ������Ʈ�Ѵ�
					String updateT = "update member set lastloginT=now() WHERE nickname='" + nick + "'";
					stmt.executeUpdate(updateT);
					
			
					System.out.println("[Server] ȸ�� �α׾ƿ� �ð� ���� ����");	//���������� ����Ǹ� ������ �ַܼ� �˸���.
				} catch(Exception e) {	//���������� �������� ���ϸ� ���и� �ַܼ� �˸���.
					System.out.println("[Server] ȸ�� �α׾ƿ� �ð� ���� ���� > " + e.toString());
				}
				
		
			}
			public void inputlonginIP(String _nn, String ip) {
				
				
				//�Ű������� ���� �г����� nick�� �ʱ�ȭ�Ѵ�.
				String nick = _nn;
				
				try {
					//member ���̺��� nick�̶�� �г����� ���� ȸ���� ����ip�� �����´�.
					String updateT = "update member set loginIP='"+ip+ "'WHERE nickname='" + nick + "'";
					stmt.executeUpdate(updateT);
					
			
					System.out.println("[Server] ȸ�� IP ���� ����");	//���������� ����Ǹ� ������ �ַܼ� �˸���.
				} catch(Exception e) {	//���������� �������� ���ϸ� ���и� �ַܼ� �˸���.
					System.out.println("[Server] ȸ�� IP ���� ���� > " + e.toString());
				}
				
		
			}
				//��й�ȣ�� SHA256�� ����Ͽ� ��ȣȭ �ϴ� �Լ�
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
		
		
		
	}

}
