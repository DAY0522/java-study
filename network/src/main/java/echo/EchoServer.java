package echo;

import thread.EchoRequestHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
    public static final int PORT = 60000;

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT)); // hostname: 나에게 송신할 수 있는 IP
            log("starts... [port:" + PORT + "]");

            while (true) {
                Socket socket = serverSocket.accept(); // blocking, 데이터 통신용 소켓
                new EchoRequestHandler(socket).start();
            }
        } catch (IOException e) {
            log("error: " + e);
        } finally {
            try {
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void log(String message) {
        System.out.println("[Echo Server] " + message);
    }
}