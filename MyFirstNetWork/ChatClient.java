package chat_whisper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.JButton;

public class ChatClient {

    String serverAddress;
    Scanner in;
    PrintWriter out;

    JFrame frame = new JFrame("Chatter");
    JPanel textingPanel = new JPanel();
    JButton button = new JButton("Whisper");

    JTextField textField = new JTextField(50);
    JTextArea messageArea = new JTextArea(16, 50);

    private int port_num;

    public static void main(String[] args) throws Exception {

        Scanner inputstream = null;
        String serverAddress = null;
        int port_num = 0;
        try {
            inputstream = new Scanner(new File("serverInfo.dat"));
            serverAddress = inputstream.next();
            port_num = inputstream.nextInt(); //서버인포 텍스트에서 서버어드레스랑 포트 넘버 입력 받음
        }
        catch(FileNotFoundException e)
        {
            serverAddress = "127.0.0.1";
            port_num = 5900; //파일이 없을 때는 디폴트값 지정
        }

        ChatClient client = new ChatClient(serverAddress,port_num); //클라이언트 선언하고
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //끄면 닫는다
        client.frame.setVisible(true);// 보이게 해주고
        client.connet(); //실행한다

    }

    private void connet() throws IOException {
        try {
            Socket socket = new Socket(serverAddress, port_num); //소켓
            in = new Scanner(socket.getInputStream()); //입력 스트림 생성
            out = new PrintWriter(socket.getOutputStream(), true); //출력 스트림 생성

            while (in.hasNextLine()) {
                String line = in.nextLine(); //인풋스트림에서 입력한 문장을 line에 담고
                if (line.startsWith("SUBMITNAME")) {
                    out.println(getName()); //만약 submitname 으로 시작하면 getname에서 받았던 이름을 아웃으로 출력

                } else if (line.startsWith("NAMEACCEPTED")) { //서버에서 받아줬을 때, 허락해줬을 때
                    this.frame.setTitle("Chatter - " + line.substring(13)); //chatter - name 형식으로 타이틀을 정하고
                    textField.setEditable(true); //textField 활성화

                } else if (line.startsWith("MESSAGE")) { // 서버에서 MESSAGE를 전송했을 때
                    messageArea.append(line.substring(8) + "\n"); //메세지로 시작하면 메세지area에 출력
                }

                else if(line.startsWith("/w"))
                {
                    messageArea.append(line.substring(8) + "\n");
                }

            }
        } finally {
            frame.setVisible(false);
            frame.dispose();
        }
    }


    public ChatClient(String serverAddress, int port_num) {
        this.serverAddress = serverAddress;
        this.port_num = port_num;

        textField.setEditable(false);
        messageArea.setEditable(false);
        textingPanel.add(button);
        textingPanel.add(textField);
        frame.getContentPane().add(textingPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(new JScrollPane(messageArea), BorderLayout.CENTER);
        frame.pack();  //모든 GUI들 선언해줌

        // Send on enter then clear to prepare for next message
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // enter 키가 눌리면
                out.println(textField.getText()); // 메세지를 보내고
                textField.setText(""); // text field 비움.
            } //만약에 텍스트필드에 입력하면 생기는 일들을 액션 리스너로 정의
        });
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = null;
                name = "/w "+ Whisper_person();
                textField.setText(name);
            } //버튼을 누르면 생기는 일들을 액션 리스너로 정의 -> whisper할 상대의 이름을 치는 GUI가 뜸
        });
    }

    private String getName() {
        return JOptionPane.showInputDialog(
                frame,
                "Choose a screen name:",
                "Screen name selection",
                JOptionPane.PLAIN_MESSAGE
        ); //이름 입력받는 창
    }

    private String Whisper_person() {
        return JOptionPane.showInputDialog(
                frame,
                "Choose a name you want to whisper:",
                "Whisper name selection",
                JOptionPane.PLAIN_MESSAGE
        ); //속삭일 사람 입력받는 창
    }

}
