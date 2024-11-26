package behavioral.iterator;

public interface Iterator<E> {
    E next(); // 다음 인자가 무엇인가
    boolean hasNext();
}
