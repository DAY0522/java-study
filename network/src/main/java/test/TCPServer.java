package test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // 1. 서버 소켓 생성
            serverSocket = new ServerSocket();

            // 2. 바인딩(binding)
            //    Socket에 InetSockerAddress[InetAddress(IPAddress) + port]
            //    IPAddress: 0.0.0.0 (모든 IP를 바인딩, 특정 호스트 IP를 바인딩 하지 않는다)
            serverSocket.bind(new InetSocketAddress("0.0.0.0", 50000)); // hostname: 나에게 송신할 수 있는 IP

            // 3. accept
            Socket socket = serverSocket.accept(); // blocking, 데이터 통신용 소켓

            System.out.println("연결 성공"); // 터미널에서 telnet 192.168.0.30 50000 입력

            // 4. IO Stream 받아오기
            InputStream is = socket.getInputStream();

            // 5. 데이터 읽기
            byte[] buffer = new byte[256];
            int readByteCount = is.read(buffer);
            if (readByteCount == -1) {
                // closed by client
                System.out.println("[server] closed by client");
                return;
            }

            String data = new String(buffer, 0, readByteCount, "utf-8");
            System.out.println("[server] receive: " + data);

        } catch (IOException e) {
            System.out.println("[server] error: " + e);
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
}
