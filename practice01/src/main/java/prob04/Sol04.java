package prob04;

import java.util.Scanner;

public class Sol04 {

	public static void main(String[] args) {

		System.out.print("문자열을 입력하세요: ");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		for (int i = 1; i <= str.length(); i++) {
			System.out.println(str.substring(0, i));
		}

		scanner.close();
	}
}