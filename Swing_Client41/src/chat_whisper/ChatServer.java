
package chat_whisper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ChatServer {

    // All client names, so we can check for duplicates upon registration.
    private static Set<String> names = new HashSet<>();

    // The set of all the print writers for all the clients, used for broadcast.
    private static Set<PrintWriter> writers = new HashSet<>();

    static HashMap<String, PrintWriter> user = new HashMap<String, PrintWriter>();

    public static void main(String[] args) throws Exception {
        Scanner inputstream = null;
        String serverAddress = null;
        int port_num = 0;

        try {
            inputstream = new Scanner(new File("serverInfo.dat")); //서버인포 파일에서 서버 어드레스랑 포트넘버 받아옴
            serverAddress = inputstream.next();
            port_num = inputstream.nextInt();
        } catch (FileNotFoundException e) {
            serverAddress = "127.0.0.1";
            port_num = 5900; //이거는 파일 없을때 디폴트 값
        }

        System.out.println("The chat server is running...");
        ExecutorService pool = Executors.newFixedThreadPool(500);
        try (ServerSocket listener = new ServerSocket(port_num)) {
            while (true) {
                pool.execute(new Handler(listener.accept(), user)); //소켓 여러개 만들어서 연결하느 ㄴ소켓 계속 만들어주기
            }
        }
    }


    private static class Handler implements Runnable {
        private String name;
        private Socket socket;
        private Scanner in;
        private PrintWriter out;
        private HashMap<String, PrintWriter> user;

        public Handler(Socket socket, HashMap<String, PrintWriter> user) {
            this.socket = socket;
            this.user = user; //소켓과 user 내용 셋해주기

        }


        public void run() {
            try {
                in = new Scanner(socket.getInputStream()); // 입력 스트림 생성
                out = new PrintWriter(socket.getOutputStream(), true); // 출력 스트림 생성

                // Keep requesting a name until we get a unique one.
                while (true) {
                    out.println("SUBMITNAME");
                    name = in.nextLine(); // 이름 입력
                    if (name == null) {
                        return;
                    } //이름이 null이면 안되고, 이름 입력하라고 창을 띄우고 name에 친 이름을 담는다

                    synchronized (names) { // 여러 thread가 동시에 접근하지 못하게 함.
                        if (name.length() > 0 && !names.contains(name)) { // 이름의 길이 확인 & 중복 체크
                            names.add(name);

                            synchronized (user) {
                                user.put(name, out);
                            }
                            break; //그리고 해쉬셋과 해쉬맵에 해당되는 이름들을 저장해둔다
                        }
                    }
                }

                // Now that a successful name has been chosen, add the socket's print writer
                // to the set of all writers so this client can receive broadcast messages.
                // But BEFORE THAT, let everyone else know that the new person has joined!
                out.println("NAMEACCEPTED " + name);

                for (PrintWriter writer : writers) { // 다른 client가 채팅방에 접속했을 시에 기존 client에게 알려줌.
                    writer.println("MESSAGE " + name + " has joined");
                    System.out.println(name + " is joined");
                } //이름이 입력되면 톡방에 들어온거니까 들어왔다고 표현해주고
                writers.add(out); //더해준다


                // Accept messages from this client and broadcast them.
                while (true) {
                    String input = in.nextLine();

                    if (input.toLowerCase().startsWith("/quit")) { // client가 접속 해제 요청하는 경우
                        return;
                    } else if (input.startsWith("/w")) { // client가 whisper를 요청했을 경우
                        whisper(input,name);
                    } else { //아니면 모든 사용자에게 말하는 그냥 채팅방이므로 그냥 출력해주면 됨
                        for (PrintWriter writer : writers) {
                            writer.println("MESSAGE " + name + ": " + input);
                        }
                    }
                }
            } catch (NullPointerException e) { //exception 처리
                System.out.println(e.getMessage());
            } catch (Exception e){ //exception 처리

            } finally { // client 접속 해제 시
                if (out != null) {
                    writers.remove(out); // client 제거
                }
                if (name != null) {
                    System.out.println(name + " is leaving");
                    names.remove(name); // 이름 제거
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + " has left"); //사용자 나갔다고 알려주기
                    }
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }



    private static void whisper(String message, String name) throws IOException { //whisper 함수 만들어줌
        int begin = message.indexOf(" ") + 1; //처음 공백 문자 다음부터
        int end = message.indexOf(" ", begin);  //두번째 공백 문자 사이의 문자가 아이디이므로 따로 잘라서 저장

        if (end != -1) {
            String id = message.substring(begin, end); //아이디만 저장
            String msg = message.substring(end + 1); // 그 뒷부분은 보내고 싶은 메세지임

            if (user.containsKey(id)) //만약에 해당되는 아이디가 있으면
            {
                PrintWriter ToUser = user.get(id);
                ToUser.println("MESSAGE " + name + " sends : " + msg);
                ToUser.flush(); //메세지를 그 아이디에 해당하는 사람한테 출력하고
            }
            else
                System.out.println("Unknown user : " + id); //아니면 모르눈 사람이라고 디펜시브코딩
        }
    }



}
