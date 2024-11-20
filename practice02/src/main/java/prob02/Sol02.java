package prob02;

import java.util.Scanner;

public class Sol02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];
		double sum = 0;

		double length = (double) intArray.length;
		System.out.println((int)length + "개의 숫자를 입력하세요.");
		for (int i = 0; i < length; i++) {
			double number = scanner.nextDouble();
			sum += number;
		}
		System.out.println("평균은 " + sum/length + "입니다.");
		scanner.close();
	}
}
