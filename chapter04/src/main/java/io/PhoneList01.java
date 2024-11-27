package io;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            File file = new File("phone.txt");
            if (!file.exists()) {
                System.out.println("File Not Found");
                return;
            }

            System.out.println("== 파일정보 ==");
            System.out.println(file.getAbsolutePath()); // Full path
            System.out.println(file.length() + "bytes");
            System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));

            System.out.println("== 전화번호 ==");

            // 1. 기반스트림
            FileInputStream fis = new FileInputStream(file);

            // 2. 보조스트림1
            InputStreamReader isr = new InputStreamReader(fis);

            // 3. 보조스트림2
            br = new BufferedReader(isr);

            // 4. 처리
            String line = null;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "\t ");// delim: 분리자 "\t "는 \t(탭)이나 ' '으로 분리하는 것
                int index = 0;
                while (st.hasMoreElements()) {
                    String token = st.nextToken();
                    if (index == 0) { // 이름
                        System.out.print(token + ":");
                    } else if (index == 1) { // 전화번호1
                        System.out.print(token + "-");
                    } else if (index == 2) { // 전화번호2
                        System.out.print(token + "-");
                    } else { // 전화번호3
                        System.out.print(token + "\n");
                    }
                    index++;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
