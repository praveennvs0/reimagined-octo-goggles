
public class MaxSum {

	public static void main(String args[]) {
		int[] arr = {1,1,-9,-9,100,-6} ;
		
		int maxGlobal = findmaxGlobal(arr,2) ;
		System.out.println("max sum is :" + maxGlobal) ;
	}

	private static int findmaxGlobal(int[] arr,int k) {
		// TODO Auto-generated method stub
		int maxLocal = 0;
		
		
		for(int i=0;i<k;i++) {
			maxLocal += arr[i] ;
		}
		
		int start=0;
		
		int end = k ,maxGlobal=maxLocal;
		while(start<=end && start < arr.length && end < arr.length) {
			
			int sum1 = maxLocal + arr[end] ;
			int sum2 = maxLocal+arr[end] - arr[start] ;
			
			
			if(sum1>sum2) {
				maxLocal = sum1;
				maxGlobal=Math.max(maxGlobal, maxLocal) ;
			}
			else {
				maxLocal = sum2;
				maxGlobal=Math.max(maxGlobal, maxLocal) ;
				start=start+1 ;
			}
				
			end++;
		}
		
		return maxGlobal;
	}
}
