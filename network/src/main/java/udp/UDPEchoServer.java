package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {

    public static final int PORT = 50001; // 나중에 echo 서버랑 같이 띄워보기
    public static final int BUFFER_SIZE = 256;

    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(PORT);

            while (true) {
                DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
                socket.receive(rcvPacket);

                byte[] rcvData = rcvPacket.getData();
                int offset = rcvPacket.getLength();

                String message = new String(rcvData, 0, offset, "UTF-8");
                System.out.println("[UDP Echo Server] received: " + message);

                // 3. 데이터 송신
                byte[] sndData = message.getBytes("UTF-8");

                DatagramPacket sndPacket = new DatagramPacket(
                        sndData,
                        sndData.length,
                        rcvPacket.getAddress(),
                        rcvPacket.getPort()
                );

                socket.send(sndPacket);
            }
        } catch (SocketException e) {
            System.out.println("[UDP Echo Server] error: " + e);
        } catch (IOException e) {
            System.out.println("[UDP Echo Server] error: " + e);
        } finally {
            socket.close();
        }


    }
}
