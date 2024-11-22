package prob04;

public class MyStack {
	private int top;
	private String[] buffer;

	public MyStack(int capacity) {
        top = -1;
        buffer = new String[capacity];
	}

	public void push(String s) {
		/* 구현하기 */
        top += 1;
        if (top >= buffer.length) { // stack is full
            resize();
        }
        buffer[top] = s;
	}

	public String pop() throws MyStackException {
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

	private void resize() {
		/* 구현하기 */
        String[] new_buffer = new String[top+1];
        for (int i = 0; i < buffer.length; i++) {
            new_buffer[i] = buffer[i];
        }
        buffer = new_buffer;
	}
}