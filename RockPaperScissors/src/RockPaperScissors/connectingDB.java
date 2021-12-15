package RockPaperScissors;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connectingDB {
	Connection con = null;
	Statement stmt = null;
	String url = "jdbc:mysql://localhost/game";
	String user = "root";
	String passwd = "12345";

	connectingDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection(this.url, this.user, this.passwd);
			this.stmt = this.con.createStatement();
			System.out.println("[Server] MySQL ���� ���� ����");
		} catch (Exception var2) {
			System.out.println("[Server] MySQL ���� ���� ����> " + var2.toString());
		}

	}

	public String loginCheck(String _i, String _p) {
		String nickname = "null";
		String id = _i;
		String pw = SHA256(_p);

		try {
			String checkingStr = "SELECT password, nickname FROM member WHERE id='" + id + "'";
			ResultSet result = this.stmt.executeQuery(checkingStr);

			for(int var8 = 0; result.next(); ++var8) {
				if (pw.equals(result.getString("password"))) {
					nickname = result.getString("nickname");
					System.out.println("[Server] �α��� ����");
				} else {
					nickname = "null";
					System.out.println("[Server] �α��� ����");
				}
			}
		} catch (Exception var9) {
			nickname = "null";
			System.out.println("[Server] �α��� ���� > " + var9.toString());
		}

		return nickname;
	}

	public boolean joinCheck(String id, String pw, String name, String nickname, String email, String sns) {
		boolean flag = false;
		String encordPW = SHA256(pw);

		try {
			String insertStr = "INSERT INTO member VALUES('" + id + "', '" + encordPW + "', '" + name + "', '" + nickname + "', '" + email + "','" + sns + "', 0, 0, null, 0, null, null);";
			this.stmt.executeUpdate(insertStr);
			flag = true;
			System.out.println("[Server] ȸ������ ����");
		} catch (Exception var10) {
			flag = false;
			System.out.println("[Server] ȸ������ ���� > " + var10.toString());
		}

		return flag;
	}

	public boolean getIdByCheck(String id) {
		boolean result = true;

		try {
			String s = "select id from member where id=\"" + id + "\";";
			ResultSet rs = this.stmt.executeQuery(s);
			System.out.println(rs);
			if (rs.next()) {
				result = false;
			}
		} catch (SQLException var5) {
			System.out.println(var5 + "=>  getIdByCheck fail");
		}

		return result;
	}

	public boolean getnnByCheck(String nn) {
		boolean result = true;

		try {
			String s = "select id from member where nickname=\"" + nn + "\";";
			ResultSet rs = this.stmt.executeQuery(s);
			System.out.println(rs);
			if (rs.next()) {
				result = false;
			}
		} catch (SQLException var5) {
			System.out.println(var5 + "=>  getnnByCheck fail");
		}

		return result;
	}

	public String viewInfo(String _nn) {
		String msg = "null";
		String nick = _nn;

		try {
			String viewStr = "SELECT win, lose FROM member WHERE nickname='" + nick + "'";

			for(ResultSet result = this.stmt.executeQuery(viewStr); result.next(); msg = nick + "//" + result.getString("win") + "//" + result.getString("lose")) {
			}

			System.out.println("[Server] ȸ������ ��ȸ ����");
		} catch (Exception var6) {
			System.out.println("[Server] ȸ������ ��ȸ ���� > " + var6.toString());
		}

		return msg;
	}

	public void inputwin(String _nn) {
		String nick = _nn;

		try {
			String viewwin = "update member set win=win+1 WHERE nickname='" + nick + "'";
			this.stmt.executeUpdate(viewwin);
			System.out.println("[Server] ȸ�� �¸�Ƚ�� ���� ����");
		} catch (Exception var4) {
			System.out.println("[Server] ȸ�� �¸�Ƚ�� ���� ���� > " + var4.toString());
		}

	}

	public void inputlose(String _nn) {
		String nick = _nn;

		try {
			String viewwin = "update member set lose=lose+1 WHERE nickname='" + nick + "'";
			this.stmt.executeUpdate(viewwin);
			System.out.println("[Server] ȸ�� �й�Ƚ�� ���� ����");
		} catch (Exception var4) {
			System.out.println("[Server] ȸ�� �й�Ƚ�� ���� ���� > " + var4.toString());
		}

	}

	public void inputLoginNum(String _nn) {
		String nick = _nn;

		try {
			String viewwin = "update member set loginnum=loginnum+1 WHERE nickname='" + nick + "'";
			this.stmt.executeUpdate(viewwin);
			System.out.println("[Server] ȸ�� �α��� Ƚ�� ���� ����");
		} catch (Exception var4) {
			System.out.println("[Server] ȸ�� �α��� Ƚ�� ���� ���� > " + var4.toString());
		}

	}

	public void inputLastloginT(String _nn) {
		String nick = _nn;
		System.out.println("check");
		try {
			String updateT = "update member set lastloginT=now() WHERE nickname='" + nick + "'";
			this.stmt.executeUpdate(updateT);
			System.out.println("[Server] ȸ�� �α׾ƿ� �ð� ���� ����");
		} catch (Exception var4) {
			System.out.println("[Server] ȸ�� �α׾ƿ� �ð� ���� ���� > " + var4.toString());
		}

	}

	public void inputlonginIP(String _nn, String ip) {
		String nick = _nn;

		try {
			String updateT = "update member set loginIP='" + ip + "'WHERE nickname='" + nick + "'";
			this.stmt.executeUpdate(updateT);
			System.out.println("[Server] ȸ�� IP ���� ����");
		} catch (Exception var5) {
			System.out.println("[Server] ȸ�� IP ���� ���� > " + var5.toString());
		}

	}

	public static String SHA256(String str) {
		String SHA = "";

		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte[] byteData = sh.digest();
			StringBuffer sb = new StringBuffer();

			for(int i = 0; i < byteData.length; ++i) {
				sb.append(Integer.toString((byteData[i] & 255) + 256, 16).substring(1));
			}

			SHA = sb.toString();
		} catch (NoSuchAlgorithmException var6) {
			var6.printStackTrace();
			SHA = null;
		}

		return SHA;
	}

	public static void main(String[] args) {
	}
}