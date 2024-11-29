package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    public static final int PORT = 50000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        List<Writer> listWriters = new ArrayList<Writer>();

        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
            log("starts... [port:" + PORT + "]");

            while (true) {
                socket = serverSocket.accept(); // client 소켓 받아오기
                new ChatServerThread(socket, listWriters).start(); // thread start
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
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
        System.out.println(message);
    }
}
