package newPackage;

public class FirstIndexAndLength {

	public static void main(String[] args) {
		
		int[] arr = {2,2,3,3,3,3,3,6,6,7,7};
		int[] result = maxLength(arr);
		System.out.println("length of the longest repeating sequence is : " + result[0]) ;
		System.out.println("index of the longest repeating sequence is : " + result[1]) ;
		
	}

	private static int[] maxLength(int[] arr) {
		int[] result = new int[2];
		int currLen = 0, maxLength = 0,index=0;
		for(int i=0; i < arr.length-1 ; i++) {
			if(arr[i+1] == arr[i] ) {
				currLen++;
			}
			else {
				if(currLen > maxLength) {
					maxLength = currLen ;
					index = i+1-currLen;
				}
				
				currLen = 1;
				
			}
		}
		
		if(currLen > maxLength) {
			maxLength = currLen;
			index = arr.length-currLen;
		}
		result[0] = maxLength;
		result[1] = index;
		return result;
	}
}
