
public class SecondLargestElementInAnArray {
	public static void main(String[] args) {
		int[] array = {4,5,1,3,2};
		int x = findSecondLargest(array);
		System.out.println("The second largest element in the array is : " + x);
	}

	private static int findSecondLargest(int[] array) {
		int largest = 0,secondLargest=0;
		for(int i=0;i<array.length;i++) {
			if(array[i] > largest) {
				secondLargest = largest;
				largest = array[i];
				
			}
			else if(array[i] > secondLargest && array[i] < largest) {
				secondLargest = array[i];
			}
			
		}
		
		
		return secondLargest;
	}

}
