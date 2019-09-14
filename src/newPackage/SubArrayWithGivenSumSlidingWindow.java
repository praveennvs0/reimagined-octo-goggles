package newPackage;

public class SubArrayWithGivenSumSlidingWindow {

	public static void main(String args[]) {
		int[] arr = {1, 4, 20, 3, 10, 5};
		int sum = 33 ;
	//	printSubArrayWithGivenSum(arr,sum) ;
		slidingWindow(arr,sum);
	}

	private static void printSubArrayWithGivenSum(int[] arr, int sum) {
		int start=0,end=0,currentSum ;
		boolean isFound = false ;
		for(int i=0;i<arr.length;i++) {
			currentSum = arr[i];
			for(int j=i+1;j<arr.length;j++) {
				currentSum = currentSum + arr[j];
				if(currentSum == sum) {
					start = i ;
					end = j;
					isFound = true ;
				}
					
			}
		}
		
		if(isFound) {
			System.out.println("Subarray found from index " +start +" and " + end ) ;
		}
		else {
			System.out.println("No subarray found") ;
		}
			
	}
	
	private static void slidingWindow(int[] arr,int sum) {
		int left=0, right =0, currentSum=0;
		boolean isFound = false ;
		while(left <= right && right < arr.length ) {
			
			if(currentSum==sum) {
				isFound = true ;
			
				break;
			}
			else if(currentSum < sum) {
				currentSum = currentSum + arr[right] ;
				right++ ;
			}
			else {
				int tempLeft = left ;
				while(currentSum > sum) {
				currentSum = currentSum - arr[tempLeft] ;
				tempLeft++;
				}
				left = tempLeft ;
			}
		}
		
		//Sometimes, the desirable subarray(obtained after adding one element to the current sum in the second condition)
		//may end with the last element. since we did right++, it won't go into the while loop
		//again and check for currentSum==sum. 
		if(currentSum==sum) {
			isFound = true ;
			int rightIndex = right-1;
			System.out.println("Subarray found from index " + left + " and " + rightIndex) ;
			display(arr,left,rightIndex);
		}
			
		
		if(!isFound) {
			System.out.println("No subarray found") ;
		}
	}

	private static void display(int[] arr, int left, int right) {
		System.out.println();
		for(int i=left;i<=right;i++) {
			System.out.print(arr[i]+":");
		}
	}
}
