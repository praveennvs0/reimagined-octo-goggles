public class MinValueToAdd {
	public static void main(String args[]) {
		int[] a = { 6, 7,3 ,12};
		//int[] a= {7,3};
		int k = getMinValueToAdd(a);
		System.out.println("Min value to add is " + k);
	}

	public static int getMinValueToAdd(int[] a) {
		int[] prefixSumArray = new int[a.length];
		int currentSum = 0;
		for (int i = 0; i < a.length; i++) {
			currentSum = currentSum + a[i];
			prefixSumArray[i] = currentSum;
		}
		int k = Integer.MAX_VALUE, totalSum;
		boolean isFound = false;
		totalSum = prefixSumArray[prefixSumArray.length - 1];
		for (int i = 0; i < a.length && prefixSumArray[i] <= totalSum / 2; i++) {
			int left = prefixSumArray[i];
			int right = totalSum - prefixSumArray[i];
			int diff = right - left;
			k = Math.min(k, diff);
			isFound = true;

		}

		if (isFound)
			return k;
		else
			return -1;

	}

}