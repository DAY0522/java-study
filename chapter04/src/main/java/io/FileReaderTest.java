package io;

import java.io.*;

public class FileReaderTest {
    public static void main(String[] args) {
        Reader in = null;
        InputStream is = null;
        try {
            in = new FileReader("test.txt");
            is = new FileInputStream("test.txt");

            int count = 0;
            int data = -1;
            while ((data = in.read()) != -1) {
                System.out.print((char) data);
                count++;
            }
            System.out.println();
            System.out.println("count: " + count);
            System.out.println("=========================");

            count = 0;
            data = -1;
            while ((data = is.read()) != -1) {
                System.out.println((char) data);
                count++;
            }
            System.out.println();
            System.out.println("count: " + count);
        } catch (FileNotFoundException e) {
            System.out.println("fine not found: " + e);
        } catch (IOException e) {
            System.out.println("error: " + e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
