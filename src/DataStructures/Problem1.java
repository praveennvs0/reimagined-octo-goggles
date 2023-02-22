package DataStructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1 {
	// -2 ,0, 1 ,2    1,0,2,-2   

	public static void findCombinations(int[] nums,int index, List<Integer> combination,int k,int sum, List<List<Integer>> result,
			Set<String> set) { 
		
		if(index >= nums.length) {
			return ;
		}
		
		if(combination.size() > k ) {
			return ;
		}
		
		if (combination.size() == k) {
			if(sum == 0) {
				System.out.println("Combination found");
				result.add(combination) ;
				
			}
			return ;
		}
		
		for(int i=index;i<nums.length;i++) {
			combination.add(nums[i]);
			findCombinations(nums,i+1,combination,k,sum-nums[i],result,set);
			
			if (combination.size() > 0) {
			combination.remove(combination.size()-1);
			}
			
			
		}
		
		
	}
	 // 1 2 3 4 5 6 7 
	
	
	
	
	public static void main(String[] args) {
		
		
		int[] arr = {1,2,3,4,2,5,6};
		int k = 2 , sum = 6;
		findCombinations(arr,k,sum);

	}


	private static void findCombinations(int[] arr,int k,int sum) {
		List<Integer> combination = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<>();
		Set<String> set = new HashSet<>();
		findCombinations(arr,0,combination,k,sum,result,set);
		
		
	}

}
