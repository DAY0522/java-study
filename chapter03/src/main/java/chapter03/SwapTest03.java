package chapter03;

public class SwapTest03 {
    public static void main(String[] args) {
        Value i = new Value(10);
        Value j = new Value(20);

        System.out.println(i.value + ", " + j.value);
        swap(i, j);
        System.out.println(i.value + ", " + j.value);
    }

    private static void swap(Value m, Value n) {
        int temp = m.value;
        m.value = n.value;
        n.value = temp;
    }
}
