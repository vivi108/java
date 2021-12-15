package GAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		String url = "jdbc:mysql://localhost/game";
		String user = "root";
		String passwd = "12345";
		
		try {	//�����ͺ��̽� ������ try-catch������ ���ܸ� ����ش�.
			//�����ͺ��̽��� �����Ѵ�.
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			
			//member��� ���̺� �����ϰ� ���̺� ���� Į���� name, nickname, id, password, email, win, lose�� ����. nickname�� id�� �⺻Ű�� ����ش�.
			String createStr = "CREATE TABLE member (name varchar(20) not null, nickname varchar(20) not null, " +
							   "id varchar(20) not null, password varchar(20) not null, email varchar(40) not null, " +
							   "win int not null, lose int not null, PRIMARY KEY (nickname, id))";
			
			//sql ��ɹ� ����;
			//String
			stmt.executeUpdate("DROP * FROM member;");	//������Ʈ���� �����Ѵ�.
			System.out.println("[Server] ���̺� ���� ����");	//������Ʈ���� �����ϸ� ���̺� ���� ������ �ַܼ� �˸���.
		} catch(Exception e) {	//�����ͺ��̽� ���� �� ���̺� ������ ���ܰ� �߻����� �� ���и� �ַܼ� �˸���.
			System.out.println("[Server] �����ͺ��̽� ���� Ȥ�� ���̺� ������ ���� �߻� > " + e.toString());
		}
	}

}
