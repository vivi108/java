package RockPaperScissors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class HandGameClient extends Frame implements MouseListener{

		connectingDB user = new connectingDB();

	   public TextField TextField_ID; // �α׿� �Է� �ؽ�Ʈ �ʵ�
	   public Button LogOn_Button; // �α׿� ���� ��ư
	   private Button cc_btEnter; // ���ӿ�û ��ư
	   private Button cc_btLogout; // �α׾ƿ� ��ư
		private Button Stat_Button; // �α׾ƿ� ��ư
	   public TextField Text_Status; // �α׿� ���� �ȳ�
	   public List LogOn_Member,cc_lstPlayer; //  �α׿� ������

	   public static ClientThread cc_thread;
	   public static HandGameClient client;
	   public String myID ="";
	   String targetID=null;  //���� ����� ����

	private static final int WIN = 1111;
	private static final int LOSE = 1110;

	  //ê
	  String setnick=null;
	JPanel textingPanel = new JPanel();
	JTextField textField = new JTextField(50);
	JTextArea messageArea = new JTextArea(16, 50);


		public void creat(HandGameClient client){
			cc_thread = new ClientThread(client); // ���� ȣ��Ʈ�� ������
			cc_thread.start(); // Ŭ���̾�Ʈ�� �����带 �����Ѵ�.
			cc_thread.requestLogon(setnick);
		}

	   public HandGameClient(String str,String nick){

			super(str);
		   this.setnick=nick;
			setLayout(new BorderLayout());

		  ////////

	      Panel north_panel = new Panel();
	      north_panel.setLayout(new FlowLayout());
	      Text_Status = new TextField("������ �����Ϸ���  ID�� �Է��Ͻʽÿ�.",43);
	      Text_Status.setEditable(false);
	      north_panel.add(Text_Status);
		  add("North", north_panel);

		  //////////////////

		   Panel center_panel = new Panel();
	      center_panel.setLayout(new BorderLayout());
	      Panel label = new Panel();
	      label.add(new Label("�α׿� �� ������"),BorderLayout.EAST) ;
	      label.add(new Label("����������"),BorderLayout.WEST) ;
		  center_panel.add(label,BorderLayout.NORTH);


	      Panel board = new Panel();
	      LogOn_Member = new List(10);
	      board.add(LogOn_Member,BorderLayout.EAST);
	      cc_lstPlayer = new List(10);
	      LogOn_Member.addMouseListener(this);
	      board.add(cc_lstPlayer,BorderLayout.WEST);
		  center_panel.add(board,BorderLayout.CENTER);


		  /////////////// ���� �̺�Ʈ �Լ� �߰��ϱ�/////////////
		  Stat_Button =new Button("�����˻�");
		  center_panel.add(Stat_Button,BorderLayout.SOUTH);
		   add("Center",center_panel);

		  ////////////

		   Panel south_panel = new Panel();
		   south_panel.setLayout(new FlowLayout());

		   TextField_ID = new TextField(nick,10);
		   south_panel.add(TextField_ID);

		   cc_btEnter = new Button("���ӿ�û");
		   south_panel.add(cc_btEnter);

		   cc_btLogout = new Button("�α׾ƿ�");
		   south_panel.add(cc_btLogout);

		   add("South", south_panel);

		   /////////ê
		   textField.setEditable(true);
		   messageArea.setEditable(false);
		   textingPanel.setLayout(new BorderLayout());
		   textingPanel.add(textField,BorderLayout.SOUTH);
		   textingPanel.add(new JScrollPane(messageArea),BorderLayout.CENTER);

		   add("East",textingPanel);

	      addWindowListener(new WinListener());

		  /* ���ǵ� */
		   textField.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) { // enter Ű�� ������

				   cc_thread.chat(textField.getText()); // �޼����� ������
				   textField.setText(""); // text field ���.
			   } //���࿡ �ؽ�Ʈ�ʵ忡 �Է��ϸ� ����� �ϵ��� �׼� �����ʷ� ����
		   });

		   cc_btEnter.addActionListener(new ActionListener() { //��������
			   @Override
			   public void actionPerformed(ActionEvent e) {
				   cc_thread.requestPlayGame(targetID);
			   }
		   });

		   cc_btLogout.addActionListener(new ActionListener() { //�α׾ƿ�
			   @Override
			   public void actionPerformed(ActionEvent e) {
				   //
				   user.inputLastloginT(myID);// �г����� �޾ƿ� ����ð� ����

				   setVisible(false);

			   }
		   });
		   Stat_Button.addActionListener(new ActionListener() {
			   @Override
			   public void actionPerformed(ActionEvent e) {
				   String stat_info = user.viewInfo(targetID);
				   String[] splitted = stat_info.split("//");
				   JFrame jframe = new JFrame();
				   JOptionPane.showMessageDialog(jframe, "�г��� : " + splitted[0] + "\n�¸�Ƚ�� : " + splitted[1] + "\n�й� Ƚ�� : " + splitted[2], "������ȸ", -1);
			   }
		   });


		}

	class WinListener extends WindowAdapter {
		WinListener() {
		}
		public void windowClosing(WindowEvent we) {
			if (HandGameClient.this.myID == ClientThread.st_ID) {
				HandGameClient.cc_thread.requestLogout(HandGameClient.this.myID);
			}
			System.exit(0);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//�����ϰ� ���� ����� �����Ѵ�.
		targetID = LogOn_Member.getSelectedItem().toString();
		System.out.println(targetID);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


   	   
}
