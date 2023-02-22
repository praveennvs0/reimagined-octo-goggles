import java.util.ArrayList;
import java.util.List;

public class CombinationSumIVLeetCode {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		int target = 4 ;
		
		List<Integer> result = new ArrayList<>();
		int count = combinationSum4(nums,target);
		System.out.println("no. of possible combinations is : " + count);
	}

	private static int combinationSum4(int[] nums, int target) {
		int count = combinationSum4(nums,target,0);
		return count;
	}

	private static int combinationSum4(int[] nums, int target, int currSum) {
		int count = 0;
		if(currSum > target) 
			return 0;
		
		if(currSum == target) {
			return 1;
		}
		
		for(int i=0; i < nums.length ; i++) {
			count = count + combinationSum4(nums,target,currSum + nums[i]);
		}
		
		return count;
		
	}

	private static void printCombination(List<Integer> result) {
		result.forEach(x-> {System.out.print(x);
							System.out.print(",");});
		System.out.println();
	}

}
