package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class ServiceNow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {59,100,33};
		List<Integer> result  = createLargestNumber(nums) ;
		
		
	//	300 79 59 100 33 67 -INFINITY
	}

	// 59  49 69 20 ... 
	private static List<Integer> createLargestNumber(int[] nums) {
		List<Integer> result = new ArrayList<>();
		result.add(nums[0]);
		
		n * insert Element - result 
		
		n * O(log k) < n 
		
		
		int low = 0, high = nums.length-2, mid = low + (high-low)/2 ;
		
		for(int i=0;i<nums.length;i++) {

			if(compare(nums[i],result.get(0))== 1) {
				result.add(0,nums[i]);
				break;
				
			}
			else if (compare(nums[i],result.get(result.size()-1)) == -1) {
				result.add(nums[i]);
				break;
			}
			
			
		// insert each element of nums into sorted array
		while(low <= high) {
			if(compare(nums[i],result.get(mid)) == -1 && compare(nums[i],result.get(mid+1)) == 1) {
				
				result.add(mid+1,nums[i]);
			}
			else if (compare(nums[i],result.get(mid)) == 1 && compare(nums[i],result.get(mid-1)) == -1 ) {
				result.add(mid-1,nums[i]);
			}
			
			else if(nums[i] < result.get(mid) ) { // write a function for signifcation dits
				low = mid+1;
			}
			else {
				
				mid=high-1;
			}
			
		}
		
		
		}
		
		return result;
	}
	
	private static int compare(Integer num1,Integer num2) {
		
		if(num1 == num2)
			return 0;
		
		String str1 = num1.toString();
		String str2 = num2.toString();
		
		int small = Math.min(str1.length(), str2.length());
		int i=0;
		for( i=0; i < small ; i++) {
			if(str1.charAt(i) > str2.charAt(i)) {
				return 1 ;
			}
			else if ( str2.charAt(i) >  str1.charAt(i)) {
				return -1 ;
			}
			
			
		}
		
		
		// 39  394
		
		if(str1.length() > str2.length()) {
			return 1 ;
		}
		else {
			return -1;
		}
	}

	
	// 59  49 39 100  

}
