package chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class ChatServerThread extends Thread{
    private Socket socket;
    private List<Writer> listWriters;
    private String nickname;

    public ChatServerThread(Socket socket, List<Writer> listWriters) {
        this.socket = socket;
        this.listWriters = listWriters;
    }

    @Override
    public void run() {
        try {
            System.out.println("run 실행");

            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

            while (true) {
                String request = br.readLine();
                if (request == null) {
                    log("클라이언트로부터 연결 끊김.");
                    break;
                }

                String[] tokens = request.split(":");
                if ("join".equals(tokens[0])) {
                    doJoin(tokens[1], pw);
                    System.out.println("doJoin: " + tokens[1]);
                } else if ("message".equals(tokens[0])) {
                    doMessage(tokens[1]);
                    System.out.println("message: " + tokens[1]);
                } else if ("quit".equals(tokens[0])) {
                    doQuit(pw);
                } else {
                    ChatServer.log("error: unknown request(" + tokens[0] + ")");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doQuit(Writer writer) {
        PrintWriter pw = (PrintWriter) writer;
        removeWriter(pw);

        String data = nickname + "님이 퇴장했습니다.";
        broadcast(data);
    }

    private void doMessage(String message) {
        broadcast(nickname + ": " + message);
    }

    private void doJoin(String nickname, Writer writer) {
        this.nickname = nickname;

        String data = nickname + "님이 참여했습니다.";
        broadcast(data);

        // writer pool에 저장
        PrintWriter pw = (PrintWriter) writer;
        addWriter(pw);

        // ack
        pw.println("join:ok");
        pw.flush();
    }

    public void log(String str) {
        System.out.println(str);
    }

    private void addWriter(PrintWriter pw) {
        synchronized (listWriters) {
            listWriters.add(pw);
        }
    }

    private void removeWriter(PrintWriter pw) {
        synchronized (listWriters) {
            listWriters.remove(pw);
        }
    }

    private void broadcast(String data) {
        synchronized (listWriters) {
            for (Writer writer : listWriters) {
                PrintWriter printWriter = (PrintWriter) writer;
                printWriter.println(data);
                printWriter.flush();
            }
        }
    }
}
