package RockPaperScissors;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class GUI extends JFrame{
	connectingDB user = new connectingDB(); // 들어오자마자 서버접속
	
	
	private JPanel loginPanel = new JPanel(new GridLayout(5, 2));
	private JLabel idLabel = new JLabel("아이디 ");
	private JLabel pwLabel = new JLabel("비밀번호 ");
	private JLabel nonLabel = new JLabel("");
	private JLabel nonLabel2 = new JLabel("");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("로그인");
	private JButton idpwSearchBtn = new JButton("회원가입");
	public RESIGSTER register ;
	
	private int flagforclient=0;
	
	BufferedImage img = null;
	class MyPanel extends JPanel {
	       public void paint(Graphics g) {
	           g.drawImage(img, 0, 0, null);
	       }
	       }
	
	public GUI() {
		//super("Welcome!");
		
		setTitle("로그인");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        // 레이아웃 설정
        setLayout(null);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1000, 500);
        layeredPane.setLayout(null);
 
        // 패널1
        // 이미지 받아오기
        try {
            img = ImageIO.read(new File("C:\\\\Users\\\\82108\\\\eclipse-workspace\\\\RockPaperScissors\\\\src\\\\RockPaperScissors\\\\rps.jpg"));
        } catch (IOException e) {
            System.out.println("이미지 불러오기 실패");
            System.exit(0);
        }
         
        MyPanel panel = new MyPanel();
        panel.setBounds(0, 0, 1000, 500);
        
        this.setContentPane(loginPanel);
      
    
		loginPanel.add(nonLabel);
	    loginPanel.add(nonLabel2);
		loginPanel.add(idLabel);
		loginPanel.add(pwLabel);
		loginPanel.add(idText);
		loginPanel.add(pwText);
		loginPanel.add(idpwSearchBtn);
		loginPanel.add(loginBtn);
		//라벨 가운데 정렬
		idLabel.setHorizontalAlignment(NORMAL);
		pwLabel.setHorizontalAlignment(NORMAL);
		
		//현재 프레임 창 가운데 정렬 setSize를 먼저 해주어야 정상적으로 프레임이 가운데 정렬이 됨!
		
		setSize(1000,500);
		this.setLocationRelativeTo(null);
		
		add(layeredPane);
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//로그인 버튼을 눌렀을때

		loginBtn.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {

				//아이디 비번 확인 테스트 코드

				String id = idText.getText().trim();
				String pw = pwText.getText().trim();

				if(id.length()==0 || pw.length()==0) {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력!", JOptionPane.DEFAULT_OPTION);
					return;
				}

				String nickname=user.loginCheck(id, pw);
				if(nickname.equals("null")) {
					
					JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
				}

				else{
					JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
					// 메인로비 호출하는 함수
					setVisible(false);
					
					user.inputLoginNum(nickname);
		            HandGameClient client = new HandGameClient("가위바위보 게임",nickname);
		            client.setSize(1000, 400);
		            client.show();
		            client.creat(client);
		            client.setLocationRelativeTo(null);
		               
					
					return;
				}
				
			}
		});
		

//회원가입하기 버튼 누르면
		register = new RESIGSTER(this);
	idpwSearchBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				register.setVisible(true);
				
			}

		});
	
	
	}




	public static void main(String[] args) {
		
		GUI frame = new GUI();
		//new GUI();
		
	}


	public int getFlagforclient() {
		return flagforclient;
	}


	public void setFlagforclient(int flagforclient) {
		this.flagforclient = flagforclient;
	}
}
