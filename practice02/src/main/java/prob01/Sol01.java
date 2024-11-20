package prob01;

import java.util.Scanner;

public class Sol01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int[] MONEYS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};

		System.out.print("금액 : ");
		int money = scanner.nextInt();
		for (int i=0; i<MONEYS.length; i++){
			int current = MONEYS[i];
			int count = 0;
			while (money - current >= 0) {
				count += 1;
				money -= current;
			}
			System.out.println(current + "원 : " + count + "개");
		}
		
		scanner.close();
 	}
}