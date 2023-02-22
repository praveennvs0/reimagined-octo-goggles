package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfASet {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		subsetsOfASet(nums);
		
	}

	private static List<List<Integer>> subsetsOfASet(int[] nums) {
		List<List<Integer>> powerSet = new ArrayList<>();
		subsetsOfASet(nums,0,new ArrayList<Integer>(),powerSet);
		return powerSet;
	}

	private static void subsetsOfASet(int[] nums, int index, ArrayList<Integer> result, List<List<Integer>> powerSet) {
		powerSet.add(new ArrayList<>(result));
		for(int i=index;i<nums.length;i++) {
			result.add(nums[i]);		
		  subsetsOfASet(nums,i+1,result,powerSet);
		  
		  result.remove(result.size()-1);
		}
	}

}
