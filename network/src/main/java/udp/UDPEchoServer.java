package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {

    public static final int PORT = 50001; // 나중에 echo 서버랑 같이 띄워보기
    public static final int BUFFER_SiZE = 256;

    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(PORT);

            while (true) {
                DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SiZE], BUFFER_SiZE);
                socket.receive(rcvPacket);

            }
        } catch (SocketException e) {
            System.out.println("[UDP Echo Server error] : " + e);
        } catch (IOException e) {
            System.out.println("[UDP Echo Server error] : " + e);
        } finally {
            socket.close();
        }


    }
}