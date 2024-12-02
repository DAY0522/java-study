package echo;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
    private static final String SERVER_IP = "192.168.0.30";

    public static void main(String[] args) {

        Scanner scanner = null;
        Socket socket = null;

        try {
            // 1. 소켓 생성
            try {
                socket = new Socket();
                scanner = new Scanner(System.in);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            // 2. 서버 연결
            socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));

            // 3. IO Stream 받아오기
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

            while (true) {
                System.out.print(">>");
                String line = scanner.nextLine();

                if ("exit".equals(line)) {
                    break;
                }
                pw.println(line);
                String data = br.readLine();
                if (data == null) {
                    log("closed by server");
                    break;
                }
                System.out.println("<<" + data);
            }
        } catch (SocketException e) {
            System.out.println("[server] Socket Exception: " + e);
        } catch (IOException e) {
            log(" error: " + e);
        } finally {
            try {
                if(scanner != null) {
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

    public static void log(String message) {
        System.out.println("[Echo client] " + message);
    }
}
