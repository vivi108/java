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
		
		try {	//데이터베이스 연결은 try-catch문으로 예외를 잡아준다.
			//데이터베이스와 연결한다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			
			//member라는 테이블 생성하고 테이블 안의 칼럼은 name, nickname, id, password, email, win, lose가 존재. nickname과 id를 기본키로 잡아준다.
			String createStr = "CREATE TABLE member (name varchar(20) not null, nickname varchar(20) not null, " +
							   "id varchar(20) not null, password varchar(20) not null, email varchar(40) not null, " +
							   "win int not null, lose int not null, PRIMARY KEY (nickname, id))";
			
			//sql 명령문 종류;
			//String
			stmt.executeUpdate("DROP * FROM member;");	//업데이트문을 수행한다.
			System.out.println("[Server] 테이블 생성 성공");	//업데이트문이 성공하면 테이블 생성 성공을 콘솔로 알린다.
		} catch(Exception e) {	//데이터베이스 연결 및 테이블 생성에 예외가 발생했을 때 실패를 콘솔로 알린다.
			System.out.println("[Server] 데이터베이스 연결 혹은 테이블 생성에 문제 발생 > " + e.toString());
		}
	}

}
