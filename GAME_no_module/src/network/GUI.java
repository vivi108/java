package network;
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;


public class GUI extends JFrame{
	connectingDB user = new connectingDB(); // �����ڸ��� ��������
	
	private JPanel loginPanel = new JPanel(new GridLayout(3, 2));
	private JLabel idLabel = new JLabel("���̵� ");
	private JLabel pwLabel = new JLabel("��й�ȣ ");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("�α���");
	private JButton idpwSearchBtn = new JButton("ȸ������");
	public RESIGSTER register ;

	public GUI() {
		super("Welcome!");
		this.setContentPane(loginPanel);
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

		setSize(400,200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//�α��� ��ư�� ��������

		loginBtn.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {

				//���̵� ��� Ȯ�� �׽�Ʈ �ڵ�~

				String id = idText.getText().trim();
				String pw = pwText.getText().trim();

				if(id.length()==0 || pw.length()==0) {
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� �Է� �ϼž� �˴ϴ�.", "���̵� ����� �Է�!", JOptionPane.DEFAULT_OPTION);
					return;
				}


				if(user.loginCheck(id, pw).equals("null")) {
					
					JOptionPane.showMessageDialog(null, "�α��� ����", "�α��� Ȯ��!", JOptionPane.DEFAULT_OPTION);
				}

				else{
					JOptionPane.showMessageDialog(null, "�α��� ����", "�α��� Ȯ��!", JOptionPane.DEFAULT_OPTION);
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
		new GUI();
	}

}