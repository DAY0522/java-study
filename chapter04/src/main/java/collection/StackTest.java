package collection;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();

        s.push("둘리");
        s.push("마이콜");
        s.push("또치");

        while (!s.isEmpty()) {
            String str = s.pop();
            System.out.println(str);
        }
    }
}
