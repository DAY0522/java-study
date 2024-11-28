package thread;

public class DigitThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.print(i);
        }
    }
}