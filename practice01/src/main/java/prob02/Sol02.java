package prob02;

public class Sol02 {
	public static void main(String[] args) {
		
		/* 코드 작성 */
		for(int i=0; i<=8; i++){
			for (int j = 1; j <= 10; j++) {
				System.out.print(j + " ");
			}

			for (int j=1; j<=i; j++){
				System.out.print((j+10)+" ");
			}
			System.out.println();
		}
	
	}
}