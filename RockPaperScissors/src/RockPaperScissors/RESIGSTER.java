package RockPaperScissors;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RESIGSTER extends JDialog{
	connectingDB user = new connectingDB();

	private JPanel signUpPanel = new JPanel(new GridLayout(20, 0));
	
	 private JTextField idText = new JTextField("���̵�");
	 private JPasswordField pwText = new JPasswordField();
	 //----���̵� �ߺ�Ȯ�� ��� �߰�---------------------------
	 private JButton idcheckBtn = new JButton("���̵� �ߺ� Ȯ��");
	 //------------------------------------------------
	 
	 private JPasswordField pwCheckText = new JPasswordField();
	 private JTextField nameText = new JTextField("�̸�");
	 private JTextField nicknameText = new JTextField("�г���");
	
	 private JTextField emailText = new JTextField("E-mail");
	 private JTextField SNSText = new JTextField("SNS");

	 private JButton signUpbtn = new JButton("ȸ������");
//---------LABEL-------------------------------------------------------
	 private JLabel idlabel = new JLabel("���̵�");
	 private JLabel pwlabel = new JLabel("��й�ȣ");
	 private JLabel pwChecklabel = new JLabel("��й�ȣ Ȯ��");
	 private JLabel namelabel = new JLabel("�̸�");
	 private JLabel nicknamelabel = new JLabel("�г���");
	 private JButton nncheckBtn = new JButton("�г��� �ߺ� Ȯ��");
	 private JLabel emaillabel = new JLabel("E-mail");
	 private JLabel SNSlabel = new JLabel("SNS");

	 private JLabel nonelabel = new JLabel("");

	 private boolean membershipProgress = false;
	 private boolean idcanbeused =false;
	 private boolean nncanbeused =false;

	 public RESIGSTER (Frame frame) {

		super(frame, true);
		this.setTitle("ȸ������");
		
		this.signUpPanel.add(idlabel);
		this.signUpPanel.add(idText);
		this.signUpPanel.add(idcheckBtn);
		this.signUpPanel.add(pwlabel);
		this.signUpPanel.add(pwText);
		this.signUpPanel.add(pwChecklabel);
		this.signUpPanel.add(pwCheckText);
		
		this.signUpPanel.add(nonelabel);
		this.signUpPanel.add(namelabel);
		this.signUpPanel.add(nameText);
		
		this.signUpPanel.add(nicknamelabel);
		this.signUpPanel.add(nicknameText);
		this.signUpPanel.add(nncheckBtn);// �г��� �ߺ�Ȯ�� üũ��ư
		
		this.signUpPanel.add(emaillabel);
		this.signUpPanel.add(emailText);
		this.signUpPanel.add(SNSlabel);
		this.signUpPanel.add(SNSText);
		
		this.signUpPanel.add(nonelabel);
		this.signUpPanel.add(signUpbtn);

		this.setContentPane(signUpPanel);
		this.setSize(500,500);				
		this.setLocationRelativeTo(null);
		FocusEvent();
		checkID();
		checkValue();

		
	}
	 
	 //�ؽ�Ʈ �ʵ忡 �ִ� ���� üũ�ϰ� ����� ���� �޼ҵ�
	 private void FocusEvent() {

			idText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {				
					if(idText.getText().trim().length()==0) {
						idText.setText("���̵�");
					}
				}

				public void focusGained(FocusEvent e) {				
					if(idText.getText().trim().equals("���̵�")) {
						idText.setText("");
					}				
				}
			});

			

			nameText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					if(nameText.getText().trim().length()==0) {
						nameText.setText("�̸�");
					}
				}

				

				public void focusGained(FocusEvent e) {			
					if(nameText.getText().trim().equals("�̸�")) {
						nameText.setText("");

					}

				}

			});

			nicknameText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					if(nicknameText.getText().trim().length()==0) {
						nicknameText.setText("�г���");
					}
				}

				

				public void focusGained(FocusEvent e) {			
					if(nicknameText.getText().trim().equals("�г���")) {
						nicknameText.setText("");

					}

				}

			});
			emailText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					if(emailText.getText().trim().length()==0) {
						emailText.setText("E-mail");
					}
				}



				public void focusGained(FocusEvent e) {
					if(emailText.getText().trim().equals("E-mail")) {
						emailText.setText("");
					}
				}
			});	
			SNSText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					if(SNSText.getText().trim().length()==0) {
						SNSText.setText("SNS");
					}
				}



				public void focusGained(FocusEvent e) {
					if(SNSText.getText().trim().equals("SNS")) {
						SNSText.setText("");
					}
				}
			});	
	 }
	//���̵� �ߺ�Ȯ�� ��ư ������
	 private void checkID() {
		
		 idcheckBtn.addActionListener(new ActionListener() {
			 boolean idischecked;
				public void actionPerformed(ActionEvent e) {
					if(idText.getText().trim().length()==0 || idText.getText().trim().equals("���̵�")) {
						JOptionPane.showMessageDialog(null, "���̵� �Է��� �ּ���.", "���̵� �Է�", JOptionPane.WARNING_MESSAGE);
						idText.grabFocus();
						return;
					}
					
				 idischecked=user.getIdByCheck(getIdText())	;
				 if(!idischecked) 	{
					 JOptionPane.showMessageDialog(null, "����� �� ���� ���̵��Դϴ�.", "���̵� ���Է�", JOptionPane.WARNING_MESSAGE);
					 idcanbeused =false;
					 return;
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "��밡���� ���̵��Դϴ�.", "������̵� ��밡��", JOptionPane.WARNING_MESSAGE);
					 idcheckBtn.setEnabled(false);
					 idcanbeused =true;
					 return;
				 }
				}

			});
		 nncheckBtn.addActionListener(new ActionListener() {
			 boolean nnischecked;
				public void actionPerformed(ActionEvent e) {
					if(nicknameText.getText().trim().length()==0 || nicknameText.getText().trim().equals("�г���")) {
						JOptionPane.showMessageDialog(null, "�г����� �Է��� �ּ���.", "�г��� �Է�", JOptionPane.WARNING_MESSAGE);
						nicknameText.grabFocus();
						return;
					}
					
				 nnischecked=user.getnnByCheck(getNickNameText())	;
				 if(!nnischecked) 	{
					 JOptionPane.showMessageDialog(null, "����� �� ���� �г����Դϴ�.", "�г��� ���Է�", JOptionPane.WARNING_MESSAGE);
					 nncanbeused =false;
					 return;
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "��밡���� �г����Դϴ�.", "����г��� ��밡��", JOptionPane.WARNING_MESSAGE);
					 nncheckBtn.setEnabled(false);
					 nncanbeused =true;
					 return;
				 }
				}

			});
	 }
	 

	 //ȸ�� �����Ҷ� ��� ���� �ԷµǾ����� üũ�ϱ� ���� �޼ҵ�
	 private void checkValue(){
		
		 signUpbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idText.getText().trim().length()==0 || idText.getText().trim().equals("���̵�")) {
					JOptionPane.showMessageDialog(null, "���̵� �Է��� �ּ���.", "���̵� �Է�", JOptionPane.WARNING_MESSAGE);
					idText.grabFocus();
					return;
				}
				if (!idcanbeused) {
					JOptionPane.showMessageDialog(null, "���̵� �ߺ�Ȯ���� �ʿ��մϴ�.", "���̵� �ߺ�Ȯ��", JOptionPane.WARNING_MESSAGE);
					idcheckBtn.grabFocus();
					return;
				}
				
				if(pwText.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է��� �ּ���.", "��й�ȣ �Է�", JOptionPane.WARNING_MESSAGE);
					pwText.grabFocus();
					return;
				}

				

				if(pwCheckText.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "��й�ȣ Ȯ���� �Է��� �ּ���.", "��й�ȣ Ȯ�� �Է�", JOptionPane.WARNING_MESSAGE);
					pwCheckText.grabFocus();
					return;

				}

				

				if(!(pwText.getText().trim().equals(pwCheckText.getText().trim()))) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ���� �ʽ��ϴ�.!!", "��й�ȣ Ȯ��", JOptionPane.WARNING_MESSAGE);
					return;

				}

				

				if(nameText.getText().trim().length()==0 || nameText.getText().trim().equals("�̸�")) {
					JOptionPane.showMessageDialog(null, "�̸��� �Է��� �ּ���.", "�̸� �Է�", JOptionPane.WARNING_MESSAGE);
					nameText.grabFocus();
					return;

				}

				if(nicknameText.getText().trim().length()==0 || nicknameText.getText().trim().equals("�г���")) {
					JOptionPane.showMessageDialog(null, "�г����� �Է��� �ּ���.", "�г��� �Է�", JOptionPane.WARNING_MESSAGE);
					nicknameText.grabFocus();
					return;

				}
				
				if (!nncanbeused) {
					JOptionPane.showMessageDialog(null, "�г��� �ߺ�Ȯ���� �ʿ��մϴ�.", "�г��� �ߺ�Ȯ��", JOptionPane.WARNING_MESSAGE);
					nncheckBtn.grabFocus();
					return;
				}
				
				if(emailText.getText().trim().length()==0 || emailText.getText().trim().equals("E-mail")) {
					JOptionPane.showMessageDialog(null, "E-mail�� �Է��� �ּ���.", "E-mail �Է�", JOptionPane.WARNING_MESSAGE);
					emailText.grabFocus();

					return;

				}

				if(SNSText.getText().trim().length()==0 || SNSText.getText().trim().equals("SNS")) {
					JOptionPane.showMessageDialog(null, "SNS�� �Է��� �ּ���.", "SNS �Է�", JOptionPane.WARNING_MESSAGE);
					SNSText.grabFocus();

					return;

				}

				//������� �Դٸ� ��� ���� �Է��ϰ� �����ϴ� ���� �Ϸ�Ǿ����� ȸ������ ������ �Ϸ�.
				membershipProgress = true;
				user.joinCheck(getIdText(), getPwText(), getNameText(), getNickNameText(), getEmailText(), getSNSText());
				setVisible(false);

			}

		});

	 }

	

	 //���� Ŭ�������� ���̾�α� ȸ������ â �����͸� �������� ���� get �޼ҵ� ����

	public String getIdText() {
		return this.idText.getText().trim();

	}

	public String getPwText() {
		return this.pwText.getText().trim();

	}


	public String getPwCheckText() {
		return this.pwCheckText.getText().trim();

	}

	public String getNameText() {
		return this.nameText.getText().trim();

	}

	public String getNickNameText() {
		return this.nicknameText.getText().trim();

	}

	public String getEmailText() {
		return this.emailText.getText().trim();

	}
	public String getSNSText() {
		return this.SNSText.getText().trim();

	}

	public boolean memberCheck() {
		return membershipProgress;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

