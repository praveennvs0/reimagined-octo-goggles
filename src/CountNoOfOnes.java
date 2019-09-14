
public class CountNoOfOnes {

	public static void main(String args[]) {
		int[] a = {1, 1, 1, 0, 0, 1, 0, 1, 1};
		int Q[] = {0, 1, 2, 4 };
		printNoOfOnesInTheArray(a, Q);
	}

	public static void printNoOfOnesInTheArray(int[] a, int[] Q) {
		int[] ones = printNoOfOnes(a, Q);
		for (int i = 0; i < Q.length; i++) {
			System.out.println("no. of ones is before index :  " + Q[i] + "  is :  " + ones[Q[i]]);

		}
	}

	public static int[] printNoOfOnes(int[] a, int[] Q) {
		int[] ones = new int[a.length];
		ones[0] = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] == 1)
				ones[i] = ones[i - 1] + 1;
			else
				ones[i] = ones[i - 1];
		}
		return ones;

	}
}
