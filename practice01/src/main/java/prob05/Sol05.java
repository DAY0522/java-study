package prob05;

public class Sol05 {
	public static void main(String[] args) {

		for(int i = 1; i<=100; i++) {
			int current = i;
			while(current>0){
				int remain = current % 10;
				current /= 10;

				if (remain == 3 || remain == 6 || remain == 9) {
					System.out.println(i + " 짝");
					break;
				}
			}
		}
	}
}