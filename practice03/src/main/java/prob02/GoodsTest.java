package prob02;

import java.util.Scanner;

public class GoodsTest {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for (int i = 0; i < COUNT_GOODS; i++) {
			String info = scanner.nextLine();
			String[] s = info.split(" ");
			String name = s[0];
			int price = Integer.parseInt(s[1]);
			int stock = Integer.parseInt(s[2]);
			goods[i] = new Goods(name, price, stock);
		}

		// 상품 출력
		for (int i = 0; i < COUNT_GOODS; i++) {
			goods[i].printInfo();
		}

		scanner.close();
	}
}