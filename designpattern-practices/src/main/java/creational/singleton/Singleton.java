package creational.singleton;

public class Singleton {
    private static Singleton instance = null;
    private Singleton(){
    }

    public static Singleton getInstance() {
        if (instance == null) { // 최초 1회만 객체 생성
            instance = new Singleton();
        }

        return instance;
    }
}
