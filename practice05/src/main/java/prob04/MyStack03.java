package prob04;

public class MyStack03<T> {
	private int top;
	private T[] buffer;

	public MyStack03(int capacity) {
        top = -1;
        buffer = (T[]) new Object[capacity];
	}

	public void push(T s) {
		/* 구현하기 */
        top += 1;
        if (top >= buffer.length) { // stack is full
            resize();
        }
        buffer[top] = s;
	}

	public T pop() throws MyStackException {
		/* 구현하기 */
        if (!isEmpty()) { // 비어있지 않은 경우
            top -= 1;
            return buffer[top + 1];
        }

        // stack이 빈 경우
        throw new MyStackException("stack is empty");
	}

	public boolean isEmpty() {
		/* 구현하기 */
        if (top >= 0) {
            return false;
        }
		return true;
	}

    @SuppressWarnings("unchecked")
	private void resize() {
		/* 구현하기 */
        T[] new_buffer = (T[]) new Object[top+1];
        for (int i = 0; i < buffer.length; i++) {
            new_buffer[i] = buffer[i];
        }
        buffer = new_buffer;
	}
}