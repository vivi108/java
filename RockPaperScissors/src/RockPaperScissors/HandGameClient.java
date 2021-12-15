package RockPaperScissors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class HandGameClient extends Frame implements ActionListener, KeyListener,MouseListener{
	connectingDB user =new connectingDB();
      public TextField TextField_ID; // 로그온 입력 텍스트 필드
      public Button LogOn_Button; // 로그온 실행 버튼
      private Button cc_btEnter; // 게임요청 버튼
      private Button cc_btLogout; // 로그아웃 버튼
      private Button Stat_Button; // 로그아웃 버튼
      public TextField Text_Status; // 로그온 개설 안내
      public List LogOn_Member,cc_lstPlayer; //  로그온 참가자

      public static ClientThread cc_thread;
      public static HandGameClient client;
      public String myID ="";
      String targetID=null;  //게임 대상자 선택

      private static final int WIN=1111;
	  private static final int LOSE=1110;

	 
      public void creat(HandGameClient client){
         cc_thread = new ClientThread(client); // 로컬 호스트용 생성자
         cc_thread.start(); // 클라이언트의 스레드를 시작한다.
      }

      public HandGameClient(String str,String nick){

         super(str);
         setLayout(new BorderLayout());
      
        //////////


         Panel north_panel = new Panel();
         north_panel.setLayout(new FlowLayout());
         Text_Status = new TextField("게임을 시작하려면  ID를 입력하십시오.",43);
         Text_Status.setEditable(false);
         north_panel.add(Text_Status);
        add("North", north_panel);

        //////////////////

         Panel center_panel = new Panel();
         center_panel.setLayout(new BorderLayout());
         Panel label = new Panel();
         label.add(new Label("로그온 중 참여자"),BorderLayout.EAST) ;
         label.add(new Label("게임참여자"),BorderLayout.WEST) ;
        center_panel.add(label,BorderLayout.NORTH);


         Panel board = new Panel();
         LogOn_Member = new List(10);
         board.add(LogOn_Member,BorderLayout.EAST);
         cc_lstPlayer = new List(10);
         LogOn_Member.addMouseListener(this);
         board.add(cc_lstPlayer,BorderLayout.WEST);
        center_panel.add(board,BorderLayout.CENTER);


        /////////////// 전적 이벤트 함수 추가하기/////////////
        Stat_Button =new Button("전적검색");
         Stat_Button.addActionListener(this); ///// 로그온 참여자 클릭 후 게임참여 하듯이 전적 검색 누르면 전적이 팝업으로 뜨도록.
        center_panel.add(Stat_Button,BorderLayout.SOUTH);
         add("Center",center_panel);

        ////////////

         Panel south_panel = new Panel();
         south_panel.setLayout(new FlowLayout());
         LogOn_Button = new Button("로그온실행");
         LogOn_Button.addActionListener(this);
         south_panel.add(LogOn_Button);

         TextField_ID = new TextField(nick,10);
         TextField_ID.addKeyListener(this);
         south_panel.add(TextField_ID);

         cc_btEnter = new Button("게임참여");
         cc_btEnter.addActionListener(this);
         south_panel.add(cc_btEnter);

         cc_btLogout = new Button("로그아웃");
         cc_btLogout.addActionListener(this);
         south_panel.add(cc_btLogout);

         add("South", south_panel);

         /////////챗

         addWindowListener(new WinListener());
      }

      class WinListener extends WindowAdapter
      {
         public void windowClosing(WindowEvent we){ //로그아웃
           
            if(myID ==cc_thread.st_ID){
               cc_thread.requestLogout(myID);
            }
            System.exit(0); 
         }
      }

      //버튼 리스너
      public void actionPerformed(ActionEvent ae){
         Button b = (Button)ae.getSource();

         if(b.getLabel().equals("로그온실행")) {

           //Client 실행과 동시에 로그인 팝업도 같이 뜨게 해서 로그인이 완료 되면
           //TextField_ID 에 닉네임이 오도록,,,,,,
           myID = TextField_ID.getText();
           if (!myID.equals("")) {
              cc_thread.requestLogon(myID);
           } else {
              MessageBox msgBox = new MessageBox(this, "로그온", "로그온 id를 입력하세요.");
              msgBox.show();
           }
        }else if(b.getLabel().equals("전적검색")) {
              if (!myID.equals("")) {
                 // 게임요청 처리 루틴
                 String stat_info = user.viewInfo(targetID);
                 String[] splitted = stat_info.split("//");
                 JFrame jframe= new JFrame();
                 JOptionPane.showMessageDialog(jframe, "닉네임 : "+splitted[0]+"\n승리횟수 : "+splitted[1]+"\n패배 횟수 : "+splitted[2],"전적조회", JOptionPane.PLAIN_MESSAGE);
           
              }
        } else if(b.getLabel().equals("게임참여")){
            if(!myID.equals("")){
               // 게임요청 처리 루틴
               myID = TextField_ID.getText();
              
                     if(myID.equals(targetID) ) {
                        //자신을 클릭했을 시
                        Text_Status.setText("자신과는 게임을 할 수 없습니다.\n");
                     }
                     else if(targetID ==null) {
                        //게임할 대상을 선택 안했을시
                        Text_Status.setText("게임을 할 대상을 선택해 주세요.\n");
                     }
                     else{
                        //상대방에게 게임요청
                        cc_thread.requestPlayGame(targetID); 
                     }                 
                     targetID=null;
            }else{
                  MessageBox msgBox = new  MessageBox(this, "로그온", "로그온 id를 입력하세요.");
                  msgBox.show();
            }
         }else if(b.getLabel().equals("로그아웃")){
               // 로그아웃 처리 루틴
        	 
        	 user.inputLastloginT(myID);// 닉네임을 받아와 종료시각 저장
            
             InetAddress local; //ip 저장하기
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
      
      
      //enter키로도 로그인 가능
      public void keyPressed(KeyEvent ke){
         myID = TextField_ID.getText(); // 로그온 ID를 읽는다.
         
         if(ke.getKeyChar() == KeyEvent.VK_ENTER){
            if(!myID.equals("")){
               cc_thread.requestLogon(myID); // ClientThread의 메소드를 호출
               
            }else{
               MessageBox msgBox = new  MessageBox(this, "로그온", "로그온 id를 입력하세요.");
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
      //게임하고 싶은 대상을 선택한다.
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