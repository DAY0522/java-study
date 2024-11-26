package chapter04;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {
    public static void main(String[] args) {
//        Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
//        TimeZone tz = TimeZone.getDefault();
//        System.out.println(aLocale + ":" + tz);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2024);
        cal.set(Calendar.MONTH, 11); // 12월-1
        cal.set(Calendar.DATE, 25);
        System.out.println(cal);
        printDate(cal);

        cal.set(2021, 7, 10);
        cal.add(Calendar.DATE, 2000);
        printDate(cal);
    }

    private static void printDate(Calendar cal) {
        final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);
        int day = cal.get(Calendar.DAY_OF_WEEK); // 1(일)~7(토)까지 나옴
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        System.out.println(year + "-" +
                (month + 1) + "-" +
                date + " " +
                DAYS[day-1] + "요일 " +
                hour + ":" +
                minute + ":" +
                second);
    }
}
