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
	connectingDB user = new connectingDB(); // �����ڸ��� ��������
	
	
	private JPanel loginPanel = new JPanel(new GridLayout(5, 2));
	private JLabel idLabel = new JLabel("���̵� ");
	private JLabel pwLabel = new JLabel("��й�ȣ ");
	private JLabel nonLabel = new JLabel("");
	private JLabel nonLabel2 = new JLabel("");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("�α���");
	private JButton idpwSearchBtn = new JButton("ȸ������");
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
		
		setTitle("�α���");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        // ���̾ƿ� ����
        setLayout(null);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1000, 500);
        layeredPane.setLayout(null);
 
        // �г�1
        // �̹��� �޾ƿ���
        try {
            img = ImageIO.read(new File("C:\\\\Users\\\\82108\\\\eclipse-workspace\\\\RockPaperScissors\\\\src\\\\RockPaperScissors\\\\rps.jpg"));
        } catch (IOException e) {
            System.out.println("�̹��� �ҷ����� ����");
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
		//�� ��� ����
		idLabel.setHorizontalAlignment(NORMAL);
		pwLabel.setHorizontalAlignment(NORMAL);
		
		//���� ������ â ��� ���� setSize�� ���� ���־�� ���������� �������� ��� ������ ��!
		
		setSize(1000,500);
		this.setLocationRelativeTo(null);
		
		add(layeredPane);
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//�α��� ��ư�� ��������

		loginBtn.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {

				//���̵� ��� Ȯ�� �׽�Ʈ �ڵ�

				String id = idText.getText().trim();
				String pw = pwText.getText().trim();

				if(id.length()==0 || pw.length()==0) {
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� �Է� �ϼž� �˴ϴ�.", "���̵� ����� �Է�!", JOptionPane.DEFAULT_OPTION);
					return;
				}

				String nickname=user.loginCheck(id, pw);
				if(nickname.equals("null")) {
					
					JOptionPane.showMessageDialog(null, "�α��� ����", "�α��� Ȯ��!", JOptionPane.DEFAULT_OPTION);
				}

				else{
					JOptionPane.showMessageDialog(null, "�α��� ����", "�α��� Ȯ��!", JOptionPane.DEFAULT_OPTION);
					// ���ηκ� ȣ���ϴ� �Լ�
					setVisible(false);
					
					user.inputLoginNum(nickname);
		            HandGameClient client = new HandGameClient("���������� ����",nickname);
		            client.setSize(1000, 400);
		            client.show();
		            client.creat(client);
		            client.setLocationRelativeTo(null);
		               
					
					return;
				}
				
			}
		});
		

//ȸ�������ϱ� ��ư ������
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
