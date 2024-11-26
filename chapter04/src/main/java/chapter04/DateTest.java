package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);
        printDate01(now);
        printDate02(now);
    }

    private static void printDate02(Date now) {
        int year = now.getYear(); // +1900
        int month = now.getMonth(); // 0~11
        int date = now.getDate();
        int hours = now.getHours();
        int minuites = now.getMinutes();
        int seconds = now.getSeconds();

        System.out.println((year + 1900) + "-" +
                (month + 1) + "-" +
                date + " " +
                hours + ":" +
                minuites + ":" +
                seconds);
    }

    private static void printDate01(Date now) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(now);
        System.out.println(date);
    }
}
