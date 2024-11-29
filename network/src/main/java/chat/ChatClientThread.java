package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {
    Socket socket = null;

    public ChatClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

            String data;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }
        } catch (SocketException e) {
            System.out.println("퇴장했습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
