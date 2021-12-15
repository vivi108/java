package RockPaperScissors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class HandGameClient extends Frame implements ActionListener, KeyListener,MouseListener{
	connectingDB user =new connectingDB();
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

      private static final int WIN=1111;
	  private static final int LOSE=1110;

	 
      public void creat(HandGameClient client){
         cc_thread = new ClientThread(client); // ���� ȣ��Ʈ�� ������
         cc_thread.start(); // Ŭ���̾�Ʈ�� �����带 �����Ѵ�.
      }

      public HandGameClient(String str,String nick){

         super(str);
         setLayout(new BorderLayout());
      
        //////////


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
         Stat_Button.addActionListener(this); ///// �α׿� ������ Ŭ�� �� �������� �ϵ��� ���� �˻� ������ ������ �˾����� �ߵ���.
        center_panel.add(Stat_Button,BorderLayout.SOUTH);
         add("Center",center_panel);

        ////////////

         Panel south_panel = new Panel();
         south_panel.setLayout(new FlowLayout());
         LogOn_Button = new Button("�α׿½���");
         LogOn_Button.addActionListener(this);
         south_panel.add(LogOn_Button);

         TextField_ID = new TextField(nick,10);
         TextField_ID.addKeyListener(this);
         south_panel.add(TextField_ID);

         cc_btEnter = new Button("��������");
         cc_btEnter.addActionListener(this);
         south_panel.add(cc_btEnter);

         cc_btLogout = new Button("�α׾ƿ�");
         cc_btLogout.addActionListener(this);
         south_panel.add(cc_btLogout);

         add("South", south_panel);

         /////////ê

         addWindowListener(new WinListener());
      }

      class WinListener extends WindowAdapter
      {
         public void windowClosing(WindowEvent we){ //�α׾ƿ�
           
            if(myID ==cc_thread.st_ID){
               cc_thread.requestLogout(myID);
            }
            System.exit(0); 
         }
      }

      //��ư ������
      public void actionPerformed(ActionEvent ae){
         Button b = (Button)ae.getSource();

         if(b.getLabel().equals("�α׿½���")) {

           //Client ����� ���ÿ� �α��� �˾��� ���� �߰� �ؼ� �α����� �Ϸ� �Ǹ�
           //TextField_ID �� �г����� ������,,,,,,
           myID = TextField_ID.getText();
           if (!myID.equals("")) {
              cc_thread.requestLogon(myID);
           } else {
              MessageBox msgBox = new MessageBox(this, "�α׿�", "�α׿� id�� �Է��ϼ���.");
              msgBox.show();
           }
        }else if(b.getLabel().equals("�����˻�")) {
              if (!myID.equals("")) {
                 // ���ӿ�û ó�� ��ƾ
                 String stat_info = user.viewInfo(targetID);
                 String[] splitted = stat_info.split("//");
                 JFrame jframe= new JFrame();
                 JOptionPane.showMessageDialog(jframe, "�г��� : "+splitted[0]+"\n�¸�Ƚ�� : "+splitted[1]+"\n�й� Ƚ�� : "+splitted[2],"������ȸ", JOptionPane.PLAIN_MESSAGE);
           
              }
        } else if(b.getLabel().equals("��������")){
            if(!myID.equals("")){
               // ���ӿ�û ó�� ��ƾ
               myID = TextField_ID.getText();
              
                     if(myID.equals(targetID) ) {
                        //�ڽ��� Ŭ������ ��
                        Text_Status.setText("�ڽŰ��� ������ �� �� �����ϴ�.\n");
                     }
                     else if(targetID ==null) {
                        //������ ����� ���� ��������
                        Text_Status.setText("������ �� ����� ������ �ּ���.\n");
                     }
                     else{
                        //���濡�� ���ӿ�û
                        cc_thread.requestPlayGame(targetID); 
                     }                 
                     targetID=null;
            }else{
                  MessageBox msgBox = new  MessageBox(this, "�α׿�", "�α׿� id�� �Է��ϼ���.");
                  msgBox.show();
            }
         }else if(b.getLabel().equals("�α׾ƿ�")){
               // �α׾ƿ� ó�� ��ƾ
        	 
        	 user.inputLastloginT(myID);// �г����� �޾ƿ� ����ð� ����
            
             InetAddress local; //ip �����ϱ�
         	try { 
         		local = InetAddress.getLocalHost(); 
         		String ip = local.getHostAddress(); 
         		user.inputlonginIP(myID, ip);
         		} catch (UnknownHostException e1) {
         			e1.printStackTrace(); 
         		}
        	 
               cc_thread.requestLogout(myID);
               setVisible(false);
         }
      }
      
      
      //enterŰ�ε� �α��� ����
      public void keyPressed(KeyEvent ke){
         myID = TextField_ID.getText(); // �α׿� ID�� �д´�.
         
         if(ke.getKeyChar() == KeyEvent.VK_ENTER){
            if(!myID.equals("")){
               cc_thread.requestLogon(myID); // ClientThread�� �޼ҵ带 ȣ��
               
            }else{
               MessageBox msgBox = new  MessageBox(this, "�α׿�", "�α׿� id�� �Է��ϼ���.");
               msgBox.show();
            }
         }
      }


   @Override
   public void keyReleased(KeyEvent e) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void keyTyped(KeyEvent e) {
      // TODO Auto-generated method stub
      
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