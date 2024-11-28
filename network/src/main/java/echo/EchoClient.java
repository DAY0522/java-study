package echo;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class EchoClient {
    private static final String SERVER_IP = "192.168.0.30";

    public static void main(String[] args) {

        Socket socket = null;

        try {
            // 1. 소켓 생성
            socket = new Socket();

            // 2. 서버 연결
            socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));

            // 3. IO Stream 받아오기
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // 4. 쓰기
            String data = "Hello Workd";
            os.write(data.getBytes(StandardCharsets.UTF_8));

            // 5. 읽기
            byte[] buffer = new byte[256];
            int readByteCount = is.read(buffer);
            if (readByteCount == -1) {
                log(" closed by server");
                return;
            }

            data = new String(buffer, 0, readByteCount, "uft-8");
            System.out.println("[server] received:" + data);

            // 6. 데이터 쓰기
            os.write(data.getBytes(StandardCharsets.UTF_8));

        } catch (SocketException e) {
            System.out.println("[server] Socker Exception: " + e);
        } catch (IOException e) {
            log(" error: " + e);
        } finally {
            try {
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