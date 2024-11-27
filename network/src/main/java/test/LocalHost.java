package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String hostName = inetAddress.getHostName();
            String hostIPAddress = inetAddress.getHostAddress();
            System.out.println(hostName);
            System.out.println(hostIPAddress);

            byte[] IPAddresses = inetAddress.getAddress();
            for (byte IPAddress : IPAddresses) {
                System.out.println(IPAddress & 0x000000ff);
                // IPAddress만 출력하는 경우에 각 숫자를 byte로 표현하면서 2의 보수로 변형 -> 음수가 출력됨.
            }

        } catch (UnknownHostException e) { // ip address가 없는 경우 반환
            e.printStackTrace();
        }
    }
}
