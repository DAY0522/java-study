package prob03;

import java.util.Scanner;

public class Sol03 {
	
	public static void main(String[] args) {

		while(true) {
			System.out.print("수를 입력 하세요: ");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.next();
			if (input.equals("exit")) {
				System.out.println("종료합니다.");
				break;
			}

			int number = Integer.valueOf(input);
			int sum = 0;
			for (int i = number; i > 0; i -= 2) {
				sum += i;
			}
			System.out.println("결과값: " + sum);
		}
	}
}
