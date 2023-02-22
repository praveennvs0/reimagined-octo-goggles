package newPackage;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
	
	public static void main(String[] args) {
		int nums[] = {1,2,3};
		
		subsets(nums);
		
		
	}

	private static void subsets(int[] nums,int startIndex,List<Integer> combination, List<List<Integer>> result) {
		if(combination.size() > 0) {
				result.add(new ArrayList<Integer>(combination));
		}
		for(int i=startIndex;i < nums.length ; i++) {
			combination.add(nums[i]);
			subsets(nums,i+1,combination,result);
			combination.remove(combination.size()-1);
		}
		
	}

	
	 public static List<List<Integer>> subsets(int[] nums) {
		 List<List<Integer>> result = new ArrayList<>();
		 List<Integer> combination = new ArrayList<>();
		 subsets(nums,0,combination,result);
		 result.add(new ArrayList<Integer>());
		 return result;
	    }

	
}
