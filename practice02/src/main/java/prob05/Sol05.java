package prob05;

public class Sol05 {
	public static void main(String[] arg) {

		int array[] = {5, 9, 3, 8, 60, 20, 1};
		int count = array.length;

		System.out.println("Before Sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}

		bubbleSort(array);

		System.out.println("\nAfter Sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}
	}

	static void bubbleSort(int[] arr) {
		int length = arr.length;
		for (int i = length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[j + 1]) { // 더 작은 걸 뒤로
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}