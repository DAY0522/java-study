package chapter04;

public class StringTest03 {
    public static void main(String[] args) {
//        String s1 = "Hello " + "World " + "Java" + 21;

        String s1 = new StringBuilder("Hello ")
                .append("World ")
                .append("Java ")
                .append(21)
                .toString();

        System.out.println(s1);

        String s2 = "";
        for (int i = 0; i < 1000000; i++) { // 시간이 오래 걸림.
//            s2 = s2 + "h"; // new StringBuffer(s2).append("h").toString(); 과 동일한 코드
        }

        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < 1000000; i++) {
            sb.append("h");
        }
        String s3 = sb.toString();

        // String method들...
        String s4 = "abcABCabcAbc";
        System.out.println(s4.length()); // 길이 구하기
        System.out.println(s4.charAt(2));
        System.out.println(s4.indexOf("ABC"));
        System.out.println(s4.indexOf("abc", 7));
        System.out.println(s4.substring(3));
        System.out.println(s4.substring(3, 5));

        String s5 = "   ab     cd   ";
        String s6 = "abc,def,gij";

        String s7 = s5.concat(s6);
        System.out.println(s7);

        System.out.println(s5.trim());
        System.out.println("---" + s5.replaceAll(" ", "") + "---");

        String[] tokens = s6.split(",");
        for (String s : tokens) {
            System.out.println(s);
        }
    }
}