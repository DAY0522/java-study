package prob01;

public class Printer {
/*    public void println(int i) {
        System.out.println(i);
    }

    public void println(boolean b) {
        System.out.println(b);
    }

    public void println(double d) {
        System.out.println(d);
    }

    public void println(String s) {
        System.out.println(s);
    }*/

    public <T> void println(T t) { // <T>는 return type이 아님.
        System.out.println(t);
    }

    public <T> void println(T... ts) {
        for (T t : ts) {
            System.out.print(t + " ");
        }
        System.out.print("\n");
    }

    public int sum(Integer... nums) { // nums가 parameter를 배열로 받아옴
        int s = 0;
        for (Integer n : nums) {
            s += n;
        }
        return s;
    }
}
