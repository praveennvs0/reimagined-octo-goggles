
public class BinarySearch {

	public static void main(String args[]) {

		int a[] = { 1, 2, 3, 10, 9, 8, 7, 6, 4, 3, 2, 1 };
		// int index = findIndex(a);
		printArray(a);

		int index = findIndexBinarySearch(a, 0, a.length - 1);
		System.out.println(index);
	}

	private static void printArray(int[] a) {

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			System.out.print(",");
		}
		System.out.println("");
	}

	public static int findIndexBinarySearch(int[] a, int low, int high) {
		int mid = (low + high) / 2;

		if (a[mid - 1] < a[mid] && a[mid + 1] < a[mid])
			return mid;

		else if (a[mid + 1] < a[mid])
			return findIndexBinarySearch(a, low, mid - 1);
		else
			return findIndexBinarySearch(a, mid + 1, high);

	}
}
