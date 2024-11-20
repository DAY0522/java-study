package prob06;

import java.util.Random;
import java.util.Scanner;

public class Sol06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while(true) {
			
			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt(100) + 1;

			int round = 1;
			int min = 1;
			int max = 100;
			System.out.println("수를 결정하였습니다. 맞추어 보세요.");
			while (true) {
				System.out.println(min + "-" + max);
				System.out.print(round + ">>");
				int answer = scanner.nextInt();
				if (answer == correctNumber) {
					System.out.println("맞췄습니다.");
					break;
				} else if (answer < correctNumber) {
					System.out.println("더 높게");
					min = answer;
				} else {
					System.out.println("더 낮게");
					max = answer;
				}
				round += 1;
			}

			//새 게임 여부 확인하기
			System.out.print("다시 하겠습니까(y/n)>>");
			String answer = scanner.next();
			if("y".equals(answer) == false) {
				break;
			}
		}
		
		scanner.close();
	}
}