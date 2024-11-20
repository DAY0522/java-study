package prob04;
public class Sol04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);
		
		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}
	
	public static char[] reverse(String str) {
		int length = str.length();
		char[] c1 = new char[length];
		for (int i = length - 1; i >= 0; i--) {
			c1[(length-1)-i] = str.charAt(i);
		}
		return c1;
	}

	public static void printCharArray(char[] array){
		System.out.println(array);
	}
}