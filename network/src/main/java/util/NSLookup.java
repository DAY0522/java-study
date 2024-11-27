package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String domain = scanner.next();

        InetAddress[] inetAddresses = null;
        try {
            inetAddresses = InetAddress.getAllByName(domain);
            for (InetAddress inetAddress : inetAddresses) {
                System.out.println(domain + " : " + inetAddress.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}