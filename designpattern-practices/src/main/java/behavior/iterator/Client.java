package behavior.iterator;

public class Client {
    public static void main(String[] args) {
        Aggregate<String> fruits = new AggregateImpl<>(new String[]{"Mango", "Banana", "Apple"});
        Iterator<String> iterator = fruits.createIterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
        }
    }
}
