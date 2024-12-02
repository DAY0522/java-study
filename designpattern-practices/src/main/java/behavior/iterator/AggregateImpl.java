package behavior.iterator;

public class AggregateImpl<E> implements Aggregate {

    private E[] datas = null;

    public AggregateImpl(E[] datas) {
        this.datas = datas;
    }

    @Override
    public Iterator<E> createIterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<E> {  // inner class -> datas에 접근하기 위해 inner class를 사용
        private int index = 0;
        @Override
        public E next() {
            return index < datas.length? datas[index++]: null;
        }

        @Override
        public boolean hasNext() {
            return index < datas.length;
        }

    }
}
