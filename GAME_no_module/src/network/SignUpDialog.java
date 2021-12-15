package network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUpDialog extends JDialog{
	 private JPanel signUpPanel = new JPanel(new GridLayout(11, 0));
	 private JTextField idText = new JTextField("���̵�");
	 private JPasswordField pwText = new JPasswordField();
	 private JPasswordField pwCheckText = new JPasswordField();
	 private JTextField nameText = new JTextField("�̸�");
	 private JTextField birthYearText = new JTextField("���� �⵵");
	 private String[] birthMonthContent = {"���� ��","1","2","3","4","5","6","7","8","9","10","11","12"};	 
	 private JComboBox<String> birthMonthList = new JComboBox<>(birthMonthContent);	 	 
	 private JTextField birthDayText = new JTextField("���� ����");
	 private JTextField phoneNumberText = new JTextField("�ڵ��� ��ȣ");
	 private JButton signUpbtn = new JButton("ȸ������");
	 private JLabel pwlabel = new JLabel("��й�ȣ");
	 private JLabel pwChecklabel = new JLabel("��й�ȣ Ȯ��");
	  
	 private boolean membershipProgress = false;

	 public SignUpDialog(Frame frame) {
		super(frame, true);
		this.setTitle("ȸ������");
		
		this.signUpPanel.add(idText);
		this.signUpPanel.add(pwlabel);
		this.signUpPanel.add(pwText);
		this.signUpPanel.add(pwChecklabel);
		this.signUpPanel.add(pwCheckText);
		this.signUpPanel.add(nameText);
		this.signUpPanel.add(birthYearText);
		this.signUpPanel.add(birthMonthList);
		this.signUpPanel.add(birthDayText);
		this.signUpPanel.add(phoneNumberText);
		this.signUpPanel.add(signUpbtn);
		
		this.setContentPane(signUpPanel);
		this.setSize(300,500);				
		this.setLocationRelativeTo(null);

		FocusEvent();
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
			
			birthYearText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					if(birthYearText.getText().trim().length()==0) {
						birthYearText.setText("���� �⵵");
					}
				}

				public void focusGained(FocusEvent e) {
					if(birthYearText.getText().trim().equals("���� �⵵")) {
						birthYearText.setText("");
					}
				}
			});
			
			birthDayText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					if(birthDayText.getText().trim().length()==0) {
						birthDayText.setText("���� ����");
					}
				}

				public void focusGained(FocusEvent e) {
					if(birthDayText.getText().trim().equals("���� ����")) {
						birthDayText.setText("");
					}
				}
			});
			
			phoneNumberText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					if(phoneNumberText.getText().trim().length()==0) {
						phoneNumberText.setText("�ڵ��� ��ȣ");
					}
				}

				public void focusGained(FocusEvent e) {
					if(phoneNumberText.getText().trim().equals("�ڵ��� ��ȣ")) {
						phoneNumberText.setText("");
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
				
				if(birthYearText.getText().trim().length()==0 || birthYearText.getText().trim().equals("���� �⵵")) {
					JOptionPane.showMessageDialog(null, "��������� ���� �⵵�� �Է��� �ּ���.", "���� �⵵ �Է�", JOptionPane.WARNING_MESSAGE);
					birthYearText.grabFocus();
					return;
				}
								
				if(birthMonthList.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "��������� ���� ������ �ּ���.", "�� �Է�", JOptionPane.WARNING_MESSAGE);
					birthMonthList.grabFocus();
					return;
				}
				
				if(birthDayText.getText().trim().length()==0 || birthDayText.getText().trim().equals("���� ����")) {
					JOptionPane.showMessageDialog(null, "���� ���ڸ� �Է��� �ּ���.", "���� ���� �Է�", JOptionPane.WARNING_MESSAGE);
					birthDayText.grabFocus();
					return;
				}
				
				if(phoneNumberText.getText().trim().length()==0 || phoneNumberText.getText().trim().equals("�ڵ��� ��ȣ")) {
					JOptionPane.showMessageDialog(null, "�ڵ��� ��ȣ�� �Է��� �ּ���.", "�ڵ��� ��ȣ �Է�", JOptionPane.WARNING_MESSAGE);
					phoneNumberText.grabFocus();
					return;
				}
				
				//������� �Դٸ� ��� ���� �Է��ϰ� �����ϴ� ���� �Ϸ�Ǿ����� ȸ������ ������ �Ϸ�.
				membershipProgress = true;
								
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

	public String getBirthYearText() {
		return this.birthYearText.getText().trim();
	}

	public String getBirthMonthContent() {
		return this.birthMonthList.getSelectedItem().toString();
	}

	public String getBirthDayText() {
		return this.birthDayText.getText();
	}

	public String getPhoneNumberText() {
		return this.phoneNumberText.getText().trim();
	}

	public boolean memberCheck() {
		return membershipProgress;
	}
	 
	 
	 
}
