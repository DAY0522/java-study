package thread;

public class ThreadEx01 {
    public static void main(String[] args) {

        new AlphabetThread().start();

        for (int i = 1; i <= 9; i++) {
            System.out.print(i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        for (char c = 'a'; c <= 'z'; c++) {
//            System.out.print(c);
//        }
    }
}
