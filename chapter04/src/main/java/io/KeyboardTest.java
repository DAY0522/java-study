package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardTest {
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            // 1. 기반(주)스트림 (표준 입력, stdin, System.in, JVM이 만들어 줌)

            // 2. 보조스트림(byte|bute|bute -> char)
            InputStreamReader isr = new InputStreamReader(System.in, "utf-8");

            // 3. 보조스트림(char1|char2|char3|\n -> :"char1char2char3")
            br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                if ("quit".equals(line)) {
                    break;
                }
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("error: " + e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
