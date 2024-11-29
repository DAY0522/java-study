package chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_IP = "192.168.0.30";

    public static void main(String[] args) {
        Scanner scanner = null;
        Socket socket = null;
        PrintWriter pw = null;
        BufferedReader br = null;

        try {
            socket = new Socket();
            scanner = new Scanner(System.in);

            // 서버 연결
            socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));

            // reader/writer 생성
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

            // join
            System.out.print("닉네임>>");
            String nickname = scanner.nextLine();
            pw.println("join:" + nickname);
            pw.flush();

            String ack = br.readLine();
            if ("join:ok".equals(ack)) {
                System.out.println("채팅방에 입장했습니다.");
            }

            new ChatClientThread(socket).start();

            while (true) {
                String input = scanner.nextLine();

                if ("quit".equals(input) == true) {
                    // quit 프로토콜
                    pw.println("quit");
                    break;
                } else {
                    // 메시지 처리
                    pw.println("message:" + input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (scanner != null) {
                    scanner.close();
                }
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
