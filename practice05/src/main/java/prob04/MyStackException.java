package prob04;

public class MyStackException extends Exception{
    public MyStackException() {
        super("MyStackException 발생");
    }

    public MyStackException(String s) {
        super(s);
    }
}
