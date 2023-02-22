package DataStructures;

import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		
		
		int[] A = {4,1,4,1};
		int count = findMinSteps(A,A.length);
		System.out.println(count);
	}

	  public static int solution(int[] A) {
	        // write your code in Java SE 8
	        int n = A.length; 
	        int minSteps = findMinSteps(A,n);
	        return minSteps;
	    }

	    private static int findMinSteps(int[] A,int n) {
	        int count = 0;
	        Arrays.sort(A);
	        int mid = A[n/2];
	        

	        for(int i=0;i<n;i++) 
	            count = count + Math.abs(A[i]-mid);

	            if(n%2 == 0) {
	                int temp = 0;
	                mid = A[(n/2)-1];
	                for(int i=0;i<n;i++) {
	                    temp += Math.abs(A[i]-mid);

	             count = Math.min(count,temp);                    
	                }
	            }

	            return count;
	        }
}
