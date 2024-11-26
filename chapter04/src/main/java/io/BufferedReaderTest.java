package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            // 기반 스트림
            FileReader fr = new FileReader("./chapter04/src/main/java/io/BufferedReaderTest.java");

            // 보조 스트림
            br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + e);
        } catch (IOException e) {
            System.out.println("error: " + e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("error: " + e);
                }
            }
        }
    }
}
