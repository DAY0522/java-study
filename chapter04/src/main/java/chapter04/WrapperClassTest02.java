package chapter04;

public class WrapperClassTest02 {
    public static void main(String[] args) {
        String s = "12345";
        int i = Integer.parseInt(s);

        String s2 = String.valueOf(i);

        String s3 = "" + i;
        System.out.println(s + ":" + s2 + ":" + s3);

        int a = Character.getNumericValue('A');
        System.out.println(a);

        char c = 'A';
        System.out.println((int) c);

        // 2진수
    }
}
