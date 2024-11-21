package chapter03;

public class StaticMethod {
    int n;
    static int m;

    void f1() { // 인스턴스 메서드
        n = 10;
    }

    void f2() {
        m = 10;
    }

    void f3() {
        f2();
    }

    void f4() {
        StaticMethod.s2();

        s2();
    }

//    불가능
//    static void s1() {
//        n = 10;
//    }

    static void s2() {
        m = 10;
    }
}
