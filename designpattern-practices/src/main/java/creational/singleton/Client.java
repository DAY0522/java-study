package creational.singleton;

public class Client {
    public static void main(String[] args) {

        // 객체를 하나로 유지
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
