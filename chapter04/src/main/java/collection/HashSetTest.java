package collection;

import java.util.*;

public class HashSetTest {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();

        s.add("둘리");
        s.add("마이콜");
        s.add("도우너");
        String str = new String("마이콜");
        s.add(str);

        System.out.println(s.size());
        System.out.println(s.contains("마이콜"));
        System.out.println(s.contains(str));

        for (String str2 : s) {
            System.out.println(str2);
        }
    }
}