package RockPaperScissors;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.net.*;


import RockPaperScissors.HandGameClient;
import RockPaperScissors.ClientThread;


public class PlayGame extends Frame implements ActionListener {
	
	private Button bt_scissors, bt_paper, bt_rock;
	public Label lb_status;
	
	public TextArea dr_taContents; // ��ȭ�� ���� ����Ʈâ
	public List dr_lstMember; // ���� ������ �ʵ�

	public TextField userID1,roomname; //�ڽ��� ID;
	//static String targetID;

	public static ClientThread dr_thread;
	public static HandGameClient dr_client;
	public String choose; //�� ��ư
	
	public PlayGame(RockPaperScissors.ClientThread clientThread, String title,String id,String idTo) {
		super(title);
		dr_thread = clientThread;
	    setLayout(new BorderLayout());
	    
		Panel northpanel = new Panel();
		northpanel.setLayout(new BorderLayout());
		Panel roomnamepanel = new Panel();
		Label roomlabel = new Label("�� �̸�");
		roomnamepanel.add(roomlabel,BorderLayout.WEST);
		roomname = new TextField(15);
		roomname.setText(" "+ id +"   vs   "+idTo);
		roomname.setEnabled(false);
		roomnamepanel.add(roomname,BorderLayout.EAST);
		northpanel.add(roomnamepanel,BorderLayout.NORTH);
		
		Label lbl_1 = new Label("��");
		northpanel.add(lbl_1,BorderLayout.WEST);	
		userID1 = new TextField(dr_thread.st_ID,25);
		userID1.setEnabled(false);
		northpanel.add(userID1,BorderLayout.EAST);	
		
		Panel buttonpanel = new Panel();
		bt_scissors = new Button("����");
		buttonpanel.add(bt_scissors,BorderLayout.EAST);
		bt_scissors.addActionListener(this);
		
		bt_paper = new Button("����");
		buttonpanel.add(bt_paper,BorderLayout.CENTER);
		bt_paper.addActionListener(this);

		
		bt_rock = new Button("��");
		buttonpanel.add(bt_rock,BorderLayout.WEST);
		bt_rock.addActionListener(this);
		
		Panel southpanel = new Panel();
		lb_status = new Label("���ӽ���! �����ϰ���� ��ư�� ��������!");
		southpanel.add(lb_status);
		
		add("North", northpanel);
	    add("Center", buttonpanel);
	    add("South", southpanel);

		addWindowListener(new WinListener());

	   }
	
	   class WinListener extends WindowAdapter
	   {
	      public void windowClosing(WindowEvent we){
	    	  
	    	  //���ӹ��� ������ ���� ȭ������ ���ƿ´�.
	    	  dr_thread.requestQuiterRoom(dr_thread.st_ID);
	      }
	   }

	   // ȭ�������, �α׾ƿ� �̺�Ʈ�� ó���Ѵ�.
	   public void actionPerformed(ActionEvent ae){
	      Button b = (Button)ae.getSource();
	      if(b.getLabel().equals("����")){
	    	  dr_thread.requestSendResult("0");

	      }else if(b.getLabel().equals("����")){  	    	
	    	 dr_thread.requestSendResult("1");  
	      }
	      else if(b.getLabel().equals("��")){ 
	    	  dr_thread.requestSendResult("2");
	       }
  
	   }
		
	}


